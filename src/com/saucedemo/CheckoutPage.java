package com.saucedemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Tag;
public class CheckoutPage {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver();
    }

    @Test
    @Tag("checkout")
    public void testCheckout() {
       
        System.out.println("Opening the app URL: " + Config.getBaseUrl());
        driver.get(Config.getBaseUrl());

        System.out.println("Performing login...");
        driver.findElement(By.id("user-name")).sendKeys(Config.getEmail());
        driver.findElement(By.id("password")).sendKeys(Config.getPassword());
        driver.findElement(By.id("login-button")).click();

        System.out.println("Adding item to the cart...");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        System.out.println("Navigating to the cart page...");
        driver.findElement(By.className("shopping_cart_link")).click();

        System.out.println("Removing the item from the cart...");
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        System.out.println("Verifying the cart is empty...");
        assertTrue("Cart is not empty", driver.findElements(By.className("cart_item")).isEmpty());

        System.out.println("Verifying cart badge is empty...");
        assertTrue("Cart badge is not empty", driver.findElements(By.className("shopping_cart_badge")).isEmpty());

        
        System.out.println("Proceeding to checkout...");
        driver.findElement(By.id("checkout")).click();

        System.out.println("Entering user information...");
        driver.findElement(By.id("first-name")).sendKeys("Abc");
        driver.findElement(By.id("last-name")).sendKeys("xyz");
        driver.findElement(By.id("postal-code")).sendKeys("8910");
        driver.findElement(By.id("continue")).click();

        System.out.println("Finishing checkout...");
        driver.findElement(By.id("finish")).click();

        System.out.println("Verifying confirmation...");
        assertTrue(driver.findElement(By.className("complete-header")).getText().contains("Thank you for your order!"));
        System.out.println("Test passed! Checkout completed successfully.");
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); 
        }
    }
}
