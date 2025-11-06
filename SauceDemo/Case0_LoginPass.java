package SauceDemo;
import common.commonbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageLocator.SaucedemoLocator;
import java.time.Duration;

public class Case0_LoginPass extends commonbase {
    WebDriverWait wait;

    public void login(String username, String password) {
        // Khởi tạo wait (driver đã được mở sẵn từ @BeforeMethod trong commonbase)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Nhập username và password
        wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Username)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SaucedemoLocator.Password)).sendKeys(password);

        // Click login
        WebElement Loginbtn = wait.until(ExpectedConditions.elementToBeClickable(SaucedemoLocator.Login));
        Loginbtn.click();
    }
}

