package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class CalendarPage extends HeaderFooterPage {
    @FindBy(xpath = "//*[@id='breadcrumbs']//*[text() = 'Training Calendar']")
    WebElement calendarPageLogo;

    /**
     * Сreating an object
     *
     * @param driver the driver
     */
    public CalendarPage(WebDriver driver) {
        super(driver);
    }

}
