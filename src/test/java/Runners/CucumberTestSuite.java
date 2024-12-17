package Runners;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("Cucumber")
@SelectClasspathResource("/features")
public class CucumberTestSuite {}
