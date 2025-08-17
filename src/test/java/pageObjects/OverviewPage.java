package pageObjects;

import org.openqa.selenium.WebDriver;
import utils.GenericUtils;
import utils.TestContextSetup;

public class OverviewPage extends GenericUtils {
    public WebDriver driver;
    TestContextSetup testContextSetup;

    public OverviewPage(WebDriver driver)
    {
        super(driver);

    }
}
