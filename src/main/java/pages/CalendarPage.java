package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class CalendarPage extends HeaderFooterPage {
    @FindBy(xpath = "//*[@id='breadcrumbs']/li[2]/a")
    WebElement calendarPageLogo;

    /**
     * @param driver the driver
     */
    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get calendar page logo text
     *
     * @return calendar page logo text
     */
    public String getCalendarPageLogoText() {
        log.debug("Get calendar page logo text");
        return calendarPageLogo.getText();
    }

    /**
     * Waiting for an element to load during a timeout
     *
     * @param timeout the timeout
     */
    public CalendarPage waitForPageOpened(int timeout) {
        log.debug("Waiting for an element to load in page during a <" + timeout + "> second");
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(calendarPageLogo));
        return this;
    }

}
