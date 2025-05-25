package Testsuite;
import constant.PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import automation.common.commonbase;
import java.util.List;

@Test
public class day12_dropdown extends commonbase{
    public void handleDropdown()
    {
        driver = initChromeBrowser("https://codestar.vn/khoa-hoc/");
        //khoi tao Select để chứa dropdown list
        Select dropKhoahoc = new Select(driver.findElement(By.id("product_categories_filter")));
        //Chon gt AWS bang ham selectByVisibleText
        dropKhoahoc.selectByVisibleText("AWS");
        System.out.println("Số lượng options của dropdown là: "+dropKhoahoc.getOptions().size());
        System.out.println("Gia tri sau khi chon la: "+dropKhoahoc.getFirstSelectedOption().getText());
        System.out.println("Multiple dropdown: "+ dropKhoahoc.isMultiple());
    }
}
