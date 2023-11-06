package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

public abstract class Base extends Driver{
    private WebDriver driver = Driver.setUp();
    WebDriverWait wait = new WebDriverWait(driver,10);


    public void navigate(String url){
        driver.get(url);
    }

    public void clickElement(WebElement locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        locator.click();
    }

    public void sendKey(WebElement locator, String key){
        locator.sendKeys(key);
    }

    public boolean elementIsVisible(WebElement locator){
        return locator.isDisplayed();
    }

    public String readElementValue(WebElement locator){
        return locator.getText();
    }
}
