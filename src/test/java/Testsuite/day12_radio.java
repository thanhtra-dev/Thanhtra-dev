package Testsuite;
import constant.PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import automation.common.commonbase;
import java.util.List;

public class day12_radio extends commonbase{

    @Test
    public void day12_radio() {
        driver = initChromeBrowser(PageURL.DEMOQA_URL);
        WebElement rb_male = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        if (rb_male.isEnabled()){
            rb_male.click();
        }
    }

}
