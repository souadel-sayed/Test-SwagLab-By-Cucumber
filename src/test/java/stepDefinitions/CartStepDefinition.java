package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.InformationPage;
import pageObjects.LoginPage;
import utils.CustomSoftAssertion;
import utils.GenericUtils;
import utils.TestContextSetup;


public class CartStepDefinition {
    TestContextSetup testContextSetup;
    LoginPage loginPage ;
    HomePage homePage;
    CartPage cartPage;
    public CartStepDefinition(TestContextSetup testContextSetup)
    {

        this.testContextSetup=testContextSetup;
        this.cartPage = testContextSetup.pageObjectManager.getcartpage();

    }

    @Given("I am on the cart page")
    public void i_am_on_the_cart_page() {
        Assert.assertEquals(cartPage.getCurrentURL(), "https://www.saucedemo.com/cart.html");

    }
    @When("verify product as expected")
    public void verify_product_as_expected() {
        cartPage.assertProductDetails("Sauce Labs Bolt T-Shirt","$15.99");

    }


    @When("I click on the check out icon")
    public void i_click_on_the_check_out_icon() {
        cartPage.clickCheckoutButton();
    }

    @Then("User proceeds to information page")
    public void user_proceeds_to_information_page() {
        Assert.assertEquals(cartPage.getCurrentURL(), "https://www.saucedemo.com/checkout-step-one.html");
    }

}
