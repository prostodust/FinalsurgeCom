package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.CalendarPage;
import pages.HeaderFooterPage;
import pages.LoginPage;
import pages.LogoutPage;
import utils.TestListener;

import java.time.Duration;
import java.util.Calendar;

@Log4j2
@Listeners(TestListener.class)
abstract class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    LogoutPage logoutPage;
    HeaderFooterPage headerFooterPage;
    CalendarPage calendarPage;

    /**
     * Actions performed before each test
     */
    @BeforeMethod
    public void initTest(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(setChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        initPages();
        String variable = "driver";
        log.info("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }

    /**
     * Actions performed after each test
     */
    @AfterMethod(alwaysRun = true)
    public void endTest() {
        driver.quit();
    }

    /**
     * Initializing pages
     */
    public void initPages() {
        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);
        headerFooterPage = new HeaderFooterPage(driver);
        calendarPage = new CalendarPage(driver);
    }

    /**
     * Set chrome options
     */
    public ChromeOptions setChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-pop-blocking");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        return options;
    }

}
