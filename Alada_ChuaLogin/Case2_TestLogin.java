package Alada_ChuaLogin;
import common.commonbase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocator.AladaLocator;
import constant.URL;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Case2_TestLogin extends commonbase {
    @BeforeMethod
    public void openBrowser() {
        initChromeBrowser(URL.ALADA_URL);
    }
    @Test
    public void LoginTC() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        WebElement btnXanh = findVisibleElement(AladaLocator.DangNhapXanh);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnXanh);
        btnXanh.click();
        //Nhap vao o dia chi mail
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(AladaLocator.DangNhap_Email))
                .sendKeys("tradt@bidv.com.vn");
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(AladaLocator.DangNhap_Matkhau))
                .sendKeys("LHL2510@");
        WebElement btn = findVisibleElement(AladaLocator.DangNhap_button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
        btn.click();

        WebElement khctBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(AladaLocator.KHCT));
        Assert.assertTrue(khctBtn.isDisplayed(), "Không tìm thấy nút 'Khóa học của tôi'");

    }
}
