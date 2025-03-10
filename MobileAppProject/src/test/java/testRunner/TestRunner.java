package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/ProjectFeatures.feature",
        glue = "stepDefinitions",
        plugin= {"pretty","html:target/MobileAppProject.html"}
)
public class TestRunner {

}
