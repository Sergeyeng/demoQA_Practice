package demoqa.slider;

/*
 * Description of locators and procedures
 * used for slider on https://demoqa.com/slider
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class SliderPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Action action;

    @FindBy(xpath = "//*[@id=\"sliderContainer\"]/div[1]/span/input") // Cursor !!rewrite
    WebElement sliderCursor;

    @FindBy(xpath ="//input") // Slider value on slider
    WebElement sliderValueOnSlider;


    @FindBy(id="sliderValue") // Slider indicator in field
    WebElement sliderValueInField;

    public SliderPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    /*
     * Open required page
     */

    public void open(){
        driver.get("https://demoqa.com/slider");
    }

    /*
     * Return value of element
     */

    public String getIndicatorValue(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute("value");
    }

    /*
     * Move slider
     */

    public void moveElement(int movement){
        wait.until(ExpectedConditions.visibilityOf(sliderCursor));
        Actions move = new Actions(driver);
        move.moveToElement(sliderCursor)
                .dragAndDropBy(sliderCursor,movement,0)
                .build()
                .perform();
    }
}
