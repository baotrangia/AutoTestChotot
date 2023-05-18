package LoginFeatures.stepdef;

import LoginFeatures.support.DataProvider;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class StepDefinitions {

    public static WebDriver driver;
    DataProvider dataProvider = new DataProvider();
    public void switchTab(String tab) {
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals(tab)) {
                System.out.println(driver.getTitle());
            }
        }
    }

    public WebElement waitUntilDisplayed(@Nonnull By by) {
        return new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilInvisible(@Nonnull By by) {
        new WebDriverWait(driver, 5)
                .ignoring(ClassNotFoundException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }



    protected WebDriver createLocalChromeDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("use-fake-device-for-media-stream");
        options.addArguments("use-fake-ui-for-media-stream");
        options.setHeadless(isHeadless());
        options.setAcceptInsecureCerts(true);

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
        prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
        prefs.put("profile.default_content_setting_values.geolocation", 1);
        prefs.put("profile.default_content_setting_values.notifications", 1);
        options.setExperimentalOption("prefs", prefs);

        return new ChromeDriver(options);
    }

    public boolean isHeadless() {
        return System.getProperty("headless", "false").equals("true");
    }

     protected WebDriver createLocalFireFox() {

        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        options.setProfile(profile);
        options.setHeadless(isHeadless());
        options.addPreference("dom.webnotifications.enabled", true);
        options.addPreference("geo.enabled", true);
        options.addPreference("geo.provider.use_corelocation", true);
        options.addPreference("geo.prompt.testing", true);
        options.addPreference("geo.prompt.testing.allow", true);
        return new FirefoxDriver(options);
    }

    public void Open_browser() throws IOException, ParseException {
        String browser = dataProvider.getData();
        switch (browser) {
            case "chrome":
                driver = createLocalChromeDriver();
                break;
            case "firefox":
                driver = createLocalFireFox();
                break;
            default:
                System.out.println("Browser not found");
        }
        driver.manage().window().maximize();
        driver.get("https://www.chot.com");
    }

    public void waitElement(By webElement) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElements(webElement).size() > 0);
    }
}
