package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class LoginTest extends BaseTest implements ITestConstants {

    /**
     * Entering the correct data
     */
    @Test(description = "Authorization with the correct e-mail and password")
    public void authorizationCorrectEmailAndPasswordTest() {
        loginPage.openPage(FINAL_SURGE_LOGINPAGE_URL)
                .waitForPageOpened(10)
                .login(System.getenv().getOrDefault("emailFromConfig", PropertyReader.getProperty("email")), System.getenv().getOrDefault("passFromConfig", PropertyReader.getProperty("password")))
                .waitForPageOpened(10);
        Assert.assertEquals(calendarPage.getCalendarPageLogoText(), "Training Calendar");
    }

    /**
     * Incorrect value in the "password" field
     */
    @Test(description = "Authorization with an incorrect password")
    public void authorizationIncorrectPasswordTest() {
        loginPage.openPage(FINAL_SURGE_LOGINPAGE_URL)
                .waitForPageOpened(10)
                .login(System.getenv().getOrDefault("emailFromConfig", PropertyReader.getProperty("email")), "Incorrect pass");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Invalid login credentials. Please try again.");
    }

    /**
     * Log out of the system
     */
    @Test(description = "Log out of the system")
    public void logOutSystemTest() {
        loginPage.openPage(FINAL_SURGE_LOGINPAGE_URL)
                .waitForPageOpened(10)
                .login(System.getenv().getOrDefault("emailFromConfig", PropertyReader.getProperty("email")), System.getenv().getOrDefault("passFromConfig", PropertyReader.getProperty("password")))
                .waitForPageOpened(10)
                .clickLogoutLink()
                .waitForPageLoaded();
        Assert.assertEquals(logoutPage.getLogoutMessageText(), "You have been successfully logged out of the system.");
    }

}
