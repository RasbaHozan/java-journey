package com.saucedemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Tag;

public class BuyItemsTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        
        driver = WebDriverFactory.getDriver(); 
        System.out.println("Opening the app URL: " + Config.getBaseUrl());
        driver.get(Config.getBaseUrl());
    }

    @Test
    @Tag("smoke")
    public void testAddToCartAndCheckout() {
        System.out.println("Performing login...");
        driver.findElement(By.id("user-name")).sendKeys(Config.getEmail());
        driver.findElement(By.id("password")).sendKeys(Config.getPassword());
        driver.findElement(By.id("login-button")).click();

        System.out.println("Adding item to the cart...");
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();

        System.out.println("Verifying cart icon...");
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_badge"));
        assert cartIcon.getText().equals("1") : "Cart icon does not show correct number of items!";
        System.out.println("Cart icon updated to 1 item.");

        System.out.println("Navigating to the cart...");
        driver.findElement(By.className("shopping_cart_link")).click();

        System.out.println("Verifying item is in the cart...");
        WebElement cartItem = driver.findElement(By.className("cart_item"));
        assert cartItem.isDisplayed() : "Item not found in cart!";
        System.out.println("Item found in cart.");

        System.out.println("Proceeding to checkout...");
        driver.findElement(By.id("checkout")).click();

        System.out.println("Entering user details...");
        driver.findElement(By.id("first-name")).sendKeys("Abc");
        driver.findElement(By.id("last-name")).sendKeys("xyz");
        driver.findElement(By.id("postal-code")).sendKeys("8910");
        driver.findElement(By.id("continue")).click();

        System.out.println("Verifying item in checkout...");
        WebElement checkoutItem = driver.findElement(By.className("inventory_item_name"));
        assert checkoutItem.getText().equals("Sauce Labs Backpack") : "Incorrect item in checkout!";
        System.out.println("Correct item in checkout.");

        System.out.println("Completing purchase...");
        driver.findElement(By.id("finish")).click();

        System.out.println("Verifying confirmation message...");
        WebElement confirmationMessage = driver.findElement(By.className("complete-header"));
        assert confirmationMessage.getText().equals("Thank you for your order!") : "Purchase not successful!";
        System.out.println("Purchase successful. Thank you for your order!");
    }

    @After
    public void tearDown() {
        driver.quit();
        System.out.println("Closing the browser.");
    }
}
