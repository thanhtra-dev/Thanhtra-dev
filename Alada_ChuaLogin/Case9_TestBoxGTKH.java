package Alada_ChuaLogin;
import common.commonbase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocator.AladaLocator;
import constant.URL;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Case9_TestBoxGTKH extends commonbase{
    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        initChromeBrowser(URL.Alada_Trangchu);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement Khoahocrandom = driver.findElement(AladaLocator.KhoahocRandom);
        Khoahocrandom.click();
        Thread.sleep(5000);
    }
    @Test
    public void TestFullBox() {
        // Ktra du 8 thanh phan
        Assert.assertFalse(driver.findElements(AladaLocator.GTKH_box).isEmpty(), "Thiếu Giới thiệu khóa học");
        Assert.assertFalse(driver.findElements(AladaLocator.NDKH_box).isEmpty(), "Thiếu Nội dung khóa học");
        Assert.assertFalse(driver.findElements(AladaLocator.GV_box).isEmpty(), "Thiếu Giảng viên");
        Assert.assertFalse(driver.findElements(AladaLocator.KHLQ_box).isEmpty(), "Thiếu Khóa học liên quan");
        Assert.assertFalse(driver.findElements(AladaLocator.DGKH_box).isEmpty(), "Thiếu Đánh giá khóa học");
        Assert.assertFalse(driver.findElements(AladaLocator.Dkyhoc_box).isEmpty(), "Thiếu nút Đăng ký học");
    }

}
