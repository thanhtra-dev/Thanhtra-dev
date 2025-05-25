package Testsuite;
import constant.PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import automation.common.commonbase;
import java.util.List;

public class DAY12_Checkbox extends commonbase {
    @Test
    public void clickCheckbox()
    {
        driver = initChromeBrowser(PageURL.DEMOQA_URL);
        WebElement chbSport = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        scrollToElement(chbSport);
        if(chbSport.isSelected()==false)
        {
            chbSport.click();
            System.out.println("The sport checkbox has been checked");
        }

        WebElement chbReading = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
        if(chbReading.isSelected()==false)
        {
            chbReading.click();
            System.out.println("The reading checkbox has been checked");
        }

        WebElement chbMusic = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));
        if(chbReading.isSelected()==false)
        {
            chbMusic.click();
            System.out.println("The music checkbox has been checked");
        }

    }
    @Test
    public void clickCheckbox_2()
    {
        driver = initChromeBrowser(PageURL.DEMOQA_URL);
        List<WebElement> listLabelCheckbox = driver.findElements(By.xpath("//label[contains(@for,'hobbies-checkbox')]"));
        scrollToElement(listLabelCheckbox.get(0));
        for(WebElement item:listLabelCheckbox){
            if(item.isSelected()==false)
            {
                item.click();
                System.out.println("The checkbox  "+item+ "has been checked");
            }
        }



    }
}
