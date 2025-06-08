package automation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Alada_loginpage {
    private WebDriver driver;
    @FindBy(id = "txtLoginUsername") WebElement TXTDangnhap_Email;
    @FindBy(id = "txtlLoginPassword") WebElement TXTDangnhap_Pass;
    @FindBy(xpath = "//button[text()='ĐĂNG NHẬP'and contains(@class,'pass btn_submit')]") WebElement BTNSUBMIT;
    public Alada_loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void LoginTK(String email, String password) {
        TXTDangnhap_Email.sendKeys(email);
        TXTDangnhap_Pass.sendKeys(password);
        BTNSUBMIT.click();

    }

    public void editInfoAlada(String mail, String number, String number1, String number2) {
    }

    public String getAlertTextAndAccept() {
    }
}
