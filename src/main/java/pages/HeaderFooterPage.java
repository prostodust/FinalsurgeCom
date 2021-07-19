package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class HeaderFooterPage extends HomePage {
    @FindBy(xpath = "//a[@href='default.cshtml']/img")
    WebElement headerFooterPageLogo;

    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    WebElement logoutLink;

    /**
     * @param driver the driver
     */
    public HeaderFooterPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Click on the logout link in the header
     */
    @Step("Click on the logout link in the header")
    public LogoutPage clickLogoutLink() {
        log.info("Click on the logout link in the header");
        logoutLink.click();
        log.info("Went to the Logout page");
        return new LogoutPage(driver);
    }

    /**
     * Waiting for an element to load during a timeout
     *
     * @param timeout the timeout
     */
    public HeaderFooterPage waitForPageOpened(int timeout) {
        log.debug("Waiting for an element to load in page during a <" + timeout + "> second");
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(headerFooterPageLogo));
        return this;
    }

}
