package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CustomSoftAssertion;
import utils.GenericUtils;
import utils.TestContextSetup;

public class CartPage extends GenericUtils {
    public WebDriver driver;
    TestContextSetup testContextSetup;

    public CartPage(WebDriver driver)
    {
        super(driver);

    }

     By productName = By.cssSelector(".inventory_item_name");
     By productPrice = By.cssSelector(".inventory_item_price");
     By checkoutButton = By.cssSelector(".checkout_button");
    //code

    private String getProductName() {
        //code
        return getText(productName);
    }

    private String getProductPrice() {
        //code
        return  getText(productPrice);
    }

    public InformationPage clickCheckoutButton() {
        //code
        click(checkoutButton);
        return new InformationPage(driver);
    }

    //validations
    public CartPage assertProductDetails(String productName, String productPrice) {
        //code
        String actualProductName = getProductName();
        String actualProductPrice = getProductPrice();
        CustomSoftAssertion.softAssertion.assertEquals(actualProductName, productName, "Product name mismatch");
        CustomSoftAssertion.softAssertion.assertEquals(actualProductPrice, productPrice, "Product price mismatch");
        return this;
    }
}
