package automation.pageLocator;

import org.openqa.selenium.By;

public class BepAnToanLocator {
    public static final By MENU_BEP_TU = By.xpath("//a[contains(@class,'menu-link') and normalize-space(text())='Bếp Từ']");
    public static final By FILTER_BOSCH = By.xpath("//img[@class='object-contain w-auto h-full' and contains(@src, 'bosch')]");
    public static final By RESULT_IMAGE_BOSCH = By.xpath("//img[@alt='Bosch']");
    public static final By FILTER_PRICE = By.xpath("//span[normalize-space(text())='> 15.000.000']");
    public static final By RESULT_IMAGE_PRICE = By.xpath("//span[contains(@class, 'sale-price')]");
    public static final By FILTER_SOBEP = By.xpath("//input[@name='3-bep-1008']");
    public static final By RESULT_SOBEP = By.xpath("//h4[contains(@class,'title-card')]");
    public static final By FILTER_PHANLOAI = By.xpath("//input[@id='bep-dien-tu-1011']");
    public static final By GiamgiaNhieu = By.xpath("//a[normalize-space(text())='Giảm giá nhiều']");
    public static final By GiaThap = By.xpath("//a[normalize-space(text())='Giá thấp']");
    public static final By GiaCao = By.xpath("//a[normalize-space(text())='Giá cao']");
    public static final By DiscountElements = By.xpath("//div[contains(@class, 'bg-maroon-500') and contains(text(), '%')]");
}
