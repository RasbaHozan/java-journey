package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.tau.stepDef",
        plugin = {"pretty", "html:target/cucumber-pretty" , "json:target/cucumber.json"},
monochrome = true
)
public class TestRunners {
}

