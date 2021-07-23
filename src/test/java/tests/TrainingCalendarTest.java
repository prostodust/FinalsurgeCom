package tests;

import constants.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import testdata.ITestData;

public class TrainingCalendarTest extends BaseTest implements ITestConstants, ITestData {

    /**
     * Quick addition of a workout
     */
    @Test(description = "Quick addition of a workout", dataProvider = "Addition of a workout")
    public void quickAdditionWorkoutTest(String workoutDate, String workoutTime, String activityType, String workoutName,
                                         String workoutDescription, String distance, boolean saveToLibrary) {
        loginPage
                .authorizationCorrectData()
                .waitForPageOpened(headerFooterPage.getHeaderFooterPageLogo(), 10);
        calendarPage
                .openCalendarPage()
                .clickQuickAddButton()
                .addingWorkout(workoutDate, workoutTime, activityType,
                        workoutName, workoutDescription, distance, saveToLibrary);
        Assert.assertEquals(calendarPage.getWorkoutAndTime(driver, workoutName), workoutTime);
    }

    @Test(description = "Advanced training addition")
    public void advancedTrainingAdditionTest() {
    }

    @Test(description = "Viewing a workout")
    public void viewingWorkoutTest() {
    }

    @Test(description = "Editing a workout")
    public void editingWorkoutTest() {
    }

    @Test(description = "Loading training data from a file")
    public void loadingTrainingDataFromFileTest() {
    }

    @Test(description = "Deleting a workout")
    public void deletingWorkoutTest() {
    }

}
