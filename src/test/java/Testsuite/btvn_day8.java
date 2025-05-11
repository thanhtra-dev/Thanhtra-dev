package Testsuite;

import automation.common.commonbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class btvn_day8 extends commonbase {
    String URL = "https://selectorshub.com/xpath-practice-page/";

    @Test
    public void UserEmailByXpath() {
        driver = initChromeBrowser(URL);
        WebElement txtUserEmail = driver.findElement(By.xpath("//label[text()='User Email']"));
        System.out.println("Element User Email");
    }

    @Test
    public void PasswordByXpath() {
        driver = initChromeBrowser(URL);
        WebElement txtPassword = driver.findElement(By.xpath("//label[text()='Password']"));
        System.out.println("Element Password");
    }

    @Test
    public void Company() {
        driver = initChromeBrowser(URL);
        WebElement txtCompany = driver.findElement(By.xpath("//label[text()='Company']"));
        System.out.println("Element Company");
    }

    @Test
    public void MobileNumber() {
        driver = initChromeBrowser(URL);
        WebElement txtMobileNumber = driver.findElement(By.xpath("//label[text()='Mobile Number']"));
        System.out.println("Element Mobile Number");
    }

    @Test
    public void UserEmailByCssSelector() {
        driver = initChromeBrowser(URL);
        WebElement txtUserEmail = driver.findElement(By.cssSelector("label[for='User Email']"));
        System.out.println("Element User Email");
    }

    @Test
    public void PasswordByCssSelector() {
        driver = initChromeBrowser(URL);
        WebElement txtPassword = driver.findElement(By.cssSelector("label[for='Password']"));
        System.out.println("Element Password");
    }

    @Test
    public void CompanyByCssSelector() {
        driver = initChromeBrowser(URL);
        WebElement txtCompany = driver.findElement(By.cssSelector("label[for='Company']"));
        System.out.println("Element Company");
    }

    @Test
    public void MobileNumberByCssSelector() {
        driver = initChromeBrowser(URL);
        WebElement MobileNumber = driver.findElement(By.cssSelector("label[for='Mobile Number']"));
        System.out.println("Element Mobile Number");
    }
}
