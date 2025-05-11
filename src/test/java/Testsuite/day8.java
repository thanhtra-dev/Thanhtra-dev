package Testsuite;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import automation.common.commonbase;

public class day8 extends commonbase {
    String URL = "https://alada.vn/tai-khoan/dang-nhap.html";
    @Test
    public void locateElementById()
    {
        driver = initChromeBrowser(URL);
        WebElement txtUsername = driver.findElement(By.id("txtLoginUsername"));
        System.out.println("Element username: " + txtUsername.getText());
    }
    @Test
    public void locateElementByName()
    {
        driver = initChromeBrowser(URL);
        WebElement txtPass = driver.findElement(By.name("txtLoginPassword"));
        System.out.println("Element pass: " + txtPass.getText());
    }
    @Test
    public void locateElementByLinkText()
    {
        driver = initChromeBrowser(URL);
        WebElement linkForgotPass = driver.findElement(By.linkText("Quên mật khẩu?"));
        System.out.println("Element link forgot pass: " + linkForgotPass.getText());

        WebElement linkNoAccount = driver.findElement(By.partialLinkText("Chưa có tài khoản"));
        System.out.println("Element link no account: " + linkNoAccount.getText());
    }
    @Test
    public void locateElementByClasName_TagName()
    {
        driver = initChromeBrowser(URL);
        WebElement btHopTacGD = driver.findElement(By.className("btn-hoptac"));
        System.out.println("Element bt hop Tac GD: " + btHopTacGD.getText());

        WebElement btDangNhap = driver.findElement(By.className("btn-submit"));
        System.out.println("Element bt DangNhap: " + btDangNhap.getText());
    }

}

