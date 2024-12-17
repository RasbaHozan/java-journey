package Ecommerce.practice.Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InMotionHostingSteps {

    @Managed
    WebDriver driver;
    Actor user = Actor.named("User").whoCan(BrowseTheWeb.with(driver));

    @Given("the user is on the InMotion Hosting homepage")
    public void theUserIsOnTheHomepage() {
        user.attemptsTo(
                Open.url("https://www.inmotionhosting.com/")
        );
    }
    @When("the user navigates to the Hosting Plans section")
    public void theUserNavigatesToHostingPlansSection() {
        user.attemptsTo(
                Click.on(By.linkText("Hosting Plans"))
        );
    }

    @When("the user selects a hosting plan")
    public void theUserSelectsHostingPlan() {
        user.attemptsTo(
                Click.on(By.xpath("//div[contains(@class,'hosting-plan-item')][1]"))
        );
    }
    @When("the user adds the hosting plan to the cart")
    public void theUserAddsHostingPlanToCart() {
        user.attemptsTo(
                Click.on(By.xpath("//button[contains(text(),'Add to Cart')]"))
        );
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        user.attemptsTo(
                Click.on(By.id("checkout-button"))
        );
    }

    @Then("the user should be redirected to the checkout page")
    public void theUserShouldBeOnCheckoutPage() {
        user.attemptsTo(
                Ensure.that(By.xpath("//h1[text()='Checkout']")).isDisplayed()
        );
    }
}
