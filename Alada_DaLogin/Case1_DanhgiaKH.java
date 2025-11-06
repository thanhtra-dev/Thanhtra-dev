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

public class Case1_DanhgiaKH extends commonbase {
    Case0_LoginPage loginPage;
    WebDriverWait wait; // Khai báo WebDriverWait

    @BeforeMethod
    public void setup() throws InterruptedException {
        loginPage = new Case0_LoginPage();
        loginPage.login("tradt@bidv.com.vn", "LHL2510@");
        // Khởi tạo WebDriverWait trong setup() trước khi sử dụng
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));  // Khoi tao WebDriverWait
    }
    @Test
    public void OnlyStarRate() throws InterruptedException {
        // Tìm kiếm khóa học để đánh giá
        List<WebElement> listKhoahoc = driver.findElements(AladaLocator.KhoahocRandom);
        Assert.assertFalse(listKhoahoc.isEmpty(), "Không tìm thấy khóa học nào");

        // Lấy random 1 khóa học
        Random rand = new Random();
        int chonRandomkhoahoc = rand.nextInt(listKhoahoc.size());
        WebElement Khoahocrandom = listKhoahoc.get(chonRandomkhoahoc);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Khoahocrandom);
        Khoahocrandom.click();

        WebElement starRateElement = wait.until(ExpectedConditions.elementToBeClickable(AladaLocator.StarRateRandom));
        starRateElement.click();

        // Lấy danh sách các ngôi sao
        List<WebElement> listStar = driver.findElements(AladaLocator.StarRateRandom);
        Assert.assertFalse(listStar.isEmpty(), "Không tìm thấy ngôi sao nào");

        // Lấy random 1 ngôi sao
        int index2 = rand.nextInt(listStar.size());
        WebElement Saorandom = listStar.get(index2);
        // Scroll đến ngôi sao và click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Saorandom);
        Saorandom.click();
        Thread.sleep(2000);

        WebElement GuiNhanxet = wait.until(ExpectedConditions.elementToBeClickable(AladaLocator.GuiNhanxet));
        GuiNhanxet.click();

        Alert alert = driver.switchTo().alert();

        String expectedText = "Vui lòng nhập nội dung đánh giá!";
        String actualText = alert.getText();
        Assert.assertEquals(actualText, expectedText);
    }
    @Test
    public void StarRateVaComment() throws InterruptedException {
        // Tìm kiếm khóa học để đánh giá
        List<WebElement> listKhoahoc = driver.findElements(AladaLocator.KhoahocRandom);
        Assert.assertFalse(listKhoahoc.isEmpty(), "Không tìm thấy khóa học nào");
        // Lấy random 1 khóa học
        Random rand = new Random();
        int chonRandomkhoahoc = rand.nextInt(listKhoahoc.size());
        WebElement Khoahocrandom = listKhoahoc.get(chonRandomkhoahoc);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Khoahocrandom);
        Khoahocrandom.click();

        WebElement starRateElement = wait.until(ExpectedConditions.elementToBeClickable(AladaLocator.StarRateRandom));
        starRateElement.click();

        // Lấy danh sách các ngôi sao
        List<WebElement> listStar = driver.findElements(AladaLocator.StarRateRandom);
        Assert.assertFalse(listStar.isEmpty(), "Không tìm thấy ngôi sao nào");
        // Lấy random 1 ngôi sao
        int index2 = rand.nextInt(listStar.size());
        WebElement Saorandom = listStar.get(index2);
        // Scroll đến ngôi sao và click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Saorandom);
        Saorandom.click();
        Thread.sleep(2000);
        // Gõ chữ "Hay lắm" vào vùng comment
        WebElement commentBox = driver.findElement(AladaLocator.VungComment);
        commentBox.sendKeys("Hay lắm");

        WebElement GuiNhanxet = wait.until(ExpectedConditions.elementToBeClickable(AladaLocator.GuiNhanxet));
        GuiNhanxet.click();

        // Chờ alert xuất hiện
        WebDriverWait waitAlert = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = waitAlert.until(ExpectedConditions.alertIsPresent());

        String actualText = alert.getText();
        String expectedText = "Cám ơn bạn đã đánh giá! Vui lòng đợi BQT kiểm duyệt.";
        Assert.assertEquals(actualText, expectedText);
    }
    @Test
    public void OnlyComment() throws InterruptedException {
        // Tìm kiếm khóa học để đánh giá
        List<WebElement> listKhoahoc = driver.findElements(AladaLocator.KhoahocRandom);
        Assert.assertFalse(listKhoahoc.isEmpty(), "Không tìm thấy khóa học nào");
        // Lấy random 1 khóa học
        Random rand = new Random();
        int chonRandomkhoahoc = rand.nextInt(listKhoahoc.size());
        WebElement Khoahocrandom = listKhoahoc.get(chonRandomkhoahoc);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Khoahocrandom);
        Khoahocrandom.click();

        // Gõ chữ "Hay lắm" vào vùng comment
        WebElement commentBox = driver.findElement(AladaLocator.VungComment);
        commentBox.sendKeys("Hay lắm");

        WebElement GuiNhanxet = wait.until(ExpectedConditions.elementToBeClickable(AladaLocator.GuiNhanxet));
        GuiNhanxet.click();

        // Chờ alert xuất hiện
        WebDriverWait waitAlert = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = waitAlert.until(ExpectedConditions.alertIsPresent());

        String actualText = alert.getText();
        String expectedText = "Cám ơn bạn đã đánh giá! Vui lòng đợi BQT kiểm duyệt.";
        Assert.assertEquals(actualText, expectedText);
    }
    @Test
    public void NoStarRateNoComment() throws InterruptedException {
        // Tìm kiếm khóa học để đánh giá
        List<WebElement> listKhoahoc = driver.findElements(AladaLocator.KhoahocRandom);
        Assert.assertFalse(listKhoahoc.isEmpty(), "Không tìm thấy khóa học nào");
        // Lấy random 1 khóa học
        Random rand = new Random();
        int chonRandomkhoahoc = rand.nextInt(listKhoahoc.size());
        WebElement Khoahocrandom = listKhoahoc.get(chonRandomkhoahoc);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Khoahocrandom);
        Khoahocrandom.click();
        Thread.sleep(5000);
        WebElement GuiNhanxet = wait.until(ExpectedConditions.elementToBeClickable(AladaLocator.GuiNhanxet));
        GuiNhanxet.click();
        // Chờ alert xuất hiện
        WebDriverWait waitAlert = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = waitAlert.until(ExpectedConditions.alertIsPresent());

        String actualText = alert.getText();
        String expectedText = "Vui lòng nhập nội dung đánh giá!";
        Assert.assertEquals(actualText, expectedText);
    }
    }


