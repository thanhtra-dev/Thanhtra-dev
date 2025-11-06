package Alada_ChuaLogin;
import common.commonbase;
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

public class Case12_TestMuitenDes extends commonbase {
    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        initChromeBrowser(URL.Alada_Trangchu);
        WebElement Khoahocrandom = driver.findElement(AladaLocator.KhoahocRandom);
        Khoahocrandom.click();
        Thread.sleep(5000);
    }

    @Test
    public void TestShowAndHideDescription() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> arrows = driver.findElements(AladaLocator.MuiTenDes);
        List<WebElement> descriptions = driver.findElements(AladaLocator.Description);

        for (int i = 0; i < arrows.size(); i++) {
            WebElement arrow = arrows.get(i);
            WebElement description = descriptions.get(i);

            // Nhấn lần 1 → hiện description
            arrow.click();
            wait.until(ExpectedConditions.visibilityOf(description));
            Assert.assertTrue(description.isDisplayed(), "Description k hiện ");
            Thread.sleep(5000);

            // Nhấn lần 2 → ẩn description
            arrow.click();
            wait.until(ExpectedConditions.invisibilityOf(description));
            Assert.assertFalse(description.isDisplayed(), "Description vẫn hiện ");
        }
    }
}
