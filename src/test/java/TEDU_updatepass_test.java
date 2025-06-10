package Testsuite;

import automation.common.commonbase;
import automation.pageLocator.TEDU_loginpage;
import automation.pageLocator.TEDU_updatepass_page;
import constant.CT_PageURL;
import junit.framework.TestCase;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TEDU_updatepass_test extends commonbase {
    String pass1 = "123456";
    String pass2 = "abcdef";
    @BeforeMethod
    public void openChromeBrowser() throws InterruptedException {
        driver = initChromeBrowser(CT_PageURL.TEDU_URL);
        TEDU_loginpage login = new TEDU_loginpage(driver);
        login.loginFunction("thanhtraneu17@gmail.com",pass1);
    }
    @Test
    public void updatePass_notsuccess(){
        TEDU_updatepass_page updatepass = new TEDU_updatepass_page(driver);
        updatepass.updatePassword(pass1,pass2);
        assertTrue(driver.findElement(By.xpath("//li[text()='Có lỗi khi đổi mật khẩu. Liên hệ quản trị']")).isDisplayed());

    }


}
