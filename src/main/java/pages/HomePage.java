package pages;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@Log4j2
public class HomePage extends BasePage {
    @FindBy(xpath = "//a[@href='default.cshtml']/img")
    WebElement headerFooterPageLogo;

    @FindBy(xpath = "//*[@class='icsw16-home']")
    WebElement dashboardButton;

    @FindBy(xpath = "//*[@class='icsw16-day-calendar']")
    WebElement calendarButton;

    @FindBy(xpath = "//*[@class='icsw16-stop-watch']")
    WebElement workoutCalculatorsButton;

    @FindBy(xpath = "//*[@class='icsw16-calculator']")
    WebElement otherCalculatorsButton;

    @FindBy(xpath = "//*[@class='icsw16-graph']")
    WebElement statisticsButton;

    @FindBy(xpath = "//*[@class='icsw16-mail']")
    WebElement mailboxButton;

    @FindBy(xpath = "//*[@class='icsw16-printer']")
    WebElement printWorkoutsButton;

    @FindBy(xpath = "//*[@class='user-info']/strong")
    WebElement usernameHeader;

    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    WebElement logoutLink;

    /**
     * Сreating an object
     *
     * @param driver the driver
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Click on the button
     */
    @Step("Click on the button in the header")
    public void clickButton(WebElement elementButton) {
        log.info("Click on the button in the header");
        elementButton.click();
        log.info("Went to the next page");
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
     * Get username text from header
     *
     * @return username text
     */
    public String getUsernameHeaderText() {
        log.debug("Get username text from header");
        return usernameHeader.getText();
    }
}
