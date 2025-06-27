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
public class BepAnToan_SoBepFilter extends commonbase {
    @BeforeMethod
    public void openBrowser() {
        initDriverWithZoom();  // khởi tạo driver với zoom 80%
    }
    @Test
    public void BepAnToan_SoBepFilter() throws InterruptedException {
        driver.get(CT_PageURL.BEPANTOAN_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Click vào menu "Bếp từ"
        click(BepAnToanLocator.MENU_BEP_TU);

        // Chờ và scroll đến filter số bếp
        WebElement filterSoBep = wait.until(ExpectedConditions.elementToBeClickable(BepAnToanLocator.FILTER_SOBEP));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", filterSoBep);
        Thread.sleep(2000); // cho chắc chắn đã hiển thị

        // Click bằng JavaScript để tránh bị che
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", filterSoBep);

        // Chờ sản phẩm load
        Thread.sleep(2000);

        // Lấy tất cả tiêu đề sản phẩm
        List<WebElement> soBepTitles = driver.findElements(BepAnToanLocator.RESULT_SOBEP);
        boolean foundMatchingProduct = false;
        for (WebElement titleEl : soBepTitles) {
            String titleText = titleEl.getText().toLowerCase();

            if (titleText.contains("3 vùng nấu") || titleText.contains("3 bếp") || titleText.contains("ba bếp")) {
                System.out.println("Tìm thấy sản phẩm phù hợp: " + titleEl.getText());
                foundMatchingProduct = true;
                break; // Không cần kiểm tra tiếp nữa
            }
        }
        Assert.assertTrue(foundMatchingProduct, "Không tìm thấy sản phẩm phù hợp với bộ lọc 3 bếp.");
        System.out.println("Đã tìm thấy ít nhất 1 sản phẩm phù hợp với bộ lọc 3 bếp");
    }
}
