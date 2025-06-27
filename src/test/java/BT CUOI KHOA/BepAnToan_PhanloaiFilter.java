package Testsuite;
import automation.common.commonbase;
import automation.pageLocator.BepAnToanLocator;
import constant.CT_PageURL;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class BepAnToan_PhanloaiFilter extends commonbase {
    @BeforeMethod
    public void openBrowser() {
        initDriverWithZoom();  // khởi tạo driver với zoom 80%
    }
    @Test
    public void BepAnToan_Phanloai() throws InterruptedException  {
        driver.get(CT_PageURL.BEPANTOAN_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Click vào menu "Bếp từ"
        click(BepAnToanLocator.MENU_BEP_TU);

        // Chờ và scroll đến filter phan loai bep
        WebElement filterPhanloaiBep = wait.until(ExpectedConditions.elementToBeClickable(BepAnToanLocator.FILTER_PHANLOAI));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", filterPhanloaiBep);
        Thread.sleep(2000); // cho chắc chắn đã hiển thị

        // Click bằng JavaScript để tránh bị che
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", filterPhanloaiBep);

        // Chờ sản phẩm load
        Thread.sleep(2000);

        // Lấy tất cả tiêu đề sản phẩm
        List<WebElement> phanloaibep = driver.findElements(BepAnToanLocator.RESULT_SOBEP);
        boolean foundMatchingProduct = false;
        for (WebElement titleEl : phanloaibep) {
            String titleText = titleEl.getText();

            if (titleText.contains("Bếp điện từ")) {
                System.out.println("Tìm thấy sản phẩm phù hợp: " + titleEl.getText());
                foundMatchingProduct = true;
                break; // Không cần kiểm tra tiếp nữa
            }
        }
        Assert.assertTrue(foundMatchingProduct, "Không tìm thấy sản phẩm bếp điện từ");
        System.out.println("Đã tìm thấy ít nhất 1 sản phẩm bếp điện từ");
    }
}
