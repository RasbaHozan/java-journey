package com.saucedemo; 
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {

    public static WebDriver getDriver() {
        String browser = Config.getBrowser(); 
        WebDriver driver = null;

        try {
          
            DesiredCapabilities capabilities = new DesiredCapabilities();

            if (browser.equalsIgnoreCase("chrome")) {
                capabilities.setCapability("browserName", "chrome");
            } else if (browser.equalsIgnoreCase("firefox")) {
                capabilities.setCapability("browserName", "firefox");
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            String hubUrl = Config.getHubUrl();

            System.out.println("Using Selenium Grid Hub URL: " + hubUrl);

            URL gridUrl = new URL(hubUrl);  

            driver = new RemoteWebDriver(gridUrl, capabilities);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while setting up WebDriver: " + e.getMessage());
        }

        return driver;
    }
}
