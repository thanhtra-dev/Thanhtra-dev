package SauceDemo;
import common.commonbase;
import constant.URL;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageLocator.SaucedemoLocator;
import java.time.Duration;

public class Case1_TestLogin extends commonbase {
    @Test
    public void loginTC() throws InterruptedException {
        // Mở trang saucedemo
        initChromeBrowser(URL.Saucedemo_URL);

        // Khởi tạo WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));

        // Nhập email và mật khẩu
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Username));
        usernameField.sendKeys("standard_user");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Password));
        passwordField.sendKeys("secret_sauce");

        WebElement Loginbtn = wait.until(ExpectedConditions.elementToBeClickable(SaucedemoLocator.Login));
        Loginbtn.click();

        WebDriverWait fluentWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement ShoppingCart = fluentWait.until(ExpectedConditions.elementToBeClickable(SaucedemoLocator.ShoppingCart));
        Thread.sleep(5000);

        // Assert phần tử hiển thị
        Assert.assertTrue(ShoppingCart.isDisplayed(), "Không tìm thấy Gio hang)");
    }
    @Test
    public void loginLocked() throws InterruptedException {
        // Mo trang saucedemo
        initChromeBrowser(URL.Saucedemo_URL);
        //Khoi tao WebDriver Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Nhap email va mat khau
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Username));
        usernameField.sendKeys("locked_out_user");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Password));
        passwordField.sendKeys("secret_sauce");

        WebElement Loginbtn = wait.until(ExpectedConditions.elementToBeClickable(SaucedemoLocator.Login));
        Loginbtn.click();

        WebDriverWait fluentWait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement WarningLock = fluentWait.until(ExpectedConditions.elementToBeClickable(SaucedemoLocator.Lock_warning));
        Thread.sleep(5000);

        //Assert phan tu hien thi
        Assert.assertTrue(WarningLock.isDisplayed(),"Khong thay warning lock");
    }
    @Test
    public void loginProblemUser() throws InterruptedException {
        //Mo trang saucedemo
        initChromeBrowser(URL.Saucedemo_URL);
        //Khoi tao WebDriver Wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        //Nhap email va matkhau
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Username));
        usernameField.sendKeys("problem_user");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Password));
        passwordField.sendKeys("secret_sauce");

        WebElement Loginbtn = wait.until(ExpectedConditions.elementToBeClickable(SaucedemoLocator.Login));
        Loginbtn.click();

        WebDriverWait fluentWait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement anhLoi2 = fluentWait.until(ExpectedConditions.elementToBeClickable(SaucedemoLocator.AnhLoi2));
        Thread.sleep(5000);

        //Assert phan tu hien thi
        Assert.assertTrue(anhLoi2.isDisplayed(),"Khong thay anh loi");
    }
    @Test
    public void loginPerformance() throws InterruptedException {
        //Mo trang saucedemo
        initChromeBrowser(URL.Saucedemo_URL);
        //Khoi tao WebDriver Wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        //Nhap email va matkhau
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Username));
        usernameField.sendKeys("performance_glitch_user");

        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(SaucedemoLocator.Password));
        passwordField.sendKeys("secret_sauce");

        WebElement Loginbtn = wait.until(ExpectedConditions.elementToBeClickable(SaucedemoLocator.Login));
        long startTime = System.currentTimeMillis();
        Loginbtn.click();

        WebDriverWait longWait = new WebDriverWait(driver,Duration.ofSeconds(30));
        longWait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.ShoppingCart));
        long endtime = System.currentTimeMillis();

        long loadTime = endtime - startTime;

        System.out.println("Thời gian load:"+loadTime+"ms");

        //Assert: neu loadtime > 5000ms thì pass, ngược lại là fail
        Assert.assertTrue(loadTime> 5000,"load qua nhanh khong dung voi performance test");

    }


}



