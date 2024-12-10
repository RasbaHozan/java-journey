package com.tau.stepDef;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class CheckboxStepDefinitions {

    WebDriver driver;

    // Initialize the WebDriver before each scenario
    @Before
    public void setUp() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
    }

    // Checkbox feature step definitions
    @Given("user opens the {string} page")
    public void userOpensPage(String pageName) {
        driver.get("http://the-internet.herokuapp.com/" + pageName);
    }

    @When("user checks the first checkbox")
    public void userChecksTheFirstCheckbox() {
        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(1)"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    @Then("the first checkbox should be checked")
    public void theFirstCheckboxShouldBeChecked() {
        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(1)"));
        assertTrue(checkbox.isSelected());
    }

    @When("user unchecks the first checkbox")
    public void userUnchecksTheFirstCheckbox() {
        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(1)"));
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    @Then("the first checkbox should be unchecked")
    public void theFirstCheckboxShouldBeUnchecked() {
        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(1)"));
        assertFalse(checkbox.isSelected());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
