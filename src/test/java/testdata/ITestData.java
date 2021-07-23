package testdata;

import org.testng.annotations.DataProvider;
import utils.RandomValueGenerator;

public interface ITestData {

    @DataProvider(name = "Addition of a workout")
    static Object[][] inputAdditionWorkout() {
        return new Object[][]{
                {RandomValueGenerator.getRandomDate(-1), RandomValueGenerator.getTimeNow(), "Long Ride",
                        RandomValueGenerator.getRandomChar() + RandomValueGenerator.getRandomString(),
                        RandomValueGenerator.getRandomString() + RandomValueGenerator.getRandomString(),
                        String.valueOf((int) (Math.random() * 10)), true},
                {RandomValueGenerator.getRandomDate(0), RandomValueGenerator.getTimeNow(), "Open Water",
                        RandomValueGenerator.getRandomChar() + RandomValueGenerator.getRandomString(),
                        RandomValueGenerator.getRandomString() + RandomValueGenerator.getRandomString(),
                        String.valueOf((int) (Math.random() * 10)), false},
                {RandomValueGenerator.getRandomDate(1), RandomValueGenerator.getTimeNow(), "Rest Day",
                        RandomValueGenerator.getRandomChar() + RandomValueGenerator.getRandomString(),
                        RandomValueGenerator.getRandomString() + RandomValueGenerator.getRandomString(),
                        String.valueOf((int) (Math.random() * 10)), true}
        };
    }
}
