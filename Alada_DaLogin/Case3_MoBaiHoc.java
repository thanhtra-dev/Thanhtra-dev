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

public class Case3_MoBaiHoc extends commonbase{
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
    public void VaoHocTuTrangChu() throws InterruptedException {
        Thread.sleep(2000);
        WebElement KHNB = driver.findElement(AladaLocator.KHNB);
        KHNB.click();
        Thread.sleep(5000);
        List<WebElement> ListKhoahocFree = driver.findElements(AladaLocator.KhoahocFree);
        Assert.assertFalse(ListKhoahocFree.isEmpty(),"Khong tim thay khoa hoc nao");
        Random rand = new Random();
        int chonKhoaFree = rand.nextInt(ListKhoahocFree.size());
        WebElement KhoahocFree = ListKhoahocFree.get(chonKhoaFree);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", KhoahocFree);
        KhoahocFree.click();
        Thread.sleep(3000);
        WebElement VaoHocTiep = wait.until(ExpectedConditions.elementToBeClickable(AladaLocator.Vaohoctiep));
        VaoHocTiep.click();
        WebElement VideoLesson = wait.until(
                ExpectedConditions.visibilityOfElementLocated(AladaLocator.VideoLesson));
        Assert.assertTrue(VideoLesson.isDisplayed(), "Không tìm thấy video nào");
    }
    @Test
    public void VaohocTuKHCT() throws InterruptedException {
        Thread.sleep(2000);
        WebElement Profile = driver.findElement(AladaLocator.Profile);
        Profile.click();

        Thread.sleep(2000);
        WebElement Cart = driver.findElement(AladaLocator.Cart);
        Cart.click();

        Thread.sleep(2000);
        List<WebElement> ListVaohoctiep = driver.findElements(AladaLocator.VaoHocTiep_button);
        Assert.assertFalse(ListVaohoctiep.isEmpty(), "không thấy button Vào học tiếp");

        Random rand2 = new Random();
        int chonVaohoctiep = rand2.nextInt(ListVaohoctiep.size());
        WebElement buttonVaohoctiep = ListVaohoctiep.get(chonVaohoctiep);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonVaohoctiep);
        buttonVaohoctiep.click();
        Thread.sleep(5000);

        // Kiểm tra xem phần tử GuiCauhoi có trong DOM hay không
        System.out.println("Page Source before waiting for GuiCauhoi: " + driver.getPageSource());

        // Chờ phần tử GuiCauhoi có trong DOM và có thể tương tác
        WebDriverWait fluentWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement GuiCauhoi = fluentWait.until(ExpectedConditions.elementToBeClickable(AladaLocator.GuiCauhoi));

        // Kiểm tra phần tử GuiCauhoi hiển thị trên màn hình
        fluentWait.until(ExpectedConditions.visibilityOf(GuiCauhoi)); // Kiểm tra phần tử có hiển thị trên màn hình

        // Assert phần tử hiển thị
        Assert.assertTrue(GuiCauhoi.isDisplayed(), "Không tìm thấy title bài học (GuiCauhoi)");
    }
}
