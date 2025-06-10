package Testsuite;

import automation.common.commonbase;
import automation.pageLocator.TEDU_loginpage;
import automation.pageLocator.TEDU_searchpage;
import constant.CT_PageURL;
import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TEDU_search_test extends commonbase {
    String pass1 = "thanhtra14899";
    @BeforeMethod
    public void openChromeBrowser() throws InterruptedException {
        driver = initChromeBrowser(CT_PageURL.TEDU_URL);
        TEDU_loginpage loginpage = new TEDU_loginpage(driver);
        loginpage.loginFunction("thanhtraneu17@gmail.com",pass1);
    }
    @Test
    public void SearchSuccess() throws InterruptedException {
        TEDU_searchpage searchpage = new TEDU_searchpage(driver);
        searchpage.SearchFunction("ASP.NET");
        assertTrue(driver.findElement(By.xpath("//a[@title='Bài 52: Gửi phản hồi và gửi mail trong ASP NET sử dụng SMTP']")).isDisplayed());
    }

}
