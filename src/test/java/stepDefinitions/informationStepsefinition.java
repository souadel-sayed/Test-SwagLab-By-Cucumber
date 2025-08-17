package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.InformationPage;
import pageObjects.LoginPage;
import utils.TestContextSetup;

public class informationStepsefinition {
    TestContextSetup testContextSetup;
    InformationPage informationPage;
    public informationStepsefinition(TestContextSetup testContextSetup)
    {

        this.testContextSetup=testContextSetup;
        this.informationPage = testContextSetup.pageObjectManager.getinformationpage();

    }

    @Given("I am on the information page")
    public void i_am_on_the_information_page() {
        Assert.assertEquals(informationPage.getCurrentURL(), "https://www.saucedemo.com/checkout-step-one.html");

    }

    @When("Enter {string} and {string} and {string}")
    public void enter_firstname_and_lastname_and_zipcode(String Firstname, String Lastname, String Zipcode) {

        informationPage.fillInformationForm(Firstname, Lastname, Zipcode);
    }

    @When("click on Continue buttoun")
    public void click_on_continue_buttoun() {
        informationPage.clickContinueButton();
    }

    @Then("User proceeds to Overview page")
    public void user_proceeds_to_overview_page() {
        Assert.assertEquals(informationPage.getCurrentURL(), "https://www.saucedemo.com/checkout-step-two.html");
    }




}
