package demoqa.actionButton;

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

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickBtn;

    @FindBy(id = "rightClickBtn")
    WebElement rightClickBtn;

    @FindBy(xpath = "//button[text()='Click Me']")
    WebElement dynamicBtn;

    @FindBy(id = "doubleClickMessage")
    WebElement doubleClickMessage;

    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;

    @FindBy(id = "dynamicClickMessage")
    WebElement dynamicClickMessage;

    public ActionButtonPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        action = new Actions(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/buttons");
    }

    public void doubleClickBtn(WebElement button) {
        wait.until(ExpectedConditions.visibilityOf(button));
        action.doubleClick(button).perform();
    }

    public void rightClickBtn(WebElement button) {
        wait.until(ExpectedConditions.visibilityOf(button));
        action.contextClick(button).perform();
    }

    public void onceClickBtn(WebElement button) {
        wait.until(ExpectedConditions.visibilityOf(button));
        button.click();
    }

    public String successClickText(WebElement buttonText) {
        wait.until(ExpectedConditions.visibilityOf(buttonText));
        return buttonText.getText();
    }

    public Boolean isElementExist(WebElement successText) {

        try {
            successText.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
