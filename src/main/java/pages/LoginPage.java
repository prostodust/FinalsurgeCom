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
public class LoginPage extends BasePage {
    @FindBy(xpath = "//*[@id='login_name']")
    WebElement emailInput;

    @FindBy(xpath = "//*[@id='login_password']")
    WebElement passwordInput;

    @FindBy(xpath="//button[contains(text(), 'Login')]")
    WebElement loginButton;

    @FindBy(xpath = "//*[@class='imgpad']")
    WebElement loginPageLogo;

    @FindBy(xpath = "//*[@class='alert alert-error']/strong")
    WebElement errorMessage;

    /**
     * @param driver the driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open page
     *
     * @param url the url
     */
    @Step("Opening login page")
    public LoginPage openPage(String url) {
        log.info("Opening the login page at " + url);
        driver.get(url);
        return this;
    }

    /**
     * Login page
     *
     * @param email    the email
     * @param password the password
     */
    @Step("Fill in {email} and {password} in login page")
    public HeaderFooterPage login(String email, String password) {
        log.info("Fill in email <" + email + "> in login page");
        emailInput.sendKeys(email);
        log.info("Fill in password <" + password + "> in login page");
        passwordInput.sendKeys(password);
        log.info("Pressing the button <Login>");
        loginButton.click();
        log.info("Went to the Header page");
        return new HeaderFooterPage(driver);
    }

    /**
     * Getting an error message
     *
     * @return error text
     */
    public String getErrorMessageText() {
        log.info("Getting an error message");
        return errorMessage.getText();
    }

    /**
     * Waiting for an element to load during a timeout
     *
     * @param timeout the timeout
     */
    public LoginPage waitForPageOpened(int timeout) {
        log.debug("Waiting for an element to load in page during a <" + timeout + "> second");
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(loginPageLogo));
        return this;
    }
}
