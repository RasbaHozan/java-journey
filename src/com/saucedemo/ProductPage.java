package com.saucedemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Tag;
public class ProductPage {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver(); 
    }

    @Test
    @Tag("product") 
    public void testAddAndRemoveItemsFromProductPage() {
        System.out.println("Opening the app URL: " + Config.getBaseUrl());
        driver.get(Config.getBaseUrl());

        System.out.println("Performing login...");
        driver.findElement(By.id("user-name")).sendKeys(Config.getEmail());
        driver.findElement(By.id("password")).sendKeys(Config.getPassword());
        driver.findElement(By.id("login-button")).click();

        System.out.println("Verifying that products page is displayed...");
        assertTrue("Products page is not displayed",
            driver.findElement(By.className("inventory_list")).isDisplayed());
        System.out.println("Products page is displayed successfully.");

        System.out.println("Adding an item to the cart...");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        System.out.println("Verifying the cart icon updates...");
        String cartBadge = driver.findElement(By.className("shopping_cart_badge")).getText();
        assertTrue("Cart badge does not display the correct count", cartBadge.equals("1"));
        System.out.println("Cart icon updated successfully.");

        System.out.println("Removing the item from the cart...");
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        System.out.println("Verifying the cart badge is removed...");
        assertTrue("Cart badge is not removed",
            driver.findElements(By.className("shopping_cart_badge")).isEmpty());

        System.out.println("Verifying 'Add to Cart' button reappears...");
        assertTrue("Add to Cart button did not reappear",
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).isDisplayed());
        System.out.println("Item was removed, and 'Add to Cart' button is visible again.");
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); 
        }
    }
}
