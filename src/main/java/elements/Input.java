package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Input {
    WebDriver driver;
    String label;
    public static final String INPUT_XPATH = "//label[text()='%s']/..//input";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void inputText(String text) {
        log.info(String.format("Fill '%s' in '%s' field.", text, label));
        driver.findElement(By.xpath(String.format(INPUT_XPATH, label))).sendKeys(text);
    }

}
