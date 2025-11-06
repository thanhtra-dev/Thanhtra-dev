package Alada_ChuaLogin;
import common.commonbase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageLocator.AladaLocator;
import constant.URL;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;


public class Case3_TestHoptacGiangday extends commonbase {
    @BeforeMethod
    public void openBrowser() {
        initChromeBrowser(URL.ALADA_URL);
        WebElement HTGD = findVisibleElement(AladaLocator.HTGD_button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", HTGD);
        HTGD.click();
    }
    @Test (priority = 1)
    public void HTGD_Giangvien() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        WebElement GV_Tendangnhap = driver.findElement(AladaLocator.GV_TenDangNhap);
        GV_Tendangnhap.sendKeys("LongHoang");

        WebElement GV_Email = driver.findElement(AladaLocator.GV_Email);
        GV_Email.sendKeys("nongnongiu1999@gmail.com");


        WebElement GV_MatKhau = driver.findElement(AladaLocator.GV_MatKhau);
        GV_MatKhau.sendKeys("Tangbang");


        WebElement GV_NhapLaiMatKhau = driver.findElement(AladaLocator.GV_NhapLaiMatKhau);
        GV_NhapLaiMatKhau.sendKeys("Tangbang");


        WebElement GV_Hovaten = driver.findElement(AladaLocator.GV_Hovaten);
        GV_Hovaten.sendKeys("Long Hoang");


        WebElement GV_Ngaysinh = driver.findElement(AladaLocator.GV_Ngaysinh);
        Select chonNgay = new Select(GV_Ngaysinh);
        chonNgay.selectByValue("25");

        WebElement GV_Thangsinh = driver.findElement(AladaLocator.GV_Thangsinh);
        Select chonThang = new Select(GV_Thangsinh);
        chonThang.selectByValue("10");

        WebElement GV_Namsinh = driver.findElement(AladaLocator.GV_Namsinh);
        Select chonNam = new Select(GV_Namsinh);
        chonNam.selectByValue("1999");
        Thread.sleep(1000);

        WebElement GV_GioiTinh = driver.findElement(AladaLocator.GV_GioiTinh);
        Select chonGioiTinh = new Select(GV_GioiTinh);
        chonGioiTinh.selectByIndex(1);
        Thread.sleep(1000);

        WebElement GV_TP = driver.findElement(AladaLocator.GV_TP);
        Select chonTP = new Select(GV_TP);
        chonTP.selectByIndex(4);
        Thread.sleep(1000);

        WebElement GV_DiaChi = driver.findElement(AladaLocator.GV_DiaChi);
        GV_DiaChi.sendKeys("Hà Nội");
        Thread.sleep(1000);

        WebElement GV_DienThoai = driver.findElement(AladaLocator.GV_DienThoai);
        GV_DienThoai.sendKeys("09733267");
        Thread.sleep(1000);

        WebElement GV_ChucDanh = driver.findElement(AladaLocator.GV_ChucDanh);
        GV_ChucDanh.sendKeys("Dev FE");
        Thread.sleep(1000);

        WebElement GV_Dangkybtn = findVisibleElement(AladaLocator.GV_DangKy);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", GV_Dangkybtn);
        GV_Dangkybtn.click();
        Thread.sleep(5000);

        WebElement Danhmuckhoahoc = driver.findElement(AladaLocator.Danhmuckhoahoc);
        Assert.assertTrue(Danhmuckhoahoc.isDisplayed(), "Không tìm thấy danh mục khóa học");
    }
    @Test(priority = 2)
    public void HTGD_TCGD() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement TCGD_btn = driver.findElement(AladaLocator.TCGD_btn);
        TCGD_btn.click();
        Thread.sleep(1000);

        WebElement TCGD_Tendangnhap = driver.findElement(AladaLocator.TCGD_TenDangNhap);
        TCGD_Tendangnhap.sendKeys("Digital");
        Thread.sleep(1000);

        WebElement TCGD_Email = driver.findElement(AladaLocator.TCGD_Email);
        TCGD_Email.sendKeys("chunghoangtran@gmail.com");
        Thread.sleep(1000);

        WebElement TCGD_MatKhau = driver.findElement(AladaLocator.TCGD_MatKhau);
        TCGD_MatKhau.sendKeys("GDK123#");
        Thread.sleep(1000);

        WebElement TCGD_NhapLaiMatKhau = driver.findElement(AladaLocator.TCGD_NhapLaiMatKhau);
        TCGD_NhapLaiMatKhau.sendKeys("GDK123#");
        Thread.sleep(1000);

        WebElement TCGD_Tentochuc = driver.findElement(AladaLocator.TCGD_Tentochuc);
        TCGD_Tentochuc.sendKeys("DauApp");
        Thread.sleep(1000);

        WebElement TCGD_NguoiLH = driver.findElement(AladaLocator.TCGD_NguoiLH);
        TCGD_NguoiLH.sendKeys("Mr Chung Tran");
        Thread.sleep(1000);

        WebElement TCGD_EmailNguoiLH = driver.findElement(AladaLocator.TCGD_EmailNguoiLH);
        TCGD_EmailNguoiLH.sendKeys("chungtran@msb.com.vn");
        Thread.sleep(1000);

        WebElement TCGD_GioiTinh = driver.findElement(AladaLocator.TCGD_Gioitinh);
        Select chonGioiTinh2 = new Select(TCGD_GioiTinh);
        chonGioiTinh2.selectByIndex(1);
        Thread.sleep(1000);

        WebElement TCGD_DienThoai = driver.findElement(AladaLocator.TCGD_DienThoai);
        TCGD_DienThoai.sendKeys("0973326749");
        Thread.sleep(1000);

        WebElement TCGD_TP = driver.findElement(AladaLocator.TCGD_City);
        Select chonTP2 = new Select(TCGD_TP);
        chonTP2.selectByIndex(4);
        Thread.sleep(1000);

        WebElement TCGD_DiaChi = driver.findElement(AladaLocator.TCGD_DiaChi);
        TCGD_DiaChi.sendKeys("Mo Lao, Ha Dong");
        Thread.sleep(1000);

        WebElement TCGD_GTVTC = driver.findElement(AladaLocator.TCGD_GTVTC);
        TCGD_GTVTC.sendKeys("Bầu trời này là anh Chung Trần");
        Thread.sleep(1000);


        WebElement TCGD_Dangkybtn = findVisibleElement(AladaLocator.TCGD_Dky);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", TCGD_Dangkybtn);
        TCGD_Dangkybtn.click();
        Thread.sleep(2000);

        WebElement Danhmuckhoahoc = driver.findElement(AladaLocator.Danhmuckhoahoc);
        Assert.assertTrue(Danhmuckhoahoc.isDisplayed(), "Không tìm thấy danh mục khóa học");

    }

}

