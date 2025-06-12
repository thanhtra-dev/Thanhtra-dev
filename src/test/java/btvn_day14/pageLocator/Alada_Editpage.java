package automation.pageLocator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alada_Editpage {
    private WebDriver driver;
    @FindBy(xpath = "//input[@value='thanhtraneu17@gmail.com']") WebElement TxtTendangnhap;
    @FindBy(id = "txtpassword") WebElement TxtMatkhau;
    @FindBy(id = "txtnewpass") WebElement TxtNewpass;
    @FindBy(id = "txtrenewpass") WebElement TxtRenewpass;
    @FindBy(xpath = "//button[text()='Lưu mật khẩu mới']") WebElement BtnLuunewpass;
    public Alada_Editpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void EditInfo(String email, String pass, String newpass, String renewpass){
        String oldEmail = TxtTendangnhap.getAttribute("thanhtraneu17@gmail.com");
        TxtMatkhau.sendKeys(pass);
        TxtNewpass.sendKeys(newpass);
        TxtRenewpass.sendKeys(renewpass);
        BtnLuunewpass.click();
    }
    public String getAlertTextAndAccept(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
        return text;
    }
}
