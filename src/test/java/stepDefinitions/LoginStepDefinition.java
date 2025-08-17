package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.LoginPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class LoginStepDefinition {

    TestContextSetup testContextSetup;
    LoginPage loginPage ;
    public LoginStepDefinition(TestContextSetup testContextSetup)
    {

        this.testContextSetup=testContextSetup;
        this.loginPage = testContextSetup.pageObjectManager.getloginPage();

    }


    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loginPage.navigateToLoginPage();

    }
    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String string, String string2) {
       loginPage.enterUsername(string);
       loginPage.enterPassword(string2);
        loginPage.clickLoginButton();
    }
    @Then("User proceeds to Products page")
    public void user_proceeds_to_products_page() {
        Assert.assertEquals(loginPage.getCurrentURL(), "https://www.saucedemo.com/inventory.html");

    }

    @Then("give me error message: Epic sadface: Username and password do not match any user in this service")
    public void give_me_error_message_Epic_sadface_Username_and_password_do_not_match_any_user_in_this_service() {
        Assert.assertEquals(loginPage.getErrorMessage().contains("Epic sadface: Username and password do not match any user in this service"),true);
    }



    @Then("give me error message:Epic sadface: Username is required")
    public void give_me_error_message_Epic_sadface_Username_is_required() {
    Assert.assertEquals(loginPage.getErrorMessage().contains("Epic sadface: Username is required"),true);
    }

    @Then("give me error message:Epic sadface: Password is required")
    public void give_me_error_message_Epic_sadface_Password_is_required() {
        Assert.assertEquals(loginPage.getErrorMessage().contains("Epic sadface: Password is required"),true);
    }

    @Then("give me error message:Epic sadface: Password is invalid")
    public void give_me_error_message_Epic_sadface_Password_is_invalid() {
    Assert.assertEquals(loginPage.getErrorMessage().contains("Epic sadface: Password is invalid"),true);
    }


}
