package automation.pageLocator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TEDU_updatepass_page {
    private final WebDriver driver;
    @FindBy(id = "my_account") WebElement buttonTaikhoan;
    @FindBy(xpath = "//a[@title = 'Đổi mật khẩu']") WebElement buttonDoiMatKhau;
    @FindBy(id = "OldPassword") WebElement textOldPassword;
    @FindBy(id = "NewPassword") WebElement textNewPassword;
    @FindBy(id  = "ConfirmNewPassword") WebElement textConfirmNewPassword;
    @FindBy(xpath = "//input[@value='Cập nhật']") WebElement btnCapnhat;

    public TEDU_updatepass_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void updatePassword(String oldPassword, String newPassword) {
        buttonTaikhoan.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", buttonDoiMatKhau);
        buttonDoiMatKhau.click();
        textOldPassword.sendKeys(oldPassword);
        textNewPassword.sendKeys(newPassword);
        textConfirmNewPassword.sendKeys(newPassword);
        btnCapnhat.click();
    }



}
