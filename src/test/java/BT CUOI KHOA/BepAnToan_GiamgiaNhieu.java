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

public class BepAnToan_GiamgiaNhieu extends commonbase{
    @BeforeMethod
    public void openBrowser() {
        initDriverWithZoom();  // khởi tạo driver với zoom 80%
    }
    @Test
    public void KtraGiamgiaNhieu() throws InterruptedException {
        driver.get(CT_PageURL.BEPANTOAN_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Click vào menu Bếp từ
        click(BepAnToanLocator.MENU_BEP_TU);

        // Chờ giamgiaNhieu hiển thị và có thể click
        WebElement GiamgiaNhieu = wait.until(ExpectedConditions.elementToBeClickable(BepAnToanLocator.GiamgiaNhieu));
        Thread.sleep(5000);

        // Click bằng JavaScript để tránh bị che
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", GiamgiaNhieu);

        // Chờ sản phẩm load
        Thread.sleep(2000);

        //Ktra phan tu giam gia
        List<WebElement> DiscountElements = driver.findElements(BepAnToanLocator.DiscountElements);

        boolean foundHighDiscount = false;
        for (WebElement DiscountElement : DiscountElements) {
            String Discount = DiscountElement.getText();
            //Loai bo dau tru va phan tram, roi ep kieu
            String cleanedDiscount = Discount.replaceAll("-","").replace("%","").trim();
            try{
                int Discount_number = Integer.parseInt(cleanedDiscount);

                if (Discount_number > 70){
                    System.out.println(Discount_number + "%");
                    foundHighDiscount = true;
                }
            }
            catch (NumberFormatException e){
                System.out.println("Không thể chuyển đổi thành số");
            }
        }
        //Assert fail neu ko tim thay sp giam >70%
        Assert.assertTrue(foundHighDiscount,"Không có sản phẩm nào giảm giá > 70%");
    }
}
