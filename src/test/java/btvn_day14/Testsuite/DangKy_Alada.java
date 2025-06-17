package Testsuite;

import automation.common.commonbase;
import automation.pageLocator.Alada_registerpage;
import constant.CT_PageURL;
import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class DangKy_Alada extends commonbase {
    @BeforeMethod
    public void initChromeBrowser() {
        driver = initChromeBrowser(CT_PageURL.ALADA_URL);
    }

    @Test
    public void InputDangky(){
        Alada_registerpage factory = new Alada_registerpage(driver);
        factory.RegisterFunction("Dinh Thanh Tra", "thanhtraneu17@gmail.com", "thanhtraneu17@gmail.com", "111111", "111111", "0973326745");
        assertTrue(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed());

    }
    @Test
    public void DangkyFail_EmailSai() {
        Alada_registerpage factory = new Alada_registerpage(driver);
        factory.RegisterFunction("Dinh Thanh Tra", "thanhtraneu18@gmail.com", "thanhtraneu18@gmail.com", "111111", "111111", "0973326745");
        assertTrue(driver.findElement(By.xpath("//label[@Id='txtCEmail-error']")).isDisplayed());
    }

    @Test
    public void DangkyFail_PassSai() {
        Alada_registerpage factory = new Alada_registerpage(driver);
        factory.RegisterFunction("Dinh Thanh Tra", "thanhtraneu17@gmail.com", "thanhtraneu17@gmail.com", "222222", "222222", "0973326745");
        assertTrue(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).isDisplayed());
    }

    @Test
    public void DangkyFail_PhoneSai() {
        Alada_registerpage factory = new Alada_registerpage(driver);
        factory.RegisterFunction("Dinh Thanh Tra", "thanhtraneu17@gmail.com", "thanhtraneu17@gmail.com", "111111", "111111", "0973326747");
        assertTrue(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).isDisplayed());
    }


}

