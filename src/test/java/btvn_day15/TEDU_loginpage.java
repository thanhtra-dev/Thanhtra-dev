package automation.pageLocator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TEDU_loginpage {
    private WebDriver driver;
    @FindBy(xpath = "//a[@title='Đăng nhập']") WebElement linkDangNhap;
    @FindBy(name = "Username") WebElement textUsername;
    @FindBy(name = "Password") WebElement textPassword;
    @FindBy(xpath = "//button[text()='Đăng nhập']") WebElement btnDangNhap;

    public TEDU_loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginFunction(String username, String password) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", linkDangNhap);
        Thread.sleep(1000);;
        js.executeScript("document.getElementById('Username').setAttribute('value',username);");
        js.executeScript("document.getElementById('Password').setAttribute('value',password);");
        btnDangNhap.click();

    }
}
