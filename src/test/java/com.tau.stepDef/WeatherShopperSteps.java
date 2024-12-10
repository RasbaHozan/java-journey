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

public class WeatherShopperSteps {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("user opens the Weather Shopper homepage")
    public void userOpensHomepage() {
        driver.get("https://weathershopper.pythonanywhere.com/");
    }

    @Then("user should see the sunscreen product")
    public void userSeesProductSelection() {
        WebElement productSection = driver.findElement(By.cssSelector("div.text-center.col-4.offset-4"));
        assertTrue(productSection.isDisplayed());
    }

    @When("user looks for the {string} link in the footer")
    public void userLooksForAboutLinkInFooter(String linkText) {
        WebElement aboutLink = driver.findElement(By.linkText(linkText));
        assertTrue(aboutLink.isDisplayed());
    }

    @Then("the {string} link should be displayed and clickable")
    public void theAboutLinkShouldBeDisplayedAndClickable(String linkText) {
        WebElement aboutLink = driver.findElement(By.linkText(linkText));
        assertTrue(aboutLink.isDisplayed());
        aboutLink.click();
        assertTrue(driver.getCurrentUrl().contains("/about"));
    }
    @Given("user opens the Weather product page")
    public void userOpensproductPage() {
        driver.get("https://weathershopper.pythonanywhere.com/moisturizer");
    }

    @When("user selects the Alexander Almond & Honey Moisturiser and adds it to the cart")
    public void userSelectsAndAddsProductToCart() {
        WebElement product = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/button"));
        product.click();
    }

    @Then("user should see the product added to the cart")
    public void userShouldSeeProductInCart() {
        WebElement cartButton = driver.findElement(By.xpath("//*[@id=\"cart\"]"));
        cartButton.click();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
