package com.tau.stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import java.time.Duration;
import org.junit.Assert;

public class BuyItemSteps {

    WebDriver driver;

    @Before
    public void setUp() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
    }

    @Given("user logs in with username {string} and password {string}")
    public void userLogsInWithUsernameAndPassword(String username, String password) {
        driver.get("https://www.saucedemo.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @When("user selects a product and adds it to the cart")
    public void userSelectsAProductAndAddsItToTheCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".inventory_item")));
        product.click();

        WebElement addToCartButton = driver.findElement(By.cssSelector(".btn_inventory"));
        addToCartButton.click();
    }

    @When("user proceeds to checkout")
    public void userProceedsToCheckout() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shopping_cart_link")));
        cartIcon.click();

        WebElement checkoutButton = driver.findElement(By.cssSelector(".checkout_button"));
        checkoutButton.click();
    }

    @Then("user should be redirected to the checkout page")
    public void userShouldBeRedirectedToTheCheckoutPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkoutPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("checkout_info")));
        Assert.assertTrue("Checkout page is not displayed", checkoutPage.isDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
