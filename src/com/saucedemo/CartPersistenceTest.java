package com.saucedemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Tag;
import static org.junit.Assert.assertTrue;

public class CartPersistenceTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver();
        
        System.out.println("Opening the app URL: " + Config.getBaseUrl());
        driver.get(Config.getBaseUrl());
    }

    @Test
    @Tag("cart")
    public void testCartPersistenceAfterLogout() {
        System.out.println("Performing login...");
        driver.findElement(By.id("user-name")).sendKeys(Config.getEmail());
        driver.findElement(By.id("password")).sendKeys(Config.getPassword());
        driver.findElement(By.id("login-button")).click();

        System.out.println("Adding item to the cart...");
        WebElement addItemButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addItemButton.click();

        System.out.println("Verifying cart item count...");
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_badge"));
        String cartItemCount = cartIcon.getText();
        assertTrue("Cart is empty after adding item", Integer.parseInt(cartItemCount) > 0);
        System.out.println("Item added to the cart. Cart count: " + cartItemCount);

        System.out.println("Logging out...");
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();
        driver.findElement(By.id("logout_sidebar_link")).click();

        System.out.println("Performing login again...");
        driver.findElement(By.id("user-name")).sendKeys(Config.getEmail());
        driver.findElement(By.id("password")).sendKeys(Config.getPassword());
        driver.findElement(By.id("login-button")).click();

        System.out.println("Verifying cart item count after logging in...");
        cartIcon = driver.findElement(By.className("shopping_cart_badge"));
        String cartItemCountAfterLogin = cartIcon.getText();
        assertTrue("Cart is empty after logging in again", Integer.parseInt(cartItemCountAfterLogin) > 0);
        System.out.println("Cart count after login: " + cartItemCountAfterLogin);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Closing the browser.");
        }
    }
}
