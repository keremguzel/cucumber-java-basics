package pages;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {

    WebDriver driver;
    public LoginPage() {
        this.driver = setUp();
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(id="username")
    private WebElement usernameTextBox;

    @FindBy(id="password")
    private WebElement passwordTextBox;

    @FindBy(id="submit")
    private WebElement loginButton;

    @FindBy(id="error")
    private WebElement errorMessage;

    public void navigateToLoginPage(String url){
        navigate(url);
    }

    public void clickLoginButton(){
        clickElement(loginButton);
    }

    public void typeUsername(String username){
        sendKey(usernameTextBox,username);
    }

    public void typePassword(String password){
        sendKey(passwordTextBox,password);
    }

    public String readMessage(){
        return readElementValue(errorMessage);
    }
}
