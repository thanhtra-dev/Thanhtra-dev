package Testsuite;

import automation.common.commonbase;
import automation.pageLocator.HomePageLocator;
import automation.common.commonbase;
import constant.CT_PageURL;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class BTVNDAY18_Bepantoan extends commonbase {
    @BeforeMethod
    @Parameters("browser")
    public void openBrowser(String browser) {
        driver = setupBrowser(browser);
        driver.get(CT_PageURL.BEPANTOAN_URL);
    }
    @Test
    public void Check_Zalo_Bepantoan() {
        scrollToElement(HomePageLocator.ICON_ZALO_BEPANTOAN);
        assertTrue(isElementPresent(HomePageLocator.ICON_ZALO_BEPANTOAN));
        click(HomePageLocator.ICON_ZALO_BEPANTOAN);
        String mainTab = driver.getWindowHandle();
        switchToNewTab(mainTab);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlContains(CT_PageURL.BEPANTOAN_URL));

        String actualURL = driver.getCurrentUrl();
        assertTrue(actualURL.contains(CT_PageURL.EXPECTED_ZALO_URL_BEPTANTOAN));
    }
    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
