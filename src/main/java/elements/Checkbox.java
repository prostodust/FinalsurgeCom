package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Checkbox {
    WebDriver driver;
    String label;
    public static final String CHECKBOX_XPATH = "//span[contains(text(), '%s')]/..//input";

    public Checkbox(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void check() {
        driver.findElement(By.xpath(String.format(CHECKBOX_XPATH, label))).click();
    }

}
