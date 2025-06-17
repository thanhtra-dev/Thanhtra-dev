package Testsuite;

import automation.common.commonbase;
import constant.CT_PageURL;
import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class Day17btvn_Mediamart extends commonbase {
    @BeforeMethod
    public void openChromeBrowser() {
        driver = initChromeBrowser(CT_PageURL.Mediamart_URL);
    }

    @Test
    public void handleIframe(){
        scrollToElement(By.xpath("//iframe[contains(@src,'Zalo')]"));
        driver.switchTo().frame(0);
        click(By.xpath("//div[@class='za-chat__head-box']"));
        click(By.xpath("//div[text()='Chat nhanh']"));
        assertTrue(isElementPresent(By.xpath("//div[text()='Xin chào! Siêu thị điện máy MediaMart rất vui được hỗ trợ bạn.']")));
    }

}
