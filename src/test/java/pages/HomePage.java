package pages;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {

    WebDriver driver;

    public HomePage() {
        this.driver = setUp();
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(className="post-header")
    private WebElement homePageHeader;

    public boolean checkElement(){
        return elementIsVisible(homePageHeader);
    }
}
