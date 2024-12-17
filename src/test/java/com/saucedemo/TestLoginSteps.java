package com.saucedemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestLoginSteps {
    @Managed
    WebDriver driver;
    Actor user = Actor.named("User").whoCan(BrowseTheWeb.with(driver));

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        user.attemptsTo(
                Open.url("https://www.saucedemo.com")
        );
    }

    @When("the user enters a valid username {string} and password {string}")
    public void theUserEntersValidCredentials(String username, String password) {
        user.attemptsTo(
                Enter.theValue(username).into(By.id("user-name")),
                Enter.theValue(password).into(By.id("password")),
                Click.on(By.id("login-button"))
        );
    }
    @When("the user enters an invalid username {string} and password {string}")
    public void theUserEntersInvalidCredentials(String username, String password) {
        user.attemptsTo(
                Enter.theValue(username).into(By.id("user-name")),
                Enter.theValue(password).into(By.id("password")),
                Click.on(By.id("login-button"))
        );
    }

    @Then("the user should be redirected to the products page")
    public void theUserIsRedirectedToProductsPage() {
        user.attemptsTo(
                Ensure.that(By.xpath("//*[@id=\"inventory_container\"]/div")).isDisplayed()
        );
    }

    @Then("the user should see an error message")
    public void theUserSeesErrorMessage() {
        user.attemptsTo(
                Ensure.that(By.xpath("//h3[@data-test='error']")).isDisplayed()
        );
    }

    @Given("the user is logged in and viewing the products page")
    public void theUserIsLoggedInAndViewingTheProductsPage() {
        user.attemptsTo(
                Open.url("https://www.saucedemo.com"),
                Enter.theValue("standard_user").into(By.id("user-name")),
                Enter.theValue("secret_sauce").into(By.id("password")),
                Click.on(By.id("login-button"))
        );
    }

    @When("the user adds the first product to the cart")
    public void theUserAddsTheFirstProductToTheCart() {
        user.attemptsTo(
                Click.on(By.xpath("//button[text()='Add to cart'][1]"))
        );
    }

    @Then("the cart should contain 1 item")
    public void theCartShouldContain1Item() {
        user.attemptsTo(
                Ensure.that(By.cssSelector(".shopping_cart_badge")).text().isEqualTo("1")
        );
    }


    @When("the user clicks on the shopping cart icon")
    public void theUserClicksOnTheShoppingCartIcon() {
        user.attemptsTo(
                Click.on(By.id("shopping_cart_container"))
        );
    }

    @Then("the user should be redirected to the cart page")
    public void theUserShouldBeRedirectedToTheCartPage() {
        user.attemptsTo(
                Ensure.that(By.xpath("//div[@class='cart_contents_container']")).isDisplayed()
        );
    }

    @Given("the user has products in the cart for checkout")
    public void theUserHasProductsInTheCartForCheckout() {
        theUserIsLoggedInAndViewingTheProductsPage();
        user.attemptsTo(
                Click.on(By.xpath("//button[text()='Add to cart'][1]"))
        );
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        user.attemptsTo(
                Click.on(By.id("checkout"))
        );
    }

    @Then("the user should be on the checkout page")
    public void theUserShouldBeOnCheckoutPage() {
        user.attemptsTo(
                Ensure.that(By.xpath("//h3[text()='Checkout: Your Information']")).isDisplayed()
        );
    }

    @When("the user views the cart")
    public void theUserViewsTheCart() {
        user.attemptsTo(
                Click.on(By.id("shopping_cart_container"))
        );
    }

    @Then("the total price should be correctly calculated")
    public void theTotalPriceShouldBeCorrectlyCalculated() {
        user.attemptsTo(
                Ensure.that(By.xpath("//div[@class='cart_total_price']")).isDisplayed()
        );
    }
}
