package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DropDown {
    WebDriver driver;
    String label;
    public static final String DROPDOWN_XPATH = "//label[contains(text(), '%s')]/..//select";
    public static final String SELECT_OPTION_XPATH = "//*[contains(@class,'formSep')]/descendant::option[contains(text(),'%s')]";

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        log.info(String.format("Select '%s' in '%s' dropdown.", option, label));
        driver.findElement(By.xpath(String.format(DROPDOWN_XPATH, label))).click();
        driver.findElement(By.xpath(String.format(SELECT_OPTION_XPATH, option))).click();
    }

}
