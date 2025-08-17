package utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {
    private WebDriver driver;
    private GenericUtils browserActions;


    public Validations(WebDriver driver) {
        this.driver = driver;
        browserActions = new GenericUtils(driver);
    }

    public void validateTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    public void validateFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }

    public void validateEquals(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public void validateNotEquals(String actual, String expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }

    public void validatePageUrl(String expected) {
        Assert.assertEquals(browserActions.getCurrentURL(), expected);
    }

    public void validatePageTitle(String expected) {
        Assert.assertEquals(browserActions.getPageTitle(), expected);
    }
}