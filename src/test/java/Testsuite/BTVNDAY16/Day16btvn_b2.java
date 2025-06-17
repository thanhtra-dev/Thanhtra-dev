package Testsuite;

import automation.common.commonbase;
import constant.CT_PageURL;
import junit.framework.TestCase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class Day16btvn_b2 extends commonbase {
    @BeforeMethod

    public void openChromeBrowser() {
        driver = initChromeBrowser(CT_PageURL.SeleniumPractice_URL);

    }
    @Test
    public void AssertText(){
        click(By.xpath("//button[@onclick='myFunction()']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        System.out.println(alertText);
        assertEquals(alertText,"Welcome to Selenium Webdriver Tutorial");
    }

}
