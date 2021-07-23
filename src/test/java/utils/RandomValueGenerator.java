package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;

public class RandomValueGenerator {

    public static char getRandomChar() {
        Random random = new Random();
        return (char) (random.nextInt(26) + 'A');
    }

    public static String getRandomString() {
        Random random = new Random();
        char nextChar;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            nextChar = (char) (random.nextInt(26) + 'a');
            stringBuilder.append(nextChar);
        }
        return stringBuilder.toString();
    }

    public static String getRandomDate(int offset) {
        String randomDate;
        if (offset > 0) {
            randomDate = LocalDate.now().plusDays(offset).format(DateTimeFormatter.ofPattern("dd/M/yyyy"));
        } else if (offset < 0) {
            randomDate = LocalDate.now().minusDays(Math.abs(offset)).format(DateTimeFormatter.ofPattern("dd/M/yyyy"));
        } else
            randomDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/M/yyyy"));
        return randomDate;
    }

    public static String getTimeNow() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
