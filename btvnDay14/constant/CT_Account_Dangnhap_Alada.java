package constant;

import org.openqa.selenium.By;

public class CT_Account_Dangnhap_Alada {
    public static By txtDangnhap_Email = By.id("txtLoginUsername");
    public static By txtDangnhap_Password = By.id("txtLoginPassword");
    public static By btnDangnhap =
            By.xpath("//button[text()='ĐĂNG NHẬP' " +
                    "and contains(@class,'pass btn_submit')]");
}
