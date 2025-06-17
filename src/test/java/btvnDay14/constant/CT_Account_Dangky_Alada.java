package constant;

import org.openqa.selenium.By;

public class CT_Account_Dangky_Alada {
    public static By TxtName = By.id("txtFirstname");
    public static By TxtEmail = By.id("txtEmail");
    public static By ReEmail = By.id("txtCEmail");
    public static By TxtPassword = By.id("txtPassword");
    public static By RePassword = By.id("txtCPassword");
    public static By PhoneNumber = By.id("txtPhone");
    public static By Check = By.id("chkRight");
    public static By BtnDangky = By.xpath("//button[@type='submit']");
    //cái nào mà ko có id thì mới phải dùng đến xpath
}
