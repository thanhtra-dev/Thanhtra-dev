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
import java.util.Random;

public class Case5_ValidateCheckoutInfo extends commonbase {
    @BeforeMethod
    public void setup(){
        initChromeBrowser(URL.Saucedemo_URL);
        Case0_LoginPass loginPass = new Case0_LoginPass();
        loginPass.login("standard_user","secret_sauce");
    }
    @Test
    public void ThieuFirstname() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(05));
        List<WebElement> listAddToCart = driver.findElements(SaucedemoLocator.AddToCart_btn);
        //Chon ngau nhien 1 sp
        Random rand = new Random();
        int index = rand.nextInt(listAddToCart.size());
        WebElement AddToCart_random = listAddToCart.get(index);
        AddToCart_random.click();

        WebElement ShoppingCart
                = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.ShoppingCart));
        ShoppingCart.click();
        Thread.sleep(3000);

        WebElement Checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Checkout));
        Checkout.click();
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(SaucedemoLocator.LastName))
                .sendKeys("Tảng băng");
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(SaucedemoLocator.PostalCode))
                .sendKeys("LHL");

        WebElement Continue_button
                = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Continue));
        Continue_button.click();

        WebElement Error1 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Error1));
        Assert.assertTrue(Error1.isDisplayed(), "Không tìm thấy error1");
    }

    @Test
    public void ThieuLastname() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(05));
        List<WebElement> listAddToCart = driver.findElements(SaucedemoLocator.AddToCart_btn);
        //Chon ngau nhien 1 sp
        Random rand = new Random();
        int index = rand.nextInt(listAddToCart.size());
        WebElement AddToCart_random = listAddToCart.get(index);
        AddToCart_random.click();

        WebElement ShoppingCart
                = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.ShoppingCart));
        ShoppingCart.click();
        Thread.sleep(3000);

        WebElement Checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Checkout));
        Checkout.click();
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(SaucedemoLocator.FirstName))
                .sendKeys("Divyans");
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(SaucedemoLocator.PostalCode))
                .sendKeys("Long Hoang Le");

        WebElement Continue_button
                = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Continue));
        Continue_button.click();

        WebElement Error2 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Error2));
        Assert.assertTrue(Error2.isDisplayed(), "Không tìm thấy error1");
    }
    @Test
    public void ThieuPostalCode() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(04));
        List<WebElement> listAddToCart = driver.findElements(SaucedemoLocator.AddToCart_btn);
        //Chon ngau nhien 1 sp
        Random rand = new Random();
        int index = rand.nextInt(listAddToCart.size());
        WebElement AddToCart_random = listAddToCart.get(index);
        AddToCart_random.click();

        WebElement ShoppingCart
                = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.ShoppingCart));
        ShoppingCart.click();
        Thread.sleep(3000);

        WebElement Checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Checkout));
        Checkout.click();
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(SaucedemoLocator.FirstName))
                .sendKeys("Nho c den nhuong nao");
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(SaucedemoLocator.LastName))
                .sendKeys("2510");

        WebElement Continue_button
                = wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Continue));
        Continue_button.click();

        WebElement Error3 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Error3));
        Assert.assertTrue(Error3.isDisplayed(), "Không tìm thấy error1");
    }
}
