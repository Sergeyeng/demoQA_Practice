package demoqa.dynamicProperties;

/*
 * Tests on page https://demoqa.com/dynamic-properties
 */

import demoqa.WebDriverSettings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;

public class DynamicProperties extends WebDriverSettings {

    /*
     * Button "Will enable 5 seconds"
     * Check enable after 5 sec
     */

    @Test
    public void enableBtnAfter5Sec() throws InterruptedException {
        DynamicPropertiesPage dynamicPropertiesPage = PageFactory.initElements(driver, DynamicPropertiesPage.class);
        dynamicPropertiesPage.open();
        dynamicPropertiesPage.enableBtnAfterTime(5000);
        Assert.assertTrue(dynamicPropertiesPage.enableAfterBtn.isEnabled());
    }

    /*
     * Button "Will enable 5 seconds"
     * Check disable after 3 sec
     */

    @Test
    public void enableBtnAfter3Sec() throws InterruptedException {
        DynamicPropertiesPage dynamicPropertiesPage = PageFactory.initElements(driver, DynamicPropertiesPage.class);
        dynamicPropertiesPage.open();
        dynamicPropertiesPage.enableBtnAfterTime(3000);
        Assert.assertFalse(dynamicPropertiesPage.enableAfterBtn.isEnabled());
    }

    /*
     * Button "Will enable 7 seconds"
     * Check enable after 7 sec
     */

    @Test
    public void enableBtnAfter7Sec() throws InterruptedException {
        DynamicPropertiesPage dynamicPropertiesPage = PageFactory.initElements(driver, DynamicPropertiesPage.class);
        dynamicPropertiesPage.open();
        dynamicPropertiesPage.enableBtnAfterTime(7000);
        Assert.assertTrue(dynamicPropertiesPage.enableAfterBtn.isEnabled());
    }

    /*
     * Button "Color Change"
     * Check colour change after 5 sec
     */

    @Test
    public void changeColourBtnAfter5Sec() throws InterruptedException {
        DynamicPropertiesPage dynamicPropertiesPage = PageFactory.initElements(driver, DynamicPropertiesPage.class);
        dynamicPropertiesPage.open();
        dynamicPropertiesPage.enableBtnAfterTime(5000);
        Assert.assertNotEquals("#ffffff", Color.fromString(dynamicPropertiesPage.colorChangeBtn.getCssValue("color")).asHex());
    }

    /*
     * Button "Color Change"
     * Check no colour change after 3 sec
     */

    @Test
    public void changeColourBtnAfter3Sec() throws InterruptedException {
        DynamicPropertiesPage dynamicPropertiesPage = PageFactory.initElements(driver, DynamicPropertiesPage.class);
        dynamicPropertiesPage.open();
        dynamicPropertiesPage.enableBtnAfterTime(3000);
        Assert.assertEquals("#ffffff", Color.fromString(dynamicPropertiesPage.colorChangeBtn.getCssValue("color")).asHex());
    }

    /*
     * Button "Color Change"
     * Check colour change after 7 sec
     */

    @Test
    public void changeColourBtnAfter7Sec() throws InterruptedException {
        DynamicPropertiesPage dynamicPropertiesPage = PageFactory.initElements(driver, DynamicPropertiesPage.class);
        dynamicPropertiesPage.open();
        dynamicPropertiesPage.enableBtnAfterTime(7000);
        Assert.assertNotEquals("#ffffff", Color.fromString(dynamicPropertiesPage.colorChangeBtn.getCssValue("color")).asHex());
    }

    /*
     * Button "Visible After 5 Seconds"
     * Check visibility after 5 sec
     */

    @Test
    public void visibleBtnAfter5Sec() throws InterruptedException {
        DynamicPropertiesPage dynamicPropertiesPage = PageFactory.initElements(driver, DynamicPropertiesPage.class);
        dynamicPropertiesPage.open();
        dynamicPropertiesPage.enableBtnAfterTime(5000);
        Assert.assertTrue(dynamicPropertiesPage.visibleAfterBtn.isDisplayed());
    }

    /*
     * Button "Visible After 5 Seconds"
     * Check no visibility after 3 sec
     */

    @Test
    public void visibleBtnAfter3Sec() throws InterruptedException {
        DynamicPropertiesPage dynamicPropertiesPage = PageFactory.initElements(driver, DynamicPropertiesPage.class);
        dynamicPropertiesPage.open();
        dynamicPropertiesPage.enableBtnAfterTime(3000);
        Assert.assertFalse(dynamicPropertiesPage.isElementExist(dynamicPropertiesPage.visibleAfterBtn));
    }

    /*
     * Button "Visible After 5 Seconds"
     * Check visibility after 7 sec
     */

    @Test
    public void visibleBtnAfter7Sec() throws InterruptedException {
        DynamicPropertiesPage dynamicPropertiesPage = PageFactory.initElements(driver, DynamicPropertiesPage.class);
        dynamicPropertiesPage.open();
        dynamicPropertiesPage.enableBtnAfterTime(7000);
        Assert.assertTrue(dynamicPropertiesPage.visibleAfterBtn.isDisplayed());
    }
}
