package pages;

import elements.Checkbox;
import elements.DropDown;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@Log4j2
public class CalendarPage extends HomePage {
    public static final String WORKOUT_TIME = "//*[@data-title='%s']//div[@class='fc-event-workouttime']";

    @FindBy(xpath = "//*[@id='breadcrumbs']//*[text() = 'Training Calendar']")
    WebElement calendarPageLogo;

    @FindBy(xpath = "//*[@id='QuickAddToggle']")
    WebElement quickAddButton;

    @FindBy(xpath = "//*[@id='FullAddBtn']")
    WebElement fullAddButton;

    @FindBy(xpath = "//*[@id='WorkoutDate']")
    WebElement dateInput;

    @FindBy(xpath = "//*[@id='WorkoutTime']")
    WebElement timeOfDateInput;

    @FindBy(xpath = "//*[@id='saveButton']")
    WebElement addWorkoutButton;

    /**
     * Сreating an object
     *
     * @param driver the driver
     */
    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open calendar page
     */
    @Step("Opening calendar page")
    public CalendarPage openCalendarPage() {
        openPage(FINAL_SURGE_CALENDAR_URL);
        waitForPageOpened(calendarPageLogo, 10);
        return this;
    }

    /**
     * Adding a workout
     *
     * @return this
     */
    @Step("Adding a workout")
    public CalendarPage addingWorkout(String workoutDate, String workoutTime, String activityType, String workoutName,
                                      String workoutDescription, String distance, boolean saveToLibrary) {
        log.info("Fill <" + workoutDate + "> in Date");
        dateInput.clear();
        dateInput.sendKeys(workoutDate);
        log.info("Fill <" + workoutTime + "> in Time of Day");
        timeOfDateInput.sendKeys(workoutTime);
        new DropDown(driver, "Activity Type").select(activityType);
        new Input(driver, "Workout Name").inputText(workoutName);
        new TextArea(driver, "Workout Description").typeText(workoutDescription);
        new Input(driver, "Distance").inputText(distance);
        if (saveToLibrary) {
            new Checkbox(driver, "Save to Library").check();
        }
        log.info("Pressing the Save button");
        addWorkoutButton.click();
        return this;
    }

    /**
     * Click on the QuickAdd button
     */
    @Step("Click on the QuickAdd button")
    public CalendarPage clickQuickAddButton() {
        log.info("Click on the QuickAdd button");
        quickAddButton.click();
        waitForPageOpened(addWorkoutButton, 10);
        return this;
    }

    /**
     * Click on the FullAdd button
     */
    @Step("Click on the FullAdd button")
    public CalendarPage clickFullAddButton() {
        log.info("Click on the FullAdd button");
        fullAddButton.click();
        waitForPageOpened(addWorkoutButton, 10);
        return this;
    }

    /**
     * Search for a workout and get time
     */
    @Step("Search for a workout and get time")
    public String getWorkoutAndTime(WebDriver driver, String label) {
        log.info(String.format("Search for a workout '%s' and get time.", label));
        return driver.findElement(By.xpath(String.format(WORKOUT_TIME, label))).getText();
    }

}
