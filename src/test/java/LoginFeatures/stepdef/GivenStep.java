package LoginFeatures.stepdef;


import LoginFeatures.locator.Locator;
import cucumber.api.java.en.Given;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;

public class GivenStep extends StepDefinitions {
    Locator locator = new Locator();
    private String title = "Chợ Tốt - Website Mua Bán, Rao Vặt Trực Tuyến Hàng Đầu Của Người Việt";
    public GivenStep() throws InterruptedException {
    }
    @Given("^the user opens the web page$")
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
        driver.get("https://id.chotot.com/?continue=https%3A%2F%2Fwww.chotot.com%2F/");
        Assert.assertEquals(title, driver.getTitle());
    }

    @Given("the user open the login form")
    public void openLoginPage(){
        locator.btn_account(driver).click();
    }
}
