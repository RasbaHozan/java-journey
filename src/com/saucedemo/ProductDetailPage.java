package com.saucedemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Tag;

public class ProductDetailPage {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver();
    }

    @Test
    @Tag("product")
    public void testAddAndRemoveItemsFromProductDetailsPage() {
        System.out.println("Opening the app URL: " + Config.getBaseUrl());
        driver.get(Config.getBaseUrl());

        System.out.println("Performing login...");
        driver.findElement(By.id("user-name")).sendKeys(Config.getEmail());
        driver.findElement(By.id("password")).sendKeys(Config.getPassword());
        driver.findElement(By.id("login-button")).click();

        System.out.println("Verifying that the products page is displayed...");
        assertTrue("Products page is not displayed", 
            driver.findElement(By.className("inventory_list")).isDisplayed());
        System.out.println("Products page is displayed successfully.");

        WebElement productLink = driver.findElement(By.cssSelector("img[alt='Sauce Labs Backpack']")); 
        productLink.click();

        System.out.println("Adding the product to the cart...");
        driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();

        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        String cartBadge = cartIcon.getText();
        assertTrue("Cart badge does not display the correct count", cartBadge.equals("1"));
        System.out.println("Cart icon updated successfully.");

        System.out.println("Removing the product from the cart...");
        driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();

        cartBadge = cartIcon.getText();
        assertTrue("Cart badge is not updated correctly", cartBadge.equals(""));
        System.out.println("Cart badge is removed successfully.");

        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
        assertTrue("'Add to Cart' button did not reappear", addToCartButton.isDisplayed());
        System.out.println("The 'Add to Cart' button reappears after removing the product.");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  
        }
    }
}
