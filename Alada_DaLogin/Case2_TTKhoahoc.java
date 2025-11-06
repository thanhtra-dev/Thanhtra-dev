package Alada_DaLogin;
import common.commonbase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageLocator.AladaLocator;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Case2_TTKhoahoc extends commonbase{
    Case0_LoginPage loginPage;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() throws InterruptedException {
        loginPage = new Case0_LoginPage();
        loginPage.login("tradt@bidv.com.vn", "LHL2510@");
        // Khởi tạo WebDriverWait trong setup() trước khi sử dụng
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));  // Khoi tao WebDriverWait
    }
    @Test
    public void TTkhoahoc() throws InterruptedException {
        List<WebElement> ListKhoahocCoPhi = driver.findElements(AladaLocator.KhoahocCoPhi);
        Assert.assertFalse(ListKhoahocCoPhi.isEmpty(),"Khong tim thay khoa hoc nao");
        Random rand = new Random();
        int chonKhoahoc = rand.nextInt(ListKhoahocCoPhi.size());
        WebElement Khoahoc = ListKhoahocCoPhi.get(chonKhoahoc);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Khoahoc);
        Khoahoc.click();
        WebElement DkyHocButton = wait.until(ExpectedConditions.elementToBeClickable(AladaLocator.Dangkyhoc));
        DkyHocButton.click();

        WebElement TTButton = wait.until(ExpectedConditions.elementToBeClickable(AladaLocator.ThanhToan));
        TTButton.click();

        String expectedText = "Số tiền bạn chưa đủ để thanh toán khóa học này";
        WebDriverWait waitAlert = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = waitAlert.until(ExpectedConditions.alertIsPresent());
        String actualText = alert.getText();
        Assert.assertTrue(actualText.contains(expectedText), "Alert không chứa text mong đợi. Thực tế: " + actualText);
    }

}
