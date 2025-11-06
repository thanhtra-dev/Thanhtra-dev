package SauceDemo;
import common.commonbase;
import constant.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageLocator.SaucedemoLocator;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Random;
//case3:neu ma nhan back home thi nhay vao trang inventory.html

public class Case6_CheckoutOverview extends commonbase {
    @BeforeMethod
    public void setup(){
        initChromeBrowser(URL.Saucedemo_URL);
        Case0_LoginPass loginPass = new Case0_LoginPass();
        loginPass.login("standard_user","secret_sauce");
    }
    @Test
    public void CancelDonhang() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(05));
        List<WebElement> listAddToCart = driver.findElements(SaucedemoLocator.AddToCart_btn);
        //Chon ngau nhien 1 sp
        Random rand = new Random();
        int index = rand.nextInt(listAddToCart.size());
        WebElement AddToCart_random = listAddToCart.get(index);
        AddToCart_random.click();
        WebElement ShoppingCart = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.ShoppingCart));
        ShoppingCart.click();
        Thread.sleep(2000);
        WebElement Checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Checkout));
        Checkout.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.FirstName)).sendKeys("Nho c biet nhuong nao");
        wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.LastName)).sendKeys("T12");
        wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.PostalCode)).sendKeys("2510");
        WebElement Continue_button = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Continue));
        Continue_button.click();
        Thread.sleep(2000);
        WebElement CANCEL_button = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.CANCEL2));
        CANCEL_button.click();
        Thread.sleep(2000);
        //Cho dieu huong sang trang Dang nhap
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://www.saucedemo.com/inventory.html"));
        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://www.saucedemo.com/inventory.html","Khong dieu huong den trang truoc");
    }
    @Test
    public void FinishDonhang() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(05));
        List<WebElement> listAddToCart = driver.findElements(SaucedemoLocator.AddToCart_btn);
        //Chon ngau nhien 1 sp
        Random rand = new Random();
        int index = rand.nextInt(listAddToCart.size());
        WebElement AddToCart_random = listAddToCart.get(index);
        AddToCart_random.click();
        WebElement ShoppingCart = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.ShoppingCart));
        ShoppingCart.click();
        Thread.sleep(2000);
        WebElement Checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Checkout));
        Checkout.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.FirstName)).sendKeys("Nho c biet nhuong nao");
        wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.LastName)).sendKeys("T12");
        wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.PostalCode)).sendKeys("2510");
        WebElement Continue_button = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Continue));
        Continue_button.click();
        Thread.sleep(2000);
        WebElement Finish_button = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.FINISH));
        Finish_button.click();
        Thread.sleep(2000);
        WebElement ThankyourOrder = driver.findElement(SaucedemoLocator.Thank);
        Assert.assertTrue(ThankyourOrder.isDisplayed(), "Không tìm thấy header");
    }
    @Test
    public void BackHome() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(05));
        List<WebElement> listAddToCart = driver.findElements(SaucedemoLocator.AddToCart_btn);
        //Chon ngau nhien 1 sp
        Random rand = new Random();
        int index = rand.nextInt(listAddToCart.size());
        WebElement AddToCart_random = listAddToCart.get(index);
        AddToCart_random.click();
        WebElement ShoppingCart = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.ShoppingCart));
        ShoppingCart.click();
        Thread.sleep(2000);
        WebElement Checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Checkout));
        Checkout.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.FirstName)).sendKeys("Nho c biet nhuong nao");
        wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.LastName)).sendKeys("T12");
        wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.PostalCode)).sendKeys("2510");
        WebElement Continue_button = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Continue));
        Continue_button.click();
        Thread.sleep(2000);
        WebElement Finish_button = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.FINISH));
        Finish_button.click();
        Thread.sleep(2000);
        WebElement Backhome = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.BackHomebutton));
        Backhome.click();
        Thread.sleep(2000);
        //Cho dieu huong sang trang Dang nhap
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://www.saucedemo.com/inventory.html"));
        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://www.saucedemo.com/inventory.html","Khong dieu huong den trang truoc");

    }

}
