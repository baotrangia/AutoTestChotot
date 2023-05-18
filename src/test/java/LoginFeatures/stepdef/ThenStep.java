package LoginFeatures.stepdef;

import LoginFeatures.locator.Locator;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public class ThenStep extends StepDefinitions{

    Locator locator = new Locator();

    @Then("^the user sees \"([^\"]*)\" on the dropdown$")
    public void the_user_sees_on_the_dropdown(String textValue) throws Throwable {
        Assert.assertTrue(locator.txt_loginText(driver, textValue).isDisplayed());
    }

    @Then("^the user sees error messages \"([^\"]*)\" is displayed$")
    public void the_user_sees_error_messages_is_displayed(String errMsg){
        waitElement(By.className("e66t3pu error"));
        Assert.assertEquals(errMsg, locator.errorMsg(driver).toString());
    }

    @Then("switch to handles window")
    public void switch_to_handles_window() throws Throwable {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String handle = it.next();
        String next = it.next();
        driver.switchTo().window(next);
        Thread.sleep(3000);
    }

    @Then("the user sees title \"([^\"]*)\" on the new window")
    public void the_user_sees_title_on_the_new_window(String title){
        Assert.assertEquals(title, driver.getTitle());
    }

}
