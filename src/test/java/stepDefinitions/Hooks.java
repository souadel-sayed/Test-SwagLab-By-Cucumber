package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.InformationPage;
import pageObjects.LoginPage;
import utils.TestContextSetup;

public class Hooks {
TestContextSetup testContextSetup;
	LoginPage loginPage ;
	HomePage HOMEPAGE;
	CartPage cartPage;
	InformationPage informationPage;
	public Hooks(TestContextSetup testContextSetup)
	{
		
		this.testContextSetup = testContextSetup;
		this.loginPage = testContextSetup.pageObjectManager.getloginPage();
		this.HOMEPAGE = testContextSetup.pageObjectManager.gethomeStepDefinition();
		this.cartPage = testContextSetup.pageObjectManager.getcartpage();
		this.informationPage = testContextSetup.pageObjectManager.getinformationpage();



	}

	@Before("@Home")
	public void beforeHomeTests() {
		loginPage.navigateToLoginPage();
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLoginButton();
	}

	@Before("@Cart")
	public void beforeCarTests() {
		loginPage.navigateToLoginPage();
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLoginButton();
		HOMEPAGE.navigateToHomePage();
		HOMEPAGE.addSpecificProductToCart("Sauce Labs Bolt T-Shirt");
		HOMEPAGE.clickCartIcon();

	}

	@Before("@information")
	public void beforeinformationTests() {
		loginPage.navigateToLoginPage();
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLoginButton();
		HOMEPAGE.navigateToHomePage();
		HOMEPAGE.addSpecificProductToCart("Sauce Labs Fleece Jacket");
		HOMEPAGE.clickCartIcon();

		cartPage.clickCheckoutButton();
	}



	@After
	public void AfterScenario() throws IOException
	{
		
		testContextSetup.testBase.WebDriverManager().quit();
		
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException
	{
		WebDriver driver =testContextSetup.testBase.WebDriverManager();
		if(scenario.isFailed())
		{
		//screenshot
		File sourcePath= 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
		
		}
		
	}
	
}
