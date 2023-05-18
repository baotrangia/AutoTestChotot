package LoginFeatures;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/resources/feature"},
        glue = "LoginFeatures",
        tags = "@tag1",
        plugin = {
                "html:target/result",
                "pretty",
                "json:target/test-classes/reports/result.json"
        },
        monochrome = true
)
public class  CucumberTestRunner extends AbstractTestNGCucumberTests {
}