package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GenericUtils;
import utils.TestContextSetup;




public class LoginPage extends GenericUtils {

    public WebDriver driver;
    TestContextSetup testContextSetup;

    public LoginPage(WebDriver driver)
    {
        super(driver);

    }
    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.cssSelector("[data-test='error']");


    public void navigateToLoginPage() {
       navigateToURL("https://www.saucedemo.com/inventory.html");
    }


    public LoginPage enterUsername(String username) {
        type(this.username, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(this.password, password);
        return this;
    }

    public LoginPage clickLoginButton() {
       click(loginButton);
        return this;
    }

    //Getters
    public String getErrorMessage() {

        return getText(errorMessage);
    }




}
