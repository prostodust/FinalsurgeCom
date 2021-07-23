package tests;

import constants.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TrainingVolumeTest extends BaseTest implements ITestConstants {

    /**
     * Viewing the training volume
     */
    @Test(description = "Viewing the training volume")
    public void viewingTrainingVolumeTest() {
        loginPage
                .authorizationCorrectData();
        dashboardPage
                .openDashboardPage();
        Assert.assertTrue(dashboardPage.getGraphBody().isDisplayed());
    }
}
