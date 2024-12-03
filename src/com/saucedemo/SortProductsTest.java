package com.saucedemo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.Tag;

public class SortProductsTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver();
        System.out.println("Driver initialized.");
    }

    @Test
    @Tag("product")
    public void testSortOptions() {
        String baseUrl = Config.getBaseUrl();
        System.out.println("Opening the app URL: " + baseUrl);
        driver.get(baseUrl);

        System.out.println("Performing login...");
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys(Config.getEmail());
        passwordField.sendKeys(Config.getPassword());
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("inventory.html"));
        System.out.println("Login successful and redirected to inventory page.");

        WebElement sortDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product_sort_container")));
        
        System.out.println("Sorting products by Name (A to Z)...");
        sortDropdown.click();
        WebElement sortByNameOption = driver.findElement(By.xpath("//option[@value='az']"));
        sortByNameOption.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("inventory_item_name")));
        verifyProductOrder("Name (A to Z)");

        System.out.println("Sorting products by Name (Z to A)...");
        sortDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product_sort_container")));
        sortDropdown.click();
        WebElement sortByNameDescOption = driver.findElement(By.xpath("//option[@value='za']"));
        sortByNameDescOption.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("inventory_item_name")));
        verifyProductOrder("Name (Z to A)");

        System.out.println("Sorting products by Price (low to high)...");
        sortDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product_sort_container")));
        sortDropdown.click();
        WebElement sortByPriceLowToHighOption = driver.findElement(By.xpath("//option[@value='lohi']"));
        sortByPriceLowToHighOption.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("inventory_item_price")));
        verifyProductOrder("Price (low to high)");

        System.out.println("Sorting products by Price (high to low)...");
        sortDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product_sort_container")));
        sortDropdown.click();
        WebElement sortByPriceHighToLowOption = driver.findElement(By.xpath("//option[@value='hilo']"));
        sortByPriceHighToLowOption.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("inventory_item_price")));
        verifyProductOrder("Price (high to low)");

        System.out.println("All sorting options verified successfully.");
        driver.quit();
    }

    private void verifyProductOrder(String sortType) {
        System.out.println("Verifying product order: " + sortType);
        List<WebElement> productPrices = driver.findElements(By.className("inventory_item_price"));
        boolean isSorted = true;

        if (sortType.contains("Price")) {
            for (int i = 0; i < productPrices.size() - 1; i++) {
                double price1 = Double.parseDouble(productPrices.get(i).getText().replace("$", ""));
                double price2 = Double.parseDouble(productPrices.get(i + 1).getText().replace("$", ""));
                if ((price1 > price2 && sortType.equals("Price (low to high)")) ||
                    (price1 < price2 && sortType.equals("Price (high to low)"))) {
                    isSorted = false;
                    break;
                }
            }
        } else if (sortType.contains("Name")) {
            List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
            for (int i = 0; i < productNames.size() - 1; i++) {
                String name1 = productNames.get(i).getText();
                String name2 = productNames.get(i + 1).getText();
                if ((name1.compareToIgnoreCase(name2) > 0 && sortType.equals("Name (A to Z)")) ||
                    (name1.compareToIgnoreCase(name2) < 0 && sortType.equals("Name (Z to A)"))) {
                    isSorted = false;
                    break;
                }
            }
        }

        Assert.assertTrue("Products are not sorted correctly by " + sortType, isSorted);
        System.out.println("Verified product order successfully for: " + sortType);
    }
}
