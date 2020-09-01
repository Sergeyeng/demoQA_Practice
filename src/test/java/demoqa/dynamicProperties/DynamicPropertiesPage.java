package demoqa.dynamicProperties;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicPropertiesPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "enableAfter")
    WebElement enableAfterBtn;

    @FindBy(id = "colorChange")
    WebElement colorChangeBtn;

    @FindBy(id = "visibleAfter")
    WebElement visibleAfterBtn;

    public DynamicPropertiesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void open() {
        driver.get("https://demoqa.com/dynamic-properties");
    }

    public void enableBtnAfterTime(long miliseconds) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(colorChangeBtn));
        Thread.sleep(miliseconds);
    }

    public Boolean isElementExist(WebElement button) {

        try {
            button.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
