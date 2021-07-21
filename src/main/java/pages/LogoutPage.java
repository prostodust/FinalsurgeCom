package pages;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@Log4j2
public class LogoutPage extends BasePage {
    @FindBy(xpath = "//*[@class='imgpad']")
    WebElement logoutPageLogo;

    @FindBy(xpath = "//*[contains(@class, 'alert-success')]/strong")
    WebElement logoutMessage;

    /**
     * Сreating an object
     *
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

}
