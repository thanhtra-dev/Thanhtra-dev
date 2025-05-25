package Testsuite;
import constant.PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import automation.common.commonbase;
import java.util.List;

@Test

public class day12_BTVN extends commonbase{
    public void CountryDropdown() {
        driver = initChromeBrowser("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        //khoi tao Select de chua dropdown list
        Select dropCountry = new Select(driver.findElement(By.xpath("//select")));
        dropCountry.selectByVisibleText("Bangladesh");
        System.out.println("Số lượng options của dropdown là: "+dropCountry.getOptions().size());
        System.out.println("Gia tri sau khi chon la: "+dropCountry.getFirstSelectedOption().getText());
        System.out.println("Multiple dropdown: "+dropCountry.isMultiple());

    }
}
