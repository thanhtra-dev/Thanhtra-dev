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

public class BepAnToan_PriceFilter extends commonbase{
    @BeforeMethod
    public void openBrowser() {
        initDriverWithZoom();  // khởi tạo driver với zoom 80%
    }
    @Test
    public void verifyPriceAbove15M() throws InterruptedException {
        driver.get(CT_PageURL.BEPANTOAN_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Click vào menu Bếp từ
        click(BepAnToanLocator.MENU_BEP_TU);

        // Chờ filter giá hiển thị và có thể click
        WebElement filterPrice = wait.until(ExpectedConditions.elementToBeClickable(BepAnToanLocator.FILTER_PRICE));
        Thread.sleep(5000);

        // Click vào filter
        filterPrice.click();
        Thread.sleep(9000);

        // Kiểm tra danh sách giá
        List<WebElement> priceElements = driver.findElements(BepAnToanLocator.RESULT_IMAGE_PRICE);

        boolean foundProductAbove15M = false;
        for (WebElement priceEl : priceElements) {
            String priceText = priceEl.getText(); // Ví dụ: "16.500.000 ₫"

            // Loại bỏ dấu chấm, khoảng trắng, ký hiệu tiền
            String cleanedPrice = priceText.replace(".", "").replace("₫", "").replace(" ", "").trim();

            try {
                int price = Integer.parseInt(cleanedPrice);
                if (price > 15000000) {
                    System.out.println("Có sản phẩm không đạt yêu cầu: " + priceText);
                    foundProductAbove15M = true;
                }
            } catch (Exception e) {
                System.out.println("Không thể chuyển đổi"+ priceText);
            }
        }
        Assert.assertTrue(foundProductAbove15M,"Không có sản phẩm nào trên 15M");
    }
}
