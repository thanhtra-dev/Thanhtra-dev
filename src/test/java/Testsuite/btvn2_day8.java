package Testsuite;

import automation.common.commonbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class btvn2_day8 extends commonbase {
    String URL = "https://automationfc.github.io/basic-form/index.html";
    @Test
    public void NameById()
    {
        driver = initChromeBrowser(URL);
        WebElement txtName = driver.findElement(By.id("name"));
        System.out.println("Element Name");
    }

    @Test
    public void NameByname()
    {
        driver = initChromeBrowser(URL);
        WebElement txtName = driver.findElement(By.name("name"));
        System.out.println("Element Name");
    }

    @Test
    public void AddressById()
    {
        driver = initChromeBrowser(URL);
        WebElement txtAddress = driver.findElement(By.id("address"));
        System.out.println("Element Address");
    }

    @Test
    public void AddressByname()
    {
        driver = initChromeBrowser(URL);
        WebElement txtAddress = driver.findElement(By.name("address"));
        System.out.println("Element Address");
    }

    @Test
    public void EmailById()
    {
        driver = initChromeBrowser(URL);
        WebElement txtEmail = driver.findElement(By.id("email"));
        System.out.println("Element Email");
    }

    @Test
    public void EmailByname()
    {
        driver = initChromeBrowser(URL);
        WebElement txtEmail = driver.findElement(By.name("email"));
        System.out.println("Element Email");
    }

    @Test
    public void PasswordById()
    {
        driver = initChromeBrowser(URL);
        WebElement txtPassword = driver.findElement(By.id("password"));
        System.out.println("Element Password");
    }

    @Test
    public void PasswordByname()
    {
        driver = initChromeBrowser(URL);
        WebElement txtPassword = driver.findElement(By.name("password"));
        System.out.println("Element Password");
    }

}
