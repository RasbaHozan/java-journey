package com.saucedemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Tag;
public class LoginTest {

    private WebDriver driver;
    
    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver();  
    }
  
    @Test
    @Tag("smoke")           
    public void testSuccessfulLogin() {
        
        System.out.println("Opening the app URL: " + Config.getBaseUrl());
        driver.get(Config.getBaseUrl());

        System.out.println("Performing login with username '" + Config.getEmail() + "' and password '" + Config.getPassword() + "'");
        driver.findElement(By.id("user-name")).sendKeys(Config.getEmail());
        driver.findElement(By.id("password")).sendKeys(Config.getPassword());
        driver.findElement(By.id("login-button")).click();

    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
