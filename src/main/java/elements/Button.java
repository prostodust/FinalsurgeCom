package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Button {
    WebDriver driver;
    String label;

    public static final String BUTTON_XPATH = "//label[contains(text(), '%s')]";

    public Button(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void click() {
        log.info(String.format("Click button '%s'.", label));
        driver.findElement(By.xpath(String.format(BUTTON_XPATH, label))).click();
    }

}
