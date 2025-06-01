package Testsuite;

import automation.common.commonbase;
import automation.pageLocator.LoginPage;
import constant.PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class day13_BTVN extends commonbase {
    @BeforeMethod
    public void openChrome() {
        driver = initChromeBrowser(PageURL.CRMSTAR_URL);
    }

    @Test
    public void LoginSuccessfully() {
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("admin@gmail.com", "12345678");
        WebElement khct = driver.findElement(By.xpath("//button[contains(text(),'Thêm mới')]"));
        assertTrue(khct.isDisplayed());
    }

    @Test
    public void loginFail_IncorrectEmail() {
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("thanhtra@gmail.com", "12345678");
        WebElement sai_email = driver.findElement(By.xpath("//span[contains(text(),'Email hoặc mật khẩu không đúng')]"));
        assertTrue(sai_email.isDisplayed());
    }

    @Test
    public void loginFail_IncorrectPassword() {
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("admin@gmail.com", "thanhtra");
        WebElement sai_pass = driver.findElement(By.xpath("//span[contains(text(),'Email hoặc mật khẩu không đúng')]"));
        assertTrue(sai_pass.isDisplayed());
    }

    @Test
    public void loginFail_IncorrectBoth() {
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("thanhtra@gmail.com", "thanhtra");
        WebElement sai_both = driver.findElement(By.xpath("//span[contains(text(),'Email hoặc mật khẩu không đúng')]"));
        assertTrue(sai_both.isDisplayed());
    }
}
