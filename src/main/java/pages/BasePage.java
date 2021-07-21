package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    /**
     * Сreating an object
     *
     * @param driver the driver
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Open page
     *
     * @param url the url
     */
    public void openPage(String url) {
        log.info("Opening the page at " + url);
        driver.get(url);
    }

    /**
     * Waiting for an element to load during a timeout
     *
     * @param element the webelement
     * @param timeout the timeout
     */
    public void waitForPageOpened(WebElement element, int timeout) {
        log.debug("Waiting for an element to load in page during a <" + timeout + "> second");
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waiting for the page to load
     */
    public void waitForPageLoaded() {
        new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
    }
}
