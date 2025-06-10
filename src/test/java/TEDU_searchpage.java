package automation.pageLocator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TEDU_searchpage {
    private WebDriver driver;
    @FindBy(xpath = "//input[@name='keyword']") WebElement Search;
    @FindBy(xpath = "//i[@class='fa fa-search']") WebElement click;
    public TEDU_searchpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void SearchFunction(String nhap) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1]", Search, nhap);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", click);
    }
}
