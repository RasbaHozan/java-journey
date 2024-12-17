package heroku.app.steps;

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

public class LoginSteps {

    @Managed
    WebDriver driver;
    Actor user = Actor.named("User").whoCan(BrowseTheWeb.with(driver));

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        user.attemptsTo(
                Open.url("http://the-internet.herokuapp.com/login")
        );
    }

    @When("the user enters a valid username {string} and password {string}")
    public void theUserEntersValidCredentials(String username, String password) {
        user.attemptsTo(
                Enter.theValue(username).into(By.id("username")),
                Enter.theValue(password).into(By.id("password")),
                Click.on(By.cssSelector("button[type='submit']"))
        );
    }

    @When("the user enters an invalid username {string} and password {string}")
    public void theUserEntersInvalidCredentials(String username, String password) {
        user.attemptsTo(
                Enter.theValue(username).into(By.id("username")),
                Enter.theValue(password).into(By.id("password")),
                Click.on(By.cssSelector("button[type='submit']"))
        );
    }

    @Then("the user should be redirected to the secure area")
    public void theUserIsRedirectedToSecureArea() {
        user.attemptsTo(
                Ensure.that(By.cssSelector(".example")).isDisplayed()
        );
    }

    @Then("the user should see an error message")
    public void theUserSeesErrorMessage() {
        user.attemptsTo(
                Ensure.that(By.id("flash")).text().contains("Your username is invalid!")
        );
    }

    @Given("the user is logged in and on the secure area page")
    public void theUserIsLoggedInAndOnTheSecureAreaPage() {
        theUserIsOnTheLoginPage();
        theUserEntersValidCredentials("tomsmith", "SuperSecretPassword!");
    }

    @When("the user clicks the logout button")
    public void theUserClicksLogoutButton() {
        user.attemptsTo(
                Click.on(By.cssSelector("a[href='/logout']"))
        );
    }

    @Then("the user should be redirected to the login page")
    public void theUserIsRedirectedToLoginPage() {
        user.attemptsTo(
                Ensure.that(By.id("login")).isDisplayed()
        );
    }
}


