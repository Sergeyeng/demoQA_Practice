package demoqa.actionButton;

/*
 * Description of locators and procedures
 * used for button elements on
 * page https://demoqa.com/buttons
 */

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionButtonPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @FindBy(id = "doubleClickBtn")  // Button "Double Click Me"
    WebElement doubleClickBtn;

    @FindBy(id = "rightClickBtn") // Button "Right Click Me"
    WebElement rightClickBtn;

    @FindBy(xpath = "//button[text()='Click Me']") // Button "Click Me"
    WebElement dynamicBtn;

    @FindBy(id = "doubleClickMessage") // Text under button "Double Click Me"
    WebElement doubleClickMessage;

    @FindBy(id = "rightClickMessage") // Text under button "Right Click Me"
    WebElement rightClickMessage;

    @FindBy(id = "dynamicClickMessage") // Text under button "Click Me"
    WebElement dynamicClickMessage;

    public ActionButtonPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        action = new Actions(driver);
    }

    /*
     * Open required page
     */

    public void open() {
        driver.get("https://demoqa.com/buttons");
    }

    /*
     * Click on button
     */

    public void doubleClickBtn(WebElement button) {
        wait.until(ExpectedConditions.visibilityOf(button));
        action.doubleClick(button).perform();
    }


    public void rightClickBtn(WebElement button) {  // DELETE! Use only one function for all buttons
        wait.until(ExpectedConditions.visibilityOf(button));
        action.contextClick(button).perform();
    }

    public void onceClickBtn(WebElement button) { // DELETE! Use only one function for all buttons
        wait.until(ExpectedConditions.visibilityOf(button));
        button.click();
    }

    /*
     * Get text after click on button
     */

    public String successClickText(WebElement buttonText) {
        wait.until(ExpectedConditions.visibilityOf(buttonText));
        return buttonText.getText();
    }

    /*
     * Check existing of text after click on button
     */

    public Boolean isElementExist(WebElement successText) {  // Also in other ...Page.class, rework in one class for all pages

        try {
            successText.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
