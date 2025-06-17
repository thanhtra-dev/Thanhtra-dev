package Testsuite;

import automation.common.commonbase;
import constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class Day16btvn_b1 extends commonbase {
    @BeforeMethod
    public void openFireFoxBrowser() {
        driver = initFirefoxBrowser(CT_PageURL.CRMSTAR2_URL);
    }
    @Test(priority = 1)
    public void LoginSuccessfully(){
        Day16_btvn login = new Day16_btvn(driver);
        login.LoginFunction("admin@gmail.com","12345678");
        WebElement dntc = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        assertTrue(dntc.isDisplayed(),"dang nhap khong thanh cong");
    }
    @Test(priority = 2)
    public void Add_KLV_Successfully(){
        Day16_btvn login = new Day16_btvn(driver);
        login.LoginFunction("admin@gmail.com","12345678");
        click(By.xpath("//a[@href='http://test-system.crmstar.vn/work-space-management']"));
        click(By.xpath("//button[text()='Thêm mới']"));
        type(By.name("work_areas_code"),"1481999");
        type(By.name("name"),"MSB");
        click(By.xpath("//button[text()='Lưu']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By confirmText = By.xpath("//div[contains(text(),'Bạn có thực sự muốn thêm khu vực này')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(confirmText));
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmText));
        String modalText = driver.findElement(confirmText).getText().trim();
        System.out.println("Modal text: " + modalText);
        assertTrue(modalText.contains("Bạn có thực sự muốn thêm khu vực này"));
        click(By.xpath("//button[text()='Thêm']"));
        boolean Redirected = wait.until(driver -> driver.getCurrentUrl().contains("http://test-system.crmstar.vn/work-space-management"));
        assertTrue(Redirected,"Thêm mới khu vực thất bại");
    }
    @Test(priority = 3)
    public void Add_KLV_FAIL(){
        Day16_btvn login = new Day16_btvn(driver);
        login.LoginFunction("admin@gmail.com","12345678");
        click(By.xpath("//a[@href='http://test-system.crmstar.vn/work-space-management']"));
        click(By.xpath("//button[text()='Thêm mới']"));
        type(By.name("work_areas_code"),"1481999");
        type(By.name("name"),"MSB");
        click(By.xpath("//button[text()='Lưu']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By confirmText = By.xpath("//div[contains(text(),'Bạn có thực sự muốn thêm khu vực này')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(confirmText));
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmText));
        String modalText = driver.findElement(confirmText).getText().trim();
        System.out.println("Modal text: " + modalText);
        assertTrue(modalText.contains("Bạn có thực sự muốn thêm khu vực này"));
        click(By.xpath("//button[text()='Thêm']"));
        assertTrue(isElementPresent(By.xpath("//span[text()='Mã khu vực đã tồn tại']")));
    }
    @Test(priority = 4)
    public void Delete_KLV_Successfully(){
        Day16_btvn login = new Day16_btvn(driver);
        login.LoginFunction("admin@gmail.com","12345678");
        click(By.xpath("//a[@href='http://test-system.crmstar.vn/work-space-management']"));
        click(By.xpath("//input[@placeholder='Nhập từ khóa cần tìm kiếm']"));
        WebElement searchBox = driver.findElement(By.name("query"));
        searchBox.clear();
        searchBox.sendKeys("MSB");
        click(By.xpath("//button[text()='Tìm kiếm']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        click(By.xpath("//a[@class='btn btn-success' and contains(text(),'Xóa')]"));
        String actualText = driver.switchTo().alert().getText();
        String expectText = "Bạn có thực sự muốn xóa khu vực này";
        assertEquals(actualText,expectText);
        boolean Delete = wait.until(driver -> driver.getCurrentUrl().contains("query=MSB"));
        assertTrue(Delete);
    }
}
