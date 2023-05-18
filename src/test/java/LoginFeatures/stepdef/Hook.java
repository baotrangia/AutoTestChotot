package LoginFeatures.stepdef;

import cucumber.api.Scenario;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class Hook extends StepDefinitions {
    @Before
    public void setUp() throws IOException, ParseException {
        Open_browser();
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }
        driver.quit();
    }
}
