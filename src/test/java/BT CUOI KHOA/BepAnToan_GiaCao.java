package Testsuite;
import automation.common.commonbase;
import automation.pageLocator.BepAnToanLocator;
import constant.CT_PageURL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class BepAnToan_GiaCao extends commonbase {
    @BeforeMethod
    public void openBrowser() {
        initDriverWithZoom();  // khởi tạo driver với zoom 80%
    }

    @Test
    public void BepAnToan_GiaCao() throws InterruptedException {
        driver.get(CT_PageURL.BEPANTOAN_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Click vào menu Bếp từ
        click(BepAnToanLocator.MENU_BEP_TU);

        //cho gia cao hien thi de click
        WebElement GiaCao = wait.until(ExpectedConditions.elementToBeClickable(BepAnToanLocator.GiaCao));
        Thread.sleep(5000);

        GiaCao.click();
        Thread.sleep(9000);

        // Kiểm tra danh sách giá
        List<WebElement> priceElements = driver.findElements(BepAnToanLocator.RESULT_IMAGE_PRICE);

        boolean foundProductGiaCao = false;

        boolean foundProductGiaThap = false;

        for (WebElement priceEl : priceElements) {
            String priceText = priceEl.getText(); // Ví dụ: "16.500.000 ₫"

            // Loại bỏ dấu chấm, khoảng trắng, ký hiệu tiền
            String cleanedPrice = priceText.replace(".", "").replace("₫", "").replace(" ", "").trim();

            try {
                int price = Integer.parseInt(cleanedPrice);
                if (price > 70000000) {
                    System.out.println("Có sản phẩm giá cao: " + priceText);
                    foundProductGiaThap = true;
                }
            } catch (Exception e) {
                System.out.println("Không thể chuyển đổi"+ priceText);
            }
        }
        Assert.assertTrue(foundProductGiaThap,"Không có sản phẩm nào giá cao");
    }
}
