package demoqa.slider;

/*
 * Tests on page https://demoqa.com/slider
 */

import demoqa.WebDriverSettings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Slider extends WebDriverSettings {

    /*
     * Open page
     * Observe default setting of indicator
     */

    @Test
    public void defaultOpenPage(){
        SliderPage sliderPage = PageFactory.initElements(driver,SliderPage.class);
        sliderPage.open();
        Assert.assertEquals("25",sliderPage.getIndicatorValue(sliderPage.sliderValueOnSlider));
        Assert.assertEquals("25",sliderPage.getIndicatorValue(sliderPage.sliderValueInField));

    }

    /*
     * Open page
     * Move slider right
     * Observe indicator change
     */

//    @Test
//    public void slideIndicatorRight(){
//    }
}
