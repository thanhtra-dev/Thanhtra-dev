package Testsuite;
import automation.common.commonbase;
import automation.pageLocator.BepAnToanLocator;
import constant.CT_PageURL;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import static org.testng.AssertJUnit.assertEquals;
public class BepAnToan_BrandFilter extends commonbase {

    @BeforeMethod
    public void openBrowser() {
        initDriverWithZoom();  // khởi tạo driver với zoom 80%
    }

    @Test
    public void verifyAllProductsAreBosch(){
        driver.get(CT_PageURL.BEPANTOAN_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
        // Click vào menu "Bếp từ"
        click(BepAnToanLocator.MENU_BEP_TU);
        // CHỜ và SCROLL đến filter Bosch
        WebElement filterBosch = wait.until(ExpectedConditions.visibilityOfElementLocated(BepAnToanLocator.FILTER_BOSCH));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);window.scrollBy(0, -400);", filterBosch);
        // Click vào filter "Bosch"
        filterBosch.click();
        // Lấy tất cả các ảnh cua "Bosch"
        List<WebElement> allProductImages = driver.findElements(BepAnToanLocator.RESULT_IMAGE_BOSCH);
        // Kiểm tra tất cả ảnh đều là Bosch
        for (WebElement img : allProductImages) {
            String altText = img.getAttribute("alt");
            assertEquals("Phát hiện ảnh không phải của Bosch", "Bosch", altText);
        }
    }

}
