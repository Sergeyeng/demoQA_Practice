package demoqa.dynamicProperties;

/*
 * Description of locators and procedures
 * used for dynamic properties of buttons on
 * page https://demoqa.com/dynamic-properties
 */

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicPropertiesPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "enableAfter") // Button "Will enable 5 seconds"
    WebElement enableAfterBtn;

    @FindBy(id = "colorChange") // Button "Color Change"
    WebElement colorChangeBtn;

    @FindBy(id = "visibleAfter") // Button "Visible After 5 Seconds"
    WebElement visibleAfterBtn;

    public DynamicPropertiesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    /*
     * Open required page
     */

    public void open() {
        driver.get("https://demoqa.com/dynamic-properties");
    }

    /*
     * Waiting required time
     */

    public void enableBtnAfterTime(long milliseconds) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(colorChangeBtn));
        Thread.sleep(milliseconds);
    }

    /*
     * Check existing of text after click on button
     */

    public Boolean isElementExist(WebElement button) { // Also in other ...Page.class, rework in one class for all pages

        try {
            button.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
