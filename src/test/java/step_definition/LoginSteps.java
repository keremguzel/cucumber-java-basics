package step_definition;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utilities.Driver;

public class LoginSteps{


    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Before
    public void setUp(){
        Driver.setUp();
    }

    @After
    public void tearDown(){
        Driver.tearDown();
    }

    @Given("User is on the login page")
    public void user_is_on_the_login_page(){
        loginPage.navigateToLoginPage("https://practicetestautomation.com/practice-test-login/");
    }
    @When("User is typing a correct username {string}")
    public void type_username(String username){
        loginPage.typeUsername(username);
    }

    @And("^User is typing a wrong password \"([^\"]*)\"$")
    public void type_wrong_password(String password){
        loginPage.typePassword(password);
    }

    @And("User is typing a correct password {string}")
    public void type_correct_password(String password){
        loginPage.typePassword(password);
    }

    @And("User click the login button")
    public void click_login_button(){
        loginPage.clickLoginButton();
    }

    @Then("User gets an error message")
    public void user_gets_an_error_message() {
        Assert.assertEquals(loginPage.readMessage(), "Your password is invalid!");
    }

    @Then("User is navigated to home page")
    public void user_is_on_homepage(){
        Assert.assertTrue(homePage.checkElement());
    }

}
