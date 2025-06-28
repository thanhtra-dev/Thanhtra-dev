package Testsuite;
import automation.common.commonbase;
import automation.pageLocator.BepAnToanLocator;
import constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;


public class BepAnToan_TimkiemBeptu extends commonbase {
    @BeforeMethod
    public void openBrowser(){
        initDriverWithZoom();
    }
    //Ham type nen dat ngoai ham test
    public void type(By locator, String text){
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    @Test
    public void TimkiemBeptu() throws InterruptedException {
        driver.get(CT_PageURL.BEPANTOAN_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Go tu khoa bep tu
        type(BepAnToanLocator.Vungnhap,"Bếp từ");

        //Doi KQ hien thi
        Thread.sleep(5000);

        //Lay danh sach san pham co chua chu Bep Tu
        List<WebElement> titles = driver.findElements(BepAnToanLocator.AnhBepTu);

        //Ktra co it nhat 1 KQ chua Beptu
        Assert.assertTrue(titles.size() > 0,"Không tìm thấy sản phẩm nào chứa 'BẾP TỪ'");

    }
}



