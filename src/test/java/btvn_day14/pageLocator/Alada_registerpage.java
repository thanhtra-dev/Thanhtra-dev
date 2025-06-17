package automation.pageLocator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alada_registerpage {
    private WebDriver driver;
    @FindBy(id= "txtFirstname") WebElement TxtName;
    @FindBy(id= "txtEmail") WebElement TxtEmail;
    @FindBy(id = "txtCEmail") WebElement ReEmail;
    @FindBy(id = "txtPassword") WebElement TxtPassword;
    @FindBy(id = "txtCPassword" ) WebElement RePassword;
    @FindBy(id = "txtPhone") WebElement Phone;
    @FindBy(id = "chkRight") WebElement Check;
    @FindBy(xpath = "//button[@type='submit']") WebElement BtnDangky;

    public Alada_registerpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void RegisterFunction
            (String hovaten, String email, String Nhaplaiemail, String password, String Nhaplaipass, String phone ) {
        TxtName.sendKeys(hovaten);
        TxtEmail.sendKeys(email);
        ReEmail.sendKeys(Nhaplaiemail);
        TxtPassword.sendKeys(password);
        RePassword.sendKeys(Nhaplaipass);
        Phone.sendKeys(phone);
        Check.click();
        BtnDangky.click();
    }
    public String getAlertTextAndAccept() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
        return text;
    }
}
