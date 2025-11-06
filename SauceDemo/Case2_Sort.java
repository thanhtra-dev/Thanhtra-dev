package SauceDemo;
import common.commonbase;
import constant.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageLocator.SaucedemoLocator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Case2_Sort extends commonbase {
    @BeforeMethod
    public void setup() {
        initChromeBrowser(URL.Saucedemo_URL);
        Case0_LoginPass loginPass = new Case0_LoginPass();
        loginPass.login("standard_user", "secret_sauce");
    }
    @Test
    public void SortAtoZ(){
        WebElement sortDropdown = driver.findElement(SaucedemoLocator.SortDropdown);
        Select select = new Select(sortDropdown);
        select.selectByValue("az");

        List<WebElement> productElements = driver.findElements(SaucedemoLocator.TenProduct);
        List<String> actualProductNames = new ArrayList<>();
        for (WebElement el:productElements){
            actualProductNames.add(el.getText());
        }
        List<String> expectedProductNames = new ArrayList<>(actualProductNames);
        Collections.sort(expectedProductNames);//Java sort mac dinh

        Assert.assertEquals(actualProductNames,expectedProductNames,
                "Products are not sorted A to Z correctly");
    }
    @Test
    public void SortZtoA(){
        WebElement sortDropdown = driver.findElement(SaucedemoLocator.SortDropdown);
        Select select = new Select(sortDropdown);
        select.selectByValue("za");

        List<WebElement> productElements = driver.findElements(SaucedemoLocator.TenProduct);
        List<String> actualProductNames = new ArrayList<>();
        for (WebElement el: productElements){
            actualProductNames.add(el.getText());
        }
        List<String>expectedProductNames = new ArrayList<>(actualProductNames);
        Collections.sort(expectedProductNames,Collections.reverseOrder());

        Assert.assertEquals(actualProductNames,expectedProductNames,
                "Products are not sorted Z to A correctly");
    }
    @Test
    public void SortPriceLoHi(){
        WebElement sortDropdown = driver.findElement(SaucedemoLocator.SortDropdown);
        Select select = new Select(sortDropdown);
        select.selectByValue("lohi");

        List<WebElement> priceElements = driver.findElements(SaucedemoLocator.Giatien);
        List<Double> actualPrices = new ArrayList<Double>();
        for (WebElement el: priceElements){
            String priceText = el.getText().replace("$","");

            actualPrices.add(Double.parseDouble(priceText));
        }
        //Tao list copy va sort tang dan
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);
        //Assert
        Assert.assertEquals(actualPrices,expectedPrices,"Price ko duoc sap xep dung");
    }
    @Test
    public void SortPriceHiLo(){
        WebElement sortDropdown = driver.findElement(SaucedemoLocator.SortDropdown);
        Select select = new Select(sortDropdown);
        select.selectByValue("hilo");

        List<WebElement> priceElements = driver.findElements(SaucedemoLocator.Giatien);
        //lay ra tat ca gia tien ma no thay
        //actual price thi cung la no thoi nhung ma phien ban bo het may cai do la di
        List<Double> actualPrices = new ArrayList<Double>();
        for (WebElement el: priceElements){
            String priceText = el.getText().replace("$","");
            actualPrices.add(Double.parseDouble(priceText));
        }
        //tao list copy va sort giam dan
        //tao list copy
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        //sort giam dan thi phai dung reverseOrder
        Collections.sort(expectedPrices,Collections.reverseOrder());
        //Assert
        Assert.assertEquals(actualPrices,expectedPrices,"Price ko duoc sap xep dung");
    }

}
