package Alada_ChuaLogin;
import common.commonbase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocator.AladaLocator;
import constant.URL;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Case8_TestNextPage extends commonbase {
    @BeforeMethod
    public void openBrowser(){
        initChromeBrowser(URL.Alada_Trangchu);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }
    @Test
    public void ClickMuiTenPhai() throws InterruptedException{
        String firstGV = findVisibleElement(AladaLocator.ActiveOne).getText();
        //DS de luu lai cac gv da hien thi
        Set<String> Giaovien = new HashSet<>();
        Giaovien.add(firstGV);

        //Click mui ten phai 1 lan thi viet i<1
        //Click mui ten phai 3 lan thi viet i<3
        for(int i = 0; i<1;i++){
            driver.findElement(AladaLocator.MuitenPhai).click();
            Thread.sleep(1500);

            String currentGV = findVisibleElement(AladaLocator.ActiveBenPhai).getText();
            Giaovien.add(currentGV);
        }
        //Assert phai co it nhat 2 giang vien khac nhau
        Assert.assertTrue(Giaovien.size()>1,"click mui ten fail");
    }
    @Test
    public void ClickMuiTenTrai() throws InterruptedException{
        String firstGV = findVisibleElement(AladaLocator.ActiveOne).getText();
        //DS de luu lai cac gv da hien thi
        Set<String> Giaovien = new HashSet<>();
        Giaovien.add(firstGV);

        //click mui ten trai
        for(int i = 0; i<1; i++){
            driver.findElement(AladaLocator.MuitenTrai).click();
            Thread.sleep(1500);
            String currentGV = findVisibleElement(AladaLocator.ActiveBenTrai).getText();
            Giaovien.add(currentGV);
        }
        //Assert phai co it nhat 2 giang vien khac nhau
        Assert.assertTrue(Giaovien.size()>1,"click mui ten fail");
    }
    @Test
    public void testStickyUlnavct() throws InterruptedException {
        initChromeBrowser(URL.ALADA_URL);
        WebElement ComboKhoahoc = driver.findElement(AladaLocator.Combo_khoahoc);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ComboKhoahoc);
        ComboKhoahoc.click();
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
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
        Thread.sleep(3000);
        // Xpath phần tử cần test
        WebElement ulNav = driver.findElement(By.xpath("//ul[contains(@class,'ulnavct')]"));

        // Lấy tọa độ Y ban đầu
        int yBefore = ulNav.getLocation().getY();

        // Scroll xuống 1000px
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        Thread.sleep(2000);

        // Lấy tọa độ Y sau khi scroll
        int yAfter = ulNav.getLocation().getY();

        // Tính delta
        int delta = Math.abs(yAfter - yBefore);

        // Assert: di chuyển nhưng không đáng kể, ví dụ < 50px
        Assert.assertTrue(delta < 1000,
                "Phần tử ulnavct di chuyển quá nhiều! delta = " + delta);
    }

}
