package utils;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericUtils {
	public WebDriver driver;
	private Waits waits;


	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
		waits = new Waits(driver);
	}
	

	public void SwitchWindowToChild()
	{
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1 =s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
	}

	public void navigateToURL(String url) {
		driver.get(url);
	}

	//Get current URL
	public String getCurrentURL() {
		return driver.getCurrentUrl();

	}

	//Get page title
	public String getPageTitle() {
		return driver.getTitle();
	}

	//refresh page
	public void refreshPage() {
		driver.navigate().refresh();
	}

	//close browser
	public void closeBrowser() {
		if (driver != null) {
			driver.quit(); // 🚀 Ensure this is called
		}
	}

	//send keys
	public void type(By locator, String data) {
		//code
		scrollToElement(locator);
		findElement(locator).sendKeys(data);
	}

	//click
	public void click(By locator) {
		//code
		scrollToElement(locator);
		findElement(locator).click();
	}

	public String getText(By locator) {
		waits.waitForElementVisible(locator);
		scrollToElement(locator);
		return findElement(locator).getText();
	}

	//find element
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public String getTextFromInput(By locator) {
		waits.waitForElementVisible(locator);
		scrollToElement(locator);
		return findElement(locator).getDomAttribute("value");
	}

	//scroll to element
	public void scrollToElement(By locator) {
		//code
		((JavascriptExecutor) driver).
				executeScript("arguments[0].scrollIntoView(true);", findElement(locator));
	}






}
