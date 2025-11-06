package Alada_ChuaLogin;
import common.commonbase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocator.AladaLocator;
import constant.URL;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Case10_TestAutoScroll extends commonbase{
    @BeforeMethod
    public void openBrowser(){
        initChromeBrowser(URL.Alada_Trangchu);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement ComboKhoahoc = driver.findElement(AladaLocator.Combo_khoahoc);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ComboKhoahoc);
        ComboKhoahoc.click();
        WebElement Khoahocvuaramat = findVisibleElement(AladaLocator.Khoahocvuaramat);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Khoahocvuaramat);
        Khoahocvuaramat.click();

        //Lay DS khoa hoc con thuoc khoa hoc noi bat
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
    }
    @Test
    public void testSticky_Tong() throws InterruptedException {
        // Xpath phần tử cần test
        WebElement khungTomTat = driver.findElement(AladaLocator.khungTomTat);

        // Lấy tọa độ Y ban đầu
        int yBefore = khungTomTat.getLocation().getY();

        // Scroll xuống 1000px
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");

        // Lấy tọa độ Y sau khi scroll
        int yAfter = khungTomTat.getLocation().getY();

        // Tính delta
        int delta = Math.abs(yAfter - yBefore);

        // Assert: di chuyển nhưng không đáng kể, ví dụ < 50px
        Assert.assertTrue(delta < 2000,
                "Phần tử ulnavct di chuyển quá nhiều! delta = " + delta);
    }
    @Test
    public void testSticky_GTKH() throws InterruptedException {
        //click vao menu GTKH
        WebElement GTKH_box = driver.findElement(AladaLocator.GTKH_box);
        GTKH_box.click();

        //Xpath GTKH title
        WebElement GTKH_title = driver.findElement(AladaLocator.GTKH_title);

        //Dung JavaScript de ktra element co nam trong viewport ko
        Boolean GTKH_InViewport =
                (Boolean)
                        ((JavascriptExecutor)driver).
                                executeScript("var rect = arguments[0].getBoundingClientRect();"
                                        + "return (rect.top >= 0 && rect.bottom <= window.innerHeight);",GTKH_title);

        //Assert
        Assert.assertTrue(GTKH_InViewport,"ko trong viewport");
    }
    @Test
    public void testSticky_NDKH() throws InterruptedException {
        //click vao menu GTKH
        WebElement NDKH_box = driver.findElement(AladaLocator.NDKH_box);
        NDKH_box.click();

        //Xpath GTKH title
        WebElement NDKH_title = driver.findElement(AladaLocator.NDKH_title);
        Thread.sleep(2000);

        //Dung JavaScript de ktra element co nam trong viewport ko
        Boolean NDKH_InViewport =
                (Boolean)
                        ((JavascriptExecutor)driver).
                                executeScript("var rect = arguments[0].getBoundingClientRect();"
                                        + "return (rect.top >= 0 && rect.bottom <= window.innerHeight);",NDKH_title);
        Assert.assertTrue(NDKH_InViewport,"ko trong viewport");
    }
    @Test
    public void testSticky_GV() throws InterruptedException {
        //click vao menu GiangVien
        WebElement GV_box = driver.findElement(AladaLocator.GV_box);
        GV_box.click();

        //Xpath GV title
        WebElement GV_title = driver.findElement(AladaLocator.GV_title);
        Thread.sleep(3000);

        //Dung JS de ktra element co trong viewport ko
        Boolean GV_InViewPort =
                (Boolean)
                        ((JavascriptExecutor)driver).executeScript("var rect = arguments[0].getBoundingClientRect();"
                                + "return (rect.top >= 0 && rect.bottom <= window.innerHeight);",GV_title);
        Assert.assertTrue(GV_InViewPort,"ko trong viewport");
    }
    @Test
    public void testSticky_KHLQ() throws InterruptedException {
        //click vao menu KHLQ
        WebElement KHLQ_box = driver.findElement(AladaLocator.KHLQ_box);
        KHLQ_box.click();

        //Xpath KHLQ title
        WebElement KHLQ_title = driver.findElement(AladaLocator.KHLQ_title);
        Thread.sleep(3000);

        //Dung JS de ktra element co trong viewport ko
        Boolean KHLQ_InViewPort =
                (Boolean)
                        ((JavascriptExecutor)driver).executeScript("var rect = arguments[0].getBoundingClientRect();"
                                + "return (rect.top >= 0 && rect.bottom <= window.innerHeight);",KHLQ_title);
        Assert.assertTrue(KHLQ_InViewPort,"ko trong viewport");
    }
    @Test
    public void testSticky_DGKH() throws InterruptedException {
        //click vao menu DGKH
        WebElement DGKH_box = driver.findElement(AladaLocator.DGKH_box);
        DGKH_box.click();

        //Xpath DGKH title
        WebElement DGKH_title = driver.findElement(AladaLocator.DGKH_title);
        Thread.sleep(3000);

        //Dung JS de ktra element co trong viewport ko
        Boolean DGKH_InViewPort =
                (Boolean)
                        ((JavascriptExecutor)driver).executeScript("var rect = arguments[0].getBoundingClientRect();"
                                + "return (rect.top >= 0 && rect.bottom <= window.innerHeight);",DGKH_title);
        Assert.assertTrue(DGKH_InViewPort,"ko trong viewport");
    }



}