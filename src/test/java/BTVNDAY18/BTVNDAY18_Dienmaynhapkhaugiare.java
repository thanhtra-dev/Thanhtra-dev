package Testsuite;

import automation.common.commonbase;
import automation.pageLocator.HomePageLocator;
import constant.CT_PageURL;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class BTVNDAY18_Dienmaynhapkhaugiare extends commonbase {
    @BeforeMethod
    @Parameters("browser")
    public void openBrowser(String browser) {
        driver = setupBrowser(browser);
        driver.get(CT_PageURL.DIENMAYNHAPKHAUGIARE_URL);
    }
    @Test
    public void Check_Zalome_DienmayNK(){
        scrollToElement(HomePageLocator.ICON_ZALO);
        assertTrue(isElementPresent(HomePageLocator.ICON_ZALO));
        click(HomePageLocator.ICON_ZALO);

        String mainTab = driver.getWindowHandle();
        switchToNewTab(mainTab);

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(CT_PageURL.EXPECTED_ZALO_URL));
        String actualUrl = driver.getCurrentUrl();
        assertTrue(CT_PageURL.EXPECTED_ZALO_URL != null && actualUrl.contains(CT_PageURL.EXPECTED_ZALO_URL));
    }
    @AfterMethod
    public void closeBrowser(){
        if (driver != null) {
            driver.quit();
        }
    }
}
