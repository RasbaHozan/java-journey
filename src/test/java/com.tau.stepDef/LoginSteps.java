package com.tau.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class LoginSteps {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("User is on the login page of the Sauce Demo application")
    public void userIsOnTheLoginPageOfTheSauceDemoApplication() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("user enters username and password")
    public void userEntersCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user should see the homepage with products")
    public void verifyHomepage() {
        Assert.assertTrue(driver.findElement(By.className("inventory_list")).isDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
