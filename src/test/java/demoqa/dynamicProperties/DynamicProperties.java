package demoqa.dynamicProperties;

import demoqa.WebDriverSettings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;

public class DynamicProperties extends WebDriverSettings {

    @Test
    public void enableBtnAfter5Sec() throws InterruptedException {
        DynamicPropertiesPage dynamicPropertiesPage = PageFactory.initElements(driver, DynamicPropertiesPage.class);
        dynamicPropertiesPage.open();
        dynamicPropertiesPage.enableBtnAfterTime(5000);
        Assert.assertTrue(dynamicPropertiesPage.enableAfterBtn.isEnabled());
    }

    @Test
    public void enableBtnAfter3Sec() throws InterruptedException {
        DynamicPropertiesPage dynamicPropertiesPage = PageFactory.initElements(driver, DynamicPropertiesPage.class);
        dynamicPropertiesPage.open();
        dynamicPropertiesPage.enableBtnAfterTime(3000);
        Assert.assertFalse(dynamicPropertiesPage.enableAfterBtn.isEnabled());
    }

    @Test
    public void enableBtnAfter7Sec() throws InterruptedException {
        DynamicPropertiesPage dynamicPropertiesPage = PageFactory.initElements(driver, DynamicPropertiesPage.class);
        dynamicPropertiesPage.open();
        dynamicPropertiesPage.enableBtnAfterTime(7000);
        Assert.assertTrue(dynamicPropertiesPage.enableAfterBtn.isEnabled());
    }

    @Test
    public void changeColourBtnAfter5Sec() throws InterruptedException {
        DynamicPropertiesPage dynamicPropertiesPage = PageFactory.initElements(driver, DynamicPropertiesPage.class);
        dynamicPropertiesPage.open();
        dynamicPropertiesPage.enableBtnAfterTime(5000);
        Assert.assertNotEquals("#ffffff", Color.fromString(dynamicPropertiesPage.colorChangeBtn.getCssValue("color")).asHex());
    }

    @Test
    public void changeColourBtnAfter3Sec() throws InterruptedException {
        DynamicPropertiesPage dynamicPropertiesPage = PageFactory.initElements(driver, DynamicPropertiesPage.class);
        dynamicPropertiesPage.open();
        dynamicPropertiesPage.enableBtnAfterTime(3000);
        Assert.assertEquals("#ffffff", Color.fromString(dynamicPropertiesPage.colorChangeBtn.getCssValue("color")).asHex());
    }

    @Test
    public void changeColourBtnAfter7Sec() throws InterruptedException {
        DynamicPropertiesPage dynamicPropertiesPage = PageFactory.initElements(driver, DynamicPropertiesPage.class);
        dynamicPropertiesPage.open();
        dynamicPropertiesPage.enableBtnAfterTime(7000);
        Assert.assertNotEquals("#ffffff", Color.fromString(dynamicPropertiesPage.colorChangeBtn.getCssValue("color")).asHex());
    }

    @Test
    public void visibleBtnAfter5Sec() throws InterruptedException {
        DynamicPropertiesPage dynamicPropertiesPage = PageFactory.initElements(driver, DynamicPropertiesPage.class);
        dynamicPropertiesPage.open();
        dynamicPropertiesPage.enableBtnAfterTime(5000);
        Assert.assertTrue(dynamicPropertiesPage.visibleAfterBtn.isDisplayed());
    }

    @Test
    public void visibleBtnAfter3Sec() throws InterruptedException {
        DynamicPropertiesPage dynamicPropertiesPage = PageFactory.initElements(driver, DynamicPropertiesPage.class);
        dynamicPropertiesPage.open();
        dynamicPropertiesPage.enableBtnAfterTime(3000);
        Assert.assertFalse(dynamicPropertiesPage.isElementExist(dynamicPropertiesPage.visibleAfterBtn));
    }

    @Test
    public void visibleBtnAfter7Sec() throws InterruptedException {
        DynamicPropertiesPage dynamicPropertiesPage = PageFactory.initElements(driver, DynamicPropertiesPage.class);
        dynamicPropertiesPage.open();
        dynamicPropertiesPage.enableBtnAfterTime(7000);
        Assert.assertTrue(dynamicPropertiesPage.visibleAfterBtn.isDisplayed());
    }
}

//#e46470
