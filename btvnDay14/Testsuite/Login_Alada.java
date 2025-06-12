package Testsuite;

import automation.common.commonbase;
import automation.pageLocator.LoginPage;
import constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Login_Alada extends commonbase {
    @BeforeMethod
    public void openChrome() {
        driver = initChromeBrowser(CT_PageURL.ALADA_URL);
    }

    @Test
    public void LoginSuccessfully() {
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("thanhtraneu17@gmail.com", "1481999");
        WebElement khct = driver.findElement(By.xpath("//a[text()='Khóa học của tôi']"));
        assertTrue(khct.isDisplayed());
    }

    @Test
    public void loginFail_IncorrectEmail() {
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("thanhtra@gmail.com", "1481999");
        WebElement emailSai = driver.findElement(By.xpath("//p[text()='Email này chưa được đăng ký.']"));
        assertTrue(emailSai.isDisplayed());
    }

    @Test
    public void loginFail_IncorrectPassword() {
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("thanhtraneu17@gmail.com", "123");
        WebElement emailSai = driver.findElement(By.xpath("//p[@class='cred' and text()='Mật khẩu sai.']"));
        assertTrue(emailSai.isDisplayed());
    }
}


