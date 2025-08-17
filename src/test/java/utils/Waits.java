package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Waits {
    private WebDriver driver;
    public Waits(WebDriver driver) {
        this.driver = driver;
    }

    //present - visible - clickable

    //wait for element to be present
    public WebElement waitForElementPresent(By locator) {
        //code
        return new WebDriverWait(driver,  Duration.ofSeconds(10)).
                until(driver1 ->
                        driver1.findElement(locator));
    }

    //wait for element to be visible
    public WebElement waitForElementVisible(By locator) {
        //code
        return new WebDriverWait(driver,  Duration.ofSeconds(10)).
                until(driver1 ->
                        {
                            WebElement element = waitForElementPresent(locator);
                            return element.isDisplayed() ? element : null;
                        }
                );
    }

    //wait for element to be clickable
    public WebElement waitForElementClickable(By locator) {
        //code
        return new WebDriverWait(driver,  Duration.ofSeconds(10)).
                until(driver1 ->
                        {
                            WebElement element = waitForElementVisible(locator);
                            return element.isEnabled() ? element : null;
                        }
                );
    }

    //general wait
    public FluentWait<WebDriver> Synchronize() {
        //code
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100));
    }



}