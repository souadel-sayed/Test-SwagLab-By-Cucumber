package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class HomeStepDefinition {
    TestContextSetup testContextSetup;
    LoginPage loginPage ;
    HomePage homePage;
    public HomeStepDefinition(TestContextSetup testContextSetup)
    {

        this.testContextSetup=testContextSetup;
        this.homePage = testContextSetup.pageObjectManager.gethomeStepDefinition();

    }
    @Given("I am on the hOME PAGE page")
            public void i_am_on_the_home_page()
    {

        homePage.navigateToHomePage();

    }
    @When("I clickon add {string} to cart")
    public void i_clickon_add_product_name_to_cart(String productName) {
        homePage.addSpecificProductToCart(productName);

    }
    @When("I click on the cart icon")
    public void i_click_on_the_cart_icon() {
        homePage.clickCartIcon();

    }
    @Then("User proceeds to Cart page")
    public void user_proceeds_to_cart_page() {
        Assert.assertEquals(homePage.getCurrentURL(),"https://www.saucedemo.com/cart.html");

    }



}
