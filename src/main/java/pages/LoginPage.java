package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PropertyReader;

@Log4j2
public class LoginPage extends BasePage {
    @FindBy(xpath = "//*[@class='imgpad']")
    WebElement loginPageLogo;

    @FindBy(xpath = "//*[@id='login_name']")
    WebElement emailInput;

    @FindBy(xpath = "//*[@id='login_password']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    WebElement loginButton;

    @FindBy(xpath = "//*[contains(@class, 'alert-error')]/strong")
    WebElement errorMessage;

    /**
     * Сreating an object
     *
     * @param driver the driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open login page
     */
    @Step("Opening login page")
    public LoginPage openLoginPage() {
        openPage(FINAL_SURGE_LOGINPAGE_URL);
        waitForPageOpened(loginPageLogo, 10);
        return this;
    }

    /**
     * Login page
     *
     * @param email    the email
     * @param password the password
     */
    @Step("Fill in {email} and {password} in login page")
    public HomePage login(String email, String password) {
        log.info("Fill in email <" + email + "> in login page");
        emailInput.sendKeys(email);
        log.info("Fill in password <" + password + "> in login page");
        passwordInput.sendKeys(password);
        log.info("Pressing the button <Login>");
        loginButton.click();
        log.info("Went to the Home page");
        return new HomePage(driver);
    }

    /**
     * Authorization with the correct data
     */
    @Step("Authorization with the correct data")
    public HomePage authorizationCorrectData() {
        openLoginPage();
        login(System.getenv().getOrDefault("emailFromCircleCI", PropertyReader.getProperty("emailFromConfig")),
                System.getenv().getOrDefault("passFromCircleCI", PropertyReader.getProperty("passFromConfig")));
        return new HomePage(driver);
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
}
