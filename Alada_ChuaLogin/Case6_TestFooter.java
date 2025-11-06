package Alada_ChuaLogin;
import common.commonbase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocator.AladaLocator;
import constant.URL;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Objects;

public class Case6_TestFooter extends commonbase{
    @BeforeMethod
    public void openBrowser() {
        initChromeBrowser(URL.Alada_Trangchu);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }
    @Test
    public void Footer1_GT() throws InterruptedException{
        WebElement GioiThieu = driver.findElement(AladaLocator.Footer1_GT);
        GioiThieu.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        //Cho dieu huong sang trang GT
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://alada.vn/gioi-thieu.html"));

        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://alada.vn/gioi-thieu.html","Khong dieu huong den trang GT");
}
    @Test
    public void Footer2_LH() throws InterruptedException{
        WebElement LienHe = driver.findElement(AladaLocator.Footer2_Lienhe);
        LienHe.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        //Cho dieu huong sang trang LH
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://alada.vn/lien-he.html"));

        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://alada.vn/lien-he.html","Khong dieu huong den trang LH");
    }
    @Test
    public void Footer3_CSBM() throws InterruptedException{
        WebElement CSBM = driver.findElement(AladaLocator.Footer3_CSBM);
        CSBM.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        //Cho dieu huong sang trang CSBM
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://alada.vn/chinh-sach-bao-mat.html"));

        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://alada.vn/chinh-sach-bao-mat.html","Khong dieu huong den trang CSBM");
    }
    @Test
    public void Footer4_DKDV() throws InterruptedException{
        WebElement DKDV = driver.findElement(AladaLocator.Footer4_DKDV);
        DKDV.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        //Cho dieu huong sang trang DKDV
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://alada.vn/dieu-khoan-dich-vu.html"));

        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://alada.vn/dieu-khoan-dich-vu.html","Khong dieu huong den trang DKDV");
    }
    @Test
    public void Footer5_HDSD() throws InterruptedException{
        WebElement HDSD = driver.findElement(AladaLocator.Footer5_HDSD);
        HDSD.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        //Cho dieu huong sang trang HDSD
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://alada.vn/huong-dan-su-dung.html"));

        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://alada.vn/huong-dan-su-dung.html","Khong dieu huong den trang HDSD");
    }

    @Test
    public void Footer6_CHTG() throws InterruptedException{
        WebElement HDSD = driver.findElement(AladaLocator.Footer6_CHTG);
        HDSD.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        //Cho dieu huong sang trang HDSD
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://alada.vn/cau-hoi-thuong-gap.html"));

        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://alada.vn/cau-hoi-thuong-gap.html","Khong dieu huong den trang CHTG");
    }

    @Test
    public void Footer7_HDTT() throws InterruptedException{
        WebElement HDTT = driver.findElement(AladaLocator.Footer7_HDTT);
        HDTT.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        //Cho dieu huong sang trang HDSD
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://alada.vn/huong-dan-thanh-toan.html"));

        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://alada.vn/huong-dan-thanh-toan.html","Khong dieu huong den trang HDTT");
    }

    @Test
    public void Footer8_CSHTHP() throws InterruptedException{
        WebElement CSHTHP = driver.findElement(AladaLocator.Footer8_CSHTHP);
        CSHTHP.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        //Cho dieu huong sang trang HDSD
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://alada.vn/chinh-sach-hoan-tra-hoc-phi.html"));

        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://alada.vn/chinh-sach-hoan-tra-hoc-phi.html","Khong dieu huong den trang CSHTHP");
    }
}
