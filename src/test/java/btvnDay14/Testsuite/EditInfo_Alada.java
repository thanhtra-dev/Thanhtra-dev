package Testsuite;

import automation.common.commonbase;
import automation.pageLocator.Alada_loginpage;
import constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class EditInfo_Alada extends commonbase {
    @BeforeMethod
    public void initChromeBrowser() {
        driver = initChromeBrowser(CT_PageURL.ALADA_URL);
    }
    public void LoginAlada(String email, String password) {
        Alada_loginpage login = new Alada_loginpage(driver);
        login.LoginTK("thanhtraneu17@gmail.com","111111");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        boolean Redirected = wait.until(driver -> driver.getCurrentUrl().equals(CT_PageURL.ALADA_URL));
        assertTrue(Redirected,"Điều hướng URL thất bại");

    }
    @Test
    public void editInfoAlada() {
        LoginAlada("thanhtraneu17@gmail.com","111111");
        //b2: click icon tai khoan
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        WebElement UserIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='avatar2']")));
        UserIcon.click();

        //b3: click "Chỉnh sửa thông tin"
        WebElement editInfo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Chỉnh sửa thông tin')]")));
        editInfo.click();

    }
}
