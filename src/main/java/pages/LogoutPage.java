package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class LogoutPage extends BasePage {
    @FindBy(xpath = "//*[@class='imgpad']")
    WebElement logoutPageLogo;

    @FindBy(xpath = "//*[@class='alert alert-success']/strong")
    WebElement logoutMessage;

    /**
     * @param driver the driver
     */
    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Getting an logout message
     *
     * @return logout text
     */
    public String getLogoutMessageText() {
        log.info("Getting an logout message");
        return logoutMessage.getText();
    }

    /**
     * Waiting for an element to load during a timeout
     *
     * @param timeout the timeout
     */
    public LogoutPage waitForPageOpened(int timeout) {
        log.debug("Waiting for an element to load in page during a <" + timeout + "> second");
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(logoutPageLogo));
        return this;
    }
}
