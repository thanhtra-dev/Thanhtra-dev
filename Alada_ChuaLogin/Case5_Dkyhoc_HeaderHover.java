package Alada_ChuaLogin;
import common.commonbase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageLocator.AladaLocator;
import constant.URL;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Case5_Dkyhoc_HeaderHover extends commonbase {
    @BeforeMethod
    public void openBrowser() {
        initChromeBrowser(URL.ALADA_URL);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
        //Hover vao nut "Xem khoa hoc"
        WebElement xemKhoahocBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(AladaLocator.Xemkhoahoc));
        actions.moveToElement(xemKhoahocBtn).perform();

    }
    @Test(priority = 1)
    public void Khoahocnoibat_Hover() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement khoahocnoibat_btn = wait.until(ExpectedConditions.elementToBeClickable(AladaLocator.KhoahocNoibat));
        khoahocnoibat_btn.click();
        Thread.sleep(2000);
        //Lay DS khoa hoc con thuoc khoa hoc noi bat
        List<WebElement> listKhoahocnoibat = driver.findElements(AladaLocator.KhoahocNoibat_con);
        //Ktra xem co khoa hoc nao ko
        Assert.assertFalse(listKhoahocnoibat.isEmpty(), "Khong thay khoa hoc noi bat nao");
        //Lay random 1 khóa học
        Random rand = new Random();
        int index = rand.nextInt(listKhoahocnoibat.size());
        WebElement Khoahocnoibat_random = listKhoahocnoibat.get(index);
        //Scroll toi khoa hoc random va click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Khoahocnoibat_random);
        Khoahocnoibat_random.click();
        //chờ trang chi tiết và nút đăng ký học xuất hiện
        WebElement Dkyhocbtn = wait.until(driver -> driver.findElement(AladaLocator.Dkyhoc_btn));
        Dkyhocbtn.click();
        //Cho dieu huong sang trang Dang nhap
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://alada.vn/tai-khoan/dang-nhap.html"));
        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://alada.vn/tai-khoan/dang-nhap.html","Khong dieu huong den trang dang nhap");
    }

    @Test(priority = 2)
    public void Khoahocvuaramat_Hover() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement khoahocvuaramat_btn = wait.until(ExpectedConditions.elementToBeClickable(AladaLocator.Khoahocvuaramat));
        khoahocvuaramat_btn.click();
        Thread.sleep(2000);
        //Lay DS khoa hoc con thuoc khoa hoc vua ra mat
        List<WebElement> listKhoahocvuaramat = driver.findElements(AladaLocator.Khoahocvuaramat_con);
        //Ktra xem co khoa hoc nao ko
        Assert.assertFalse(listKhoahocvuaramat.isEmpty(), "Khong thay khoa hoc vua ra mat nao");
        //Lay random 1 khóa học
        Random rand = new Random();
        int index = rand.nextInt(listKhoahocvuaramat.size());
        WebElement Khoahocvuaramat_random = listKhoahocvuaramat.get(index);
        //Scroll toi khoa hoc random va click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Khoahocvuaramat_random);
        Khoahocvuaramat_random.click();
        //chờ trang chi tiết và nút đăng ký học xuất hiện
        WebElement Dkyhocbtn = wait.until(driver -> driver.findElement(AladaLocator.Dkyhoc_btn));
        Dkyhocbtn.click();
        //Cho dieu huong sang trang Dang nhap
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://alada.vn/tai-khoan/dang-nhap.html"));
        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://alada.vn/tai-khoan/dang-nhap.html","Khong dieu huong den trang dang nhap");
    }

    @Test(priority = 3)
    public void KhuyenMaiHot_Hover() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement KhuyenMaiHot = findVisibleElement(AladaLocator.Khuyenmaihot);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", KhuyenMaiHot);
        KhuyenMaiHot.click();
        //Lay DS khoa hoc con thuoc khoa hoc noi bat
        List<WebElement> listKhuyenMaiHot = driver.findElements(AladaLocator.Khuyenmaihot_con);
        //Ktra xem co khoa hoc nao ko
        Assert.assertFalse(listKhuyenMaiHot.isEmpty(), "Khong thay khoa hoc khuyen mai hot nao");
        //Lay random 1 khóa học
        Random rand = new Random();
        int index = rand.nextInt(listKhuyenMaiHot.size());
        WebElement KhuyenMaiHot_random = listKhuyenMaiHot.get(index);
        //Scroll toi khoa hoc random va click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", KhuyenMaiHot_random);
        KhuyenMaiHot_random.click();
        //chờ trang chi tiết và nút đăng ký học xuất hiện
        WebElement Dkyhocbtn = wait.until(driver -> driver.findElement(AladaLocator.Dkyhoc_btn));
        Dkyhocbtn.click();
        //Cho dieu huong sang trang Dang nhap
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://alada.vn/tai-khoan/dang-nhap.html"));
        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://alada.vn/tai-khoan/dang-nhap.html","Khong dieu huong den trang dang nhap");
    }
    @Test(priority = 4)
    public void CNTT_Hover() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        WebElement CNTT = findVisibleElement(AladaLocator.CNTT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CNTT);
        CNTT.click();
        Thread.sleep(2000);

        //Lay DS khoa hoc con thuoc khoa hoc CNTT
        List<WebElement> listCNTT = driver.findElements(AladaLocator.CNTT_con);
        //Ktra xem co khoa hoc nao ko
        Assert.assertFalse(listCNTT.isEmpty(), "Khong thay khoa hoc CNTT nao");
        //Lay random 1 khóa học
        Random rand = new Random();
        int index = rand.nextInt(listCNTT.size());
        WebElement CNTT_random = listCNTT.get(index);
        //Scroll toi khoa hoc random va click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CNTT_random);
        CNTT_random.click();

        //chờ trang chi tiết và nút đăng ký học xuất hiện
        WebElement Dkyhocbtn = wait.until(driver -> driver.findElement(AladaLocator.Dkyhoc_btn));
        Dkyhocbtn.click();

        //Cho dieu huong sang trang Dang nhap
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://alada.vn/tai-khoan/dang-nhap.html"));

        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://alada.vn/tai-khoan/dang-nhap.html","Khong dieu huong den trang dang nhap");
    }

    @Test(priority = 5)
    public void Kinhdoanh_Hover() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement Kinhdoanh = findVisibleElement(AladaLocator.Kinhdoanh);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",Kinhdoanh);
        Kinhdoanh.click();
        Thread.sleep(2000);

        //Lay DS khoa hoc con thuoc khoa hoc Kinhdoanh
        List<WebElement> listKinhdoanh = driver.findElements(AladaLocator.Kinhdoanh_con);

        //Ktra xem co khoa hoc nao ko
        Assert.assertFalse(listKinhdoanh.isEmpty(), "Khong thay khoa hoc Kinh doanh nao");

        //Lay random 1 khóa học
        Random rand = new Random();
        int index = rand.nextInt(listKinhdoanh.size());
        WebElement Kinhdoanh_random = listKinhdoanh.get(index);
        Thread.sleep(1000);
        //Scroll toi khoa hoc random va click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Kinhdoanh_random);
        Kinhdoanh_random.click();

        //chờ trang chi tiết và nút đăng ký học xuất hiện
        WebElement Dkyhocbtn = wait.until(driver -> driver.findElement(AladaLocator.Dkyhoc_btn));
        Dkyhocbtn.click();

        //Cho dieu huong sang trang Dang nhap
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://alada.vn/tai-khoan/dang-nhap.html"));

        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://alada.vn/tai-khoan/dang-nhap.html","Khong dieu huong den trang dang nhap");
    }
    @Test(priority = 6)
    public void Chamsoc_Hover() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement Chamsoc = findVisibleElement(AladaLocator.Chamsoc);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",Chamsoc);
        Chamsoc.click();
        Thread.sleep(2000);

        //Lay DS khoa hoc con thuoc khoa hoc Kinhdoanh
        List<WebElement> listChamsoc = driver.findElements(AladaLocator.Chamsoc_con);

        //Ktra xem co khoa hoc nao ko
        Assert.assertFalse(listChamsoc.isEmpty(), "Khong thay khoa hoc ky nang mem nao");

        //Lay random 1 khóa học
        Random rand = new Random();
        int index = rand.nextInt(listChamsoc.size());
        WebElement Chamsoc_random = listChamsoc.get(index);
        Thread.sleep(1000);
        //Scroll toi khoa hoc random va click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Chamsoc_random);
        Chamsoc_random.click();

        //chờ trang chi tiết và nút đăng ký học xuất hiện
        WebElement Dkyhocbtn = wait.until(driver -> driver.findElement(AladaLocator.Dkyhoc_btn));
        Dkyhocbtn.click();

        //Cho dieu huong sang trang Dang nhap
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://alada.vn/tai-khoan/dang-nhap.html"));

        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://alada.vn/tai-khoan/dang-nhap.html","Khong dieu huong den trang dang nhap");
    }
    @Test(priority = 7)
    public void BiQuyet_Hover() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement BiQuyet = findVisibleElement(AladaLocator.BiQuyet);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",BiQuyet);
        BiQuyet.click();
        Thread.sleep(2000);

        //Lay DS khoa hoc con thuoc khoa hoc Kinhdoanh
        List<WebElement> listBiQuyet = driver.findElements(AladaLocator.BiQuyet_con);

        //Ktra xem co khoa hoc nao ko
        Assert.assertFalse(listBiQuyet .isEmpty(), "Khong thay khoa hoc bi quyet nao");

        //Lay random 1 khóa học
        Random rand = new Random();
        int index = rand.nextInt(listBiQuyet.size());
        WebElement BiQuyet_random = listBiQuyet.get(index);
        Thread.sleep(1000);
        //Scroll toi khoa hoc random va click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BiQuyet_random);
        BiQuyet_random.click();

        //chờ trang chi tiết và nút đăng ký học xuất hiện
        WebElement Dkyhocbtn = wait.until(driver -> driver.findElement(AladaLocator.Dkyhoc_btn));
        Dkyhocbtn.click();

        //Cho dieu huong sang trang Dang nhap
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://alada.vn/tai-khoan/dang-nhap.html"));

        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://alada.vn/tai-khoan/dang-nhap.html","Khong dieu huong den trang dang nhap");
    }

    @Test(priority = 8)
    public void Mar_Hover() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        WebElement Mar = findVisibleElement(AladaLocator.Mar);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",Mar);
        Mar.click();
        Thread.sleep(2000);

        //Lay DS khoa hoc con thuoc khoa hoc CNTT
        List<WebElement> listMar = driver.findElements(AladaLocator.Mar_con);
        //Ktra xem co khoa hoc nao ko
        Assert.assertFalse(listMar.isEmpty(), "Khong thay khoa hoc Mar nao");
        //Lay random 1 khóa học
        Random rand = new Random();
        int index = rand.nextInt(listMar.size());
        WebElement Mar_random = listMar.get(index);
        //Scroll toi khoa hoc random va click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Mar_random);
        Mar_random.click();

        //chờ trang chi tiết và nút đăng ký học xuất hiện
        WebElement Dkyhocbtn = wait.until(driver -> driver.findElement(AladaLocator.Dkyhoc_btn));
        Dkyhocbtn.click();

        //Cho dieu huong sang trang Dang nhap
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://alada.vn/tai-khoan/dang-nhap.html"));

        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://alada.vn/tai-khoan/dang-nhap.html","Khong dieu huong den trang dang nhap");
    }
    @Test(priority = 9)
    public void Kynangmem_Hover() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement Kynangmem = findVisibleElement(AladaLocator.KyNangmem);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",Kynangmem);
        Kynangmem.click();
        Thread.sleep(2000);

        //Lay DS khoa hoc con thuoc khoa hoc Kinhdoanh
        List<WebElement> listKynangmem = driver.findElements(AladaLocator.KyNangmem_con);

        //Ktra xem co khoa hoc nao ko
        Assert.assertFalse(listKynangmem.isEmpty(), "Khong thay khoa hoc ky nang mem nao");

        //Lay random 1 khóa học
        Random rand = new Random();
        int index = rand.nextInt(listKynangmem.size());
        WebElement Kynangmem_random = listKynangmem.get(index);
        Thread.sleep(1000);
        //Scroll toi khoa hoc random va click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Kynangmem_random);
        Kynangmem_random.click();

        //chờ trang chi tiết và nút đăng ký học xuất hiện
        WebElement Dkyhocbtn = wait.until(driver -> driver.findElement(AladaLocator.Dkyhoc_btn));
        Dkyhocbtn.click();

        //Cho dieu huong sang trang Dang nhap
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://alada.vn/tai-khoan/dang-nhap.html"));

        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://alada.vn/tai-khoan/dang-nhap.html","Khong dieu huong den trang dang nhap");
    }

    @Test(priority = 10)
    public void TiengAnh_Hover() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement TiengAnh = findVisibleElement(AladaLocator.TiengAnh);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",TiengAnh);
        TiengAnh.click();
        Thread.sleep(2000);

        //Lay DS khoa hoc con thuoc khoa hoc Kinhdoanh
        List<WebElement> listTiengAnh = driver.findElements(AladaLocator.TiengAnh_con);

        //Ktra xem co khoa hoc nao ko
        Assert.assertFalse(listTiengAnh .isEmpty(), "Khong thay khoa hoc Eng nao");

        //Lay random 1 khóa học
        Random rand = new Random();
        int index = rand.nextInt(listTiengAnh.size());
        WebElement TiengAnh_random = listTiengAnh.get(index);
        Thread.sleep(1000);
        //Scroll toi khoa hoc random va click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", TiengAnh_random);
        TiengAnh_random.click();

        //chờ trang chi tiết và nút đăng ký học xuất hiện
        WebElement Dkyhocbtn = wait.until(driver -> driver.findElement(AladaLocator.Dkyhoc_btn));
        Dkyhocbtn.click();

        //Cho dieu huong sang trang Dang nhap
        wait.until(driver -> Objects.requireNonNull(driver.getCurrentUrl()).contains("https://alada.vn/tai-khoan/dang-nhap.html"));

        //Lay URL hien tai va assert
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://alada.vn/tai-khoan/dang-nhap.html","Khong dieu huong den trang dang nhap");

}
}

