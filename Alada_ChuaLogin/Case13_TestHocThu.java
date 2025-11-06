package Alada_ChuaLogin;
import common.commonbase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageLocator.AladaLocator;
import constant.URL;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class Case13_TestHocThu extends commonbase {
    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        initChromeBrowser(URL.Alada_Trangchu);
        WebElement Khoahocrandom = driver.findElement(AladaLocator.KhoahocRandom);
        Khoahocrandom.click();
        Thread.sleep(5000);
    }
    @Test
    public void TestHocThu() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> ListHocThu = driver.findElements(AladaLocator.HocThu);
        List<WebElement> ListVideo = driver.findElements(AladaLocator.VideoList);
        for (int i = 0; i < ListHocThu.size(); i++) {
            WebElement HocThu = ListHocThu.get(i);
            WebElement Video = ListVideo.get(i);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", HocThu);
            wait.until(ExpectedConditions.visibilityOf(Video));
            Assert.assertTrue(Video.isDisplayed(), "Video k hiện ");
    }
}
}
