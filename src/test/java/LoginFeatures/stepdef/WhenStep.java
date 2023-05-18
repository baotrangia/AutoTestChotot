package LoginFeatures.stepdef;

;
import LoginFeatures.locator.Locator;
import LoginFeatures.support.DataProvider;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class WhenStep extends StepDefinitions {
    Locator locator = new Locator();

    @When("the user clicks on button login")
    public void the_user_clicks_on_button_login() {
        locator.btn_login(driver).click();
    }

    @When("^the user fills on \"([^\"]*)\" with value \"([^\"]*)\"$")
    public void the_user_fills_info(String typeValue, String valueinput) {
        locator.txt_FilterInfo(driver,typeValue).sendKeys(valueinput);
    }

    @When("^the user fills on \"([^\"]*)\"$")
    public void the_user_fills_info(String typeValue) {
        locator.txt_FilterInfo(driver,typeValue).sendKeys((CharSequence) DataProvider.faker.lorem().words(2).toString());
    }

    @When("the user tries to login with facebook")
    public void the_user_clicks_on_facebook_icon() {
        Assert.assertTrue(locator.btn_login_facebook(driver).isDisplayed());
        locator.btn_login_facebook(driver).click();
    }

    @When("the user tries to login with google")
    public void the_user_clicks_on_google_icon() {
        Assert.assertTrue(locator.btn_login_google(driver).isDisplayed());
        locator.btn_login_google(driver).click();
    }

    @When("the user tries to login with apple")
    public void the_user_clicks_on_twitter_icon() {
        Assert.assertTrue(locator.btn_login_apple(driver).isDisplayed());
        locator.btn_login_apple(driver).click();
    }
}
