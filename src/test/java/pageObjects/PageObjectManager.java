package pageObjects;

import org.openqa.selenium.WebDriver;
import stepDefinitions.HomeStepDefinition;

public class PageObjectManager {

	public LoginPage loginPage;
	public WebDriver driver;
	public HomePage homepage;
	public CartPage cartPage;
	public InformationPage 	 information;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getloginPage() {
		loginPage = new LoginPage(driver);
		return loginPage;
	}


	public HomePage gethomeStepDefinition() {
		homepage = new HomePage(driver);
		return homepage;
	}

	public CartPage getcartpage() {
		cartPage = new CartPage(driver);
		return cartPage;
	}

	public InformationPage getinformationpage() {
		information = new InformationPage(driver);
		return information;
	}

}