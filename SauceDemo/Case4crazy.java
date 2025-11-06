package SauceDemo;
import common.commonbase;
import constant.URL;
import org.openqa.selenium.By;
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

public class Case4crazy extends commonbase {
    @BeforeMethod
    public void setup() {
        initChromeBrowser(URL.Saucedemo_URL);
        Case0_LoginPass loginPass = new Case0_LoginPass();
        loginPass.login("standard_user", "secret_sauce");

    }
    @Test
    public void ContinueShopping() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> listAddToCart = driver.findElements(SaucedemoLocator.AddToCart_btn);
        Assert.assertFalse(listAddToCart.isEmpty(), "Không thấy khóa học nổi bật nào");

        // Chọn ngẫu nhiên 1 sản phẩm
        Random rand = new Random();
        int index = rand.nextInt(listAddToCart.size());
        WebElement AddToCart_random = listAddToCart.get(index);
        AddToCart_random.click();

        WebElement ShoppingCart = wait.until(
                ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.ShoppingCart)
        );
        ShoppingCart.click();

        WebElement ContinueShopping = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("continue-shopping"))
        );
        ContinueShopping.click();

        wait.until(driver -> driver.getCurrentUrl().contains("inventory.html"));
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://www.saucedemo.com/inventory.html", "Không điều hướng đến trang cũ");
    }
}
