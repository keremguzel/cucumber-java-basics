package step_definition;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import pages.HomePage;
import pages.LoginPage;
import utilities.Driver;

public class LoginSteps {


    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Before
    public void setUp() {
        Driver.setUp();
    }

    @After
    public void tearDown() {
        Driver.tearDown();
    }

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        loginPage.navigateToLoginPage("https://practicetestautomation.com/practice-test-login/");
    }

    @When("User is typing a correct username {string}")
    public void type_username(String username) {
        loginPage.typeUsername(username);
    }

    @And("User is typing a wrong username {string}")
    public void type_wrong_username(String username) {
        loginPage.typeUsername(username);
    }

    @And("^User is typing a wrong password \"([^\"]*)\"$")
    public void type_wrong_password(String password) {
        loginPage.typePassword(password);
    }

    @And("User is typing a correct password {string}")
    public void type_correct_password(String password) {
        loginPage.typePassword(password);
    }

    @And("User click the login button")
    public void click_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User gets an error message for wrong password")
    public void error_message_for_password() {
        Assert.assertEquals(loginPage.readMessage(), "Your password is invalid!");
    }

    @Then("User gets an error message for wrong username")
    public void error_message_for_username() {
        Assert.assertEquals(loginPage.readMessage(), "Your username is invalid!");
    }

    @Then("User is navigated to home page")
    public void user_is_on_homepage() {
        Assert.assertTrue(homePage.checkElement());
    }

}
