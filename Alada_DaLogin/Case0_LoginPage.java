package Alada_DaLogin;
import common.commonbase;
import constant.URL;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pageLocator.AladaLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Case0_LoginPage extends commonbase {
    public void login(String email, String password) throws InterruptedException {
        //Mo trang Alada
        initChromeBrowser(URL.Alada_Trangchu);
        //Khoi tao WebDriverWait trong phuong thuc Login
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        //Cho va click vao nut dang nhap
        WebElement btnXanh = findVisibleElement(AladaLocator.DangNhapXanh);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",btnXanh);
        btnXanh.click();
        //Nhap email va matkhau
        wait.until(ExpectedConditions.visibilityOfElementLocated(AladaLocator.DangNhap_Email)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(AladaLocator.DangNhap_Matkhau)).sendKeys(password);

        //click vao nút đăng nhập
        WebElement btn = findVisibleElement(AladaLocator.DangNhap_button);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",btn);
        btn.click();
    }
}
