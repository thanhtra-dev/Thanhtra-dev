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

public class Case1_TestDangky extends commonbase {
    @BeforeMethod
    public void openBrowser() {
        initChromeBrowser(URL.ALADA_URL);
    }
    @Test
    public void DkyPass() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        // Nhập vào ô Họ và tên
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(AladaLocator.Dky_ten))
                .sendKeys("Long Hoàng");
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(AladaLocator.Dky_email))
                .sendKeys("tradt@bidv.com.vn");
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(AladaLocator.Dky_nhaplaiEmail))
                .sendKeys("tradt@bidv.com.vn");
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(AladaLocator.Dky_Matkhau))
                .sendKeys("LHL2510@");
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(AladaLocator.Dky_nhaplaiMatkhau))
                .sendKeys("LHL2510@");
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(AladaLocator.Dky_Dienthoai))
                .sendKeys("0973326740");
        WebElement btn = findVisibleElement(AladaLocator.Dky_button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
        btn.click();
        WebElement khctBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(AladaLocator.KHCT));
        Assert.assertTrue(khctBtn.isDisplayed(), "Không tìm thấy nút 'Khóa học của tôi'");
    }
    @Test
    public void DkyFooter() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement DkyFooter = findVisibleElement(AladaLocator.DkyFooter);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DkyFooter);
        DkyFooter.click();
        // Nhập vào ô Họ và tên
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(AladaLocator.Dky_ten))
                .sendKeys("Lê Thị Hoàng Long");
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(AladaLocator.Dky_email))
                .sendKeys("tradt@sea.com.vn");
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(AladaLocator.Dky_nhaplaiEmail))
                .sendKeys("tradt@sea.com.vn");
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(AladaLocator.Dky_Matkhau))
                .sendKeys("Nenchohaynenquen@");
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(AladaLocator.Dky_nhaplaiMatkhau))
                .sendKeys("Nenchohaynenquen@");
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(AladaLocator.Dky_Dienthoai))
                .sendKeys("0973326742");
        WebElement Dkybutton2 = findVisibleElement(AladaLocator.Dky_button2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Dkybutton2);
        Dkybutton2.click();
        WebElement khctBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(AladaLocator.KHCT));
        Assert.assertTrue(khctBtn.isDisplayed(), "Không tìm thấy nút 'Khóa học của tôi'");

    }
}

