package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class LoginTest extends BaseTest {

    /**
     * Entering the correct data
     */
    @Test(description = "Authorization with the correct e-mail and password")
    public void authorizationCorrectEmailAndPasswordTest() {
        loginPage
                .openLoginPage()
                .login(System.getenv().getOrDefault("emailFromCircleCI", PropertyReader.getProperty("emailFromConfig")),
                        System.getenv().getOrDefault("passFromCircleCI", PropertyReader.getProperty("passFromConfig")))
                .waitForPageOpened(headerFooterPage.getHeaderFooterPageLogo(), 10);
        Assert.assertEquals(headerFooterPage.getUsernameHeaderText(), FINAL_SURGE_USER);
    }

    /**
     * Incorrect value in the "password" field
     */
    @Test(description = "Authorization with an incorrect password")
    public void authorizationIncorrectPasswordTest() {
        loginPage
                .openLoginPage()
                .login(System.getenv().getOrDefault("emailFromCircleCI", PropertyReader.getProperty("emailFromConfig")), "Incorrect pass");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Invalid login credentials. Please try again.");
    }

    /**
     * Log out of the system
     */
    @Test(description = "Log out of the system")
    public void logOutSystemTest() {
        loginPage
                .openLoginPage()
                .login(System.getenv().getOrDefault("emailFromCircleCI", PropertyReader.getProperty("emailFromConfig")),
                        System.getenv().getOrDefault("passFromCircleCI", PropertyReader.getProperty("passFromConfig")))
                .waitForPageOpened(headerFooterPage.getHeaderFooterPageLogo(), 10);
        headerFooterPage
                .clickLogoutLink()
                .waitForPageOpened(logoutPage.getLogoutPageLogo(), 10);
        Assert.assertEquals(logoutPage.getLogoutMessageText(), "You have been successfully logged out of the system.");
    }

}
