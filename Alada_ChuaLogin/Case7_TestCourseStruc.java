package Alada_ChuaLogin;
import common.commonbase;
import org.testng.Assert;
import pageLocator.AladaLocator;
import constant.URL;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Case7_TestCourseStruc extends commonbase {
    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        initChromeBrowser(URL.Alada_Trangchu);
        Thread.sleep(5000);
    }
    @Test
    public void TestCourseStruc() {
        Assert.assertFalse(driver.findElements(AladaLocator.ImgCourse).isEmpty(), "Thiếu ảnh khóa học");
        Assert.assertFalse(driver.findElements(AladaLocator.NameCourse).isEmpty(), "Thiếu tên khóa học");
        Assert.assertFalse(driver.findElements(AladaLocator.AvaGV_Course).isEmpty(), "Thiếu ava GV");
        Assert.assertFalse(driver.findElements(AladaLocator.TenGV_Course).isEmpty(), "Thiếu tên GV");
        Assert.assertFalse(driver.findElements(AladaLocator.TitleGV_Course).isEmpty(), "Thiếu title GV");
        Assert.assertFalse(driver.findElements(AladaLocator.Price_Course).isEmpty(), "Thiếu giá tiền khóa học");
        Assert.assertFalse(driver.findElements(AladaLocator.Sao_Course).isEmpty(), "Thiếu sao đánh giá khóa học");
    }

}
