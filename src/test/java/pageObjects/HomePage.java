package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import utils.TestContextSetup;
import utils.GenericUtils;

public class HomePage extends GenericUtils {
    public WebDriver driver;
    TestContextSetup testContextSetup;

    public HomePage(WebDriver driver)
    {
        super(driver);

    }
    By cartIcon = By.cssSelector("[data-test='shopping-cart-link']");

    public HomePage navigateToHomePage() {
        //code
        navigateToURL("https://www.saucedemo.com/inventory.html");
        return this;
    }
    public HomePage addSpecificProductToCart(String productName) {
        //code
        By addToCartButton = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[.='" + productName + "']"));
        click(addToCartButton);
        return this;
    }

    public CartPage clickCartIcon() {
        //code
       click(cartIcon);
        return new CartPage(driver);
    }

    //validations
    public HomePage assertProductAddedToCart(String productName) {
        //code
        By addToCartButton = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[.='" + productName + "']"));
        String actualValue = getText(addToCartButton);
        Assert.assertEquals(actualValue, "Remove", "Product not added to cart");
        return this;
    }
}
