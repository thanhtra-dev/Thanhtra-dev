package Alada_ChuaLogin;
import common.commonbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageLocator.AladaLocator;
import constant.URL;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class Case11_TestVidCountNDuration extends commonbase {
    @BeforeMethod
    public void openBrowser() throws InterruptedException{
        initChromeBrowser(URL.Alada_Trangchu);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement Khoahocrandom = driver.findElement(AladaLocator.KhoahocRandom);
        Khoahocrandom.click();
    }
    @Test
    public void TestVidCount() throws InterruptedException{
        //Lay SL vid
        String videoText = driver.findElement(AladaLocator.TongVideo).getText();
        //Lọc hết tất cả chữ cái đi
        int expectedVidCount = Integer.parseInt(videoText.replaceAll("\\D+",""));
        //Lay DS cac video ben duoi
        List<WebElement> videoList = driver.findElements(AladaLocator.VideoList);
        //So sanh
        Assert.assertEquals(videoList.size(),expectedVidCount, "SL vid ko khop");
    }
    @Test
    public void TestDuration() throws InterruptedException{
        //Lay so h hien thi ở trên cùng
        String durationText = driver.findElement(AladaLocator.TongTime).getText();
        int expectedHours = Integer.parseInt(durationText.replaceAll("\\D+",""));

        //Lay DS tat ca thoi gian cua video
        List<WebElement> timeElements = driver.findElements(AladaLocator.TimePerVid);

        //Cong tong thoi gian
        int totalSeconds = 0;
        for(WebElement el: timeElements){
            String time = el.getText();
            String[] parts = time.split(":");
            int h = 0, m = 0, s = 0;
            if (parts.length ==3) {
                h = Integer.parseInt(parts[0]);
                m = Integer.parseInt(parts[1]);
                s = Integer.parseInt(parts[2]);
            }
            //cong don roi gan
            totalSeconds += h*3600 + m*60 + s;
        }
        //Quy doi sang h( chi lay phan nguyen)
        int actualHours = totalSeconds/3600;

        //Assert so sánh
        Assert.assertEquals(actualHours,expectedHours,"Thoi luong ko khop");

    }
}
