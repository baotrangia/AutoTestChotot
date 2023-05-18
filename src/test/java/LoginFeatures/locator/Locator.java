package LoginFeatures.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locator {

    private WebElement webElement;

    public WebElement btn_account(WebDriver driver){
        webElement =  driver.findElement(By.id("btnundefinedundefined"));
        return webElement;
    }

    public WebElement txt_loginText(WebDriver driver, String textValue){
        webElement =  driver.findElement(By.xpath("//span[text() ='"+textValue+"']"));
        return webElement;
    }

    public WebElement hrefLoginFrom(WebDriver driver, String textValue){
        webElement =  driver.findElement(By.xpath("//span[text() ='"+textValue+"']"));
        return webElement;
    }

    public WebElement btn_login(WebDriver driver){
        webElement =  driver.findElement(By.xpath("//button[@type='submit']"));
        return webElement;
    }

    public WebElement errorMsg(WebDriver driver){
        webElement =  driver.findElement(By.className("e66t3pu error"));
        return webElement;
    }

    public WebElement txt_FilterInfo(WebDriver driver, String typeValue){
        webElement =  driver.findElement(By.xpath("//input[type() ='"+typeValue+"']"));
        return webElement;
    }

    public WebElement btn_login_facebook(WebDriver driver){
        webElement =  driver.findElement(By.xpath("//li[contains(@style, '/LOGIN/facebook.svg')]"));
        return webElement;
    }

    public WebElement btn_login_google(WebDriver driver){
        webElement =  driver.findElement(By.xpath("//li[contains(@style, '/LOGIN/google.svg')]"));
        return webElement;
    }

    public WebElement btn_login_apple(WebDriver driver){
        webElement =  driver.findElement(By.xpath("//li[contains(@style, '/LOGIN/apple.svg')]"));
        return webElement;
    }
}
