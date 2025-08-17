package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CustomSoftAssertion;
import utils.GenericUtils;
import utils.TestContextSetup;

public class InformationPage extends GenericUtils {

    public WebDriver driver;
    TestContextSetup testContextSetup;

    public InformationPage(WebDriver driver)
    {
        super(driver);

    }

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");


    //actions
    public InformationPage fillInformationForm(String firstName, String lastName, String postalCode) {
        //code
       type(this.firstName, firstName);
       type(this.lastName, lastName);
       type(this.postalCode, postalCode);
        return this;
    }

    public OverviewPage clickContinueButton() {
        //code
         click(continueButton);
       return new OverviewPage(driver);
    }


    //validations
    public InformationPage assertInformationPage(String firstName, String lastName, String postalCode) {
        //code
        CustomSoftAssertion.softAssertion.assertEquals(getTextFromInput(this.firstName), firstName);
        CustomSoftAssertion.softAssertion.assertEquals(getTextFromInput(this.lastName), lastName);
        CustomSoftAssertion.softAssertion.assertEquals(getTextFromInput(this.postalCode), postalCode);
        return this;
    }
}
