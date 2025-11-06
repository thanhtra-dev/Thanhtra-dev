package SauceDemo;
import common.commonbase;
import constant.URL;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageLocator.SaucedemoLocator;
import java.util.List;

public class Case3_AddToCart extends commonbase {
    @BeforeMethod
    public void setup() throws InterruptedException {
        initChromeBrowser(URL.Saucedemo_URL);
        Case0_LoginPass loginPass = new Case0_LoginPass();
        loginPass.login("standard_user", "secret_sauce");
    }
    @Test
    public void ChangeAddToCartToRemove() throws InterruptedException {
        List<WebElement> addToCartbtns = driver.findElements(SaucedemoLocator.AddToCart_btn);
        for (WebElement addBtn : addToCartbtns) {
            addBtn.click();
        }
        WebElement removeBtn = driver.findElement(SaucedemoLocator.Remove1);
        Assert.assertTrue(removeBtn.isDisplayed(),"Khong thay remove dau");
    }
    @Test
    public void MatchCartCount() throws InterruptedException {
        List<WebElement> AddToCart_btns = driver.findElements(SaucedemoLocator.AddToCart_btn);
        //gia su chon 3 sp dau tien
        int itemsAdded = 6;
        for(int i=0; i<itemsAdded;i++) {
            AddToCart_btns.get(i).click();
        }
        //Ktra so trong gio hang
        WebElement CartNumber = driver.findElement(SaucedemoLocator.cartBadge);
        String actualCount = CartNumber.getText();
        Assert.assertEquals(actualCount,String.valueOf(itemsAdded),"Sl gio hang ko dung");
    }
    @Test
    public void RemoveCartCount() throws InterruptedException {
        // 1️⃣ Thêm 6 sản phẩm vào giỏ
        List<WebElement> addToCartBtns = driver.findElements(SaucedemoLocator.AddToCart_btn);
        int itemsAdded = 6;
        for (int i = 0; i < itemsAdded; i++) {
            addToCartBtns.get(i).click();
        }

        // 2️⃣ Kiểm tra số lượng hiển thị trên giỏ hàng
        WebElement cartNumber = driver.findElement(SaucedemoLocator.cartBadge);
        String actualCount = cartNumber.getText();
        Assert.assertEquals(actualCount, String.valueOf(itemsAdded), "Số lượng giỏ hàng không đúng sau khi thêm");

        // 3️⃣ Vào trang giỏ hàng
        driver.findElement(SaucedemoLocator.ShoppingCart).click();

        // 4️⃣ Lấy danh sách các nút Remove
        List<WebElement> removeBtns = driver.findElements(SaucedemoLocator.Remove1);

        // 5️⃣ Lặp qua từng sản phẩm để remove
        for (int i = 0; i < removeBtns.size(); i++) {
            // Lấy lại danh sách mỗi lần để tránh StaleElementException
            removeBtns = driver.findElements(SaucedemoLocator.Remove1);
            WebElement removeBtn = removeBtns.get(0); // luôn lấy phần tử đầu tiên còn lại
            // ✅ Nhấn nút Remove
            removeBtn.click();
            // ✅ Check 2: nếu còn sản phẩm, kiểm tra số lượng giỏ hàng giảm đi
            List<WebElement> cartBadgeList = driver.findElements(SaucedemoLocator.cartBadge);
            if (cartBadgeList.size() > 0) {
                int currentCount = Integer.parseInt(cartBadgeList.get(0).getText());
                System.out.println("Cart count after remove: " + currentCount);
                Assert.assertEquals(currentCount, itemsAdded - (i + 1), "Số lượng giỏ hàng không giảm đúng");
            } else {
                System.out.println("Tất cả sản phẩm đã bị xóa – không còn badge hiển thị.");
            }
        }
    }
}





