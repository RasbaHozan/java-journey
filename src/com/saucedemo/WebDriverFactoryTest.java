package com.saucedemo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.After;

public class WebDriverFactoryTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        
        driver = WebDriverFactory.getDriver();
    }

    @Test
    public void testWebDriverInitialization() {
        assertNotNull(driver, "WebDriver should be initialized properly");

        driver.get(Config.getBaseUrl());
    }

    @After
    public static void tearDown() {
        if (driver != null) {
            WebDriverFactory.getDriver();
        }
    }
}
