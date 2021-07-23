package pages;

import constants.IConstants;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class DashboardPage extends HeaderFooterPage implements IConstants {
    @FindBy(xpath = "//*[@id='breadcrumbs']//*[text() = 'Dashboard']")
    WebElement dashboardPageLogo;

    @FindBy(xpath = "//*[@class='highcharts-title']")
    WebElement graphTitle;

    @FindBy(xpath = "//*[contains(@class, 'w-box-blue')]")
    WebElement graphBody;

    /**
     * Сreating an object
     *
     * @param driver
     */
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open dashboard page
     */
    @Step("Opening dashboard page")
    public DashboardPage openDashboardPage() {
        openPage(FINAL_SURGE_DASHBOARDPAGE_URL);
        waitForPageOpened(dashboardPageLogo, 10);
        return this;
    }
}
