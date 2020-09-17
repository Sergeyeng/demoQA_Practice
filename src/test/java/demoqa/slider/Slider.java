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

    @Test
    public void slideIndicatorRight(){
        SliderPage sliderPage = PageFactory.initElements(driver,SliderPage.class);
        sliderPage.open();
        sliderPage.moveElement(3);
        Assert.assertEquals("51",sliderPage.getIndicatorValue(sliderPage.sliderValueOnSlider));
        Assert.assertEquals("51",sliderPage.getIndicatorValue(sliderPage.sliderValueInField));
    }

    /*
     * Open page
     * Move slider left
     * Observe indicator change
     */

    @Test
    public void slideIndicatorLeft(){
        SliderPage sliderPage = PageFactory.initElements(driver,SliderPage.class);
        sliderPage.open();
        sliderPage.moveElement(-120);
        Assert.assertEquals("8",sliderPage.getIndicatorValue(sliderPage.sliderValueOnSlider));
        Assert.assertEquals("8",sliderPage.getIndicatorValue(sliderPage.sliderValueInField));
    }

    /*
     * Open page
     * Move slider right to the end
     * Observe indicator change
     */

    @Test
    public void slideIndicatorRightToTheEnd(){
        SliderPage sliderPage = PageFactory.initElements(driver,SliderPage.class);
        sliderPage.open();
        sliderPage.moveElement(142);
        Assert.assertEquals("100",sliderPage.getIndicatorValue(sliderPage.sliderValueOnSlider));
        Assert.assertEquals("100",sliderPage.getIndicatorValue(sliderPage.sliderValueInField));
    }

    /*
     * Open page
     * Move slider left to the end
     * Observe indicator change
     */

    @Test
    public void slideIndicatorLeftToTheEnd(){
        SliderPage sliderPage = PageFactory.initElements(driver,SliderPage.class);
        sliderPage.open();
        sliderPage.moveElement(-142);
        Assert.assertEquals("0",sliderPage.getIndicatorValue(sliderPage.sliderValueOnSlider));
        Assert.assertEquals("0",sliderPage.getIndicatorValue(sliderPage.sliderValueInField));
    }

    /*
     * Open page
     * Move slider left
     * Move slider right
     * Move slider left
     * Observe indicator change
     */

    @Test
    public void slideIndicatorMultipleTimes(){
        SliderPage sliderPage = PageFactory.initElements(driver,SliderPage.class);
        sliderPage.open();
        sliderPage.moveElement(3);
        sliderPage.moveElement(-18);
        sliderPage.moveElement(60);
        Assert.assertEquals("71",sliderPage.getIndicatorValue(sliderPage.sliderValueOnSlider));
        Assert.assertEquals("71",sliderPage.getIndicatorValue(sliderPage.sliderValueInField));
    }

}
