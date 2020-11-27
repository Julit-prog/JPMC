package testRuner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features=".//Features/Search.feature",
        glue = "stepDefinitions",
        plugin = {"pretty","junit:target/cucumber-reports/testReport.xml"}
//        monochrome = true
)
public class testRunner {
}
