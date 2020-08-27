package demoqa.actionButton;

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

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/div[1]/div[3]/button") //fix this
    WebElement dynamicBtn;

    @FindBy(id = "doubleClickMessage")
    private WebElement doubleClickMessage;

    @FindBy(id = "rightClickMessage")
    private WebElement rightClickMessage;

    @FindBy(id = "dynamicClickMessage")
    private WebElement dynamicClickMessage;

    public ActionButtonPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
        action = new Actions(driver);
    }

    public void open(){
        driver.get("https://demoqa.com/buttons");
    }

    public void doubleClickBtn(WebElement button){
        wait.until(ExpectedConditions.visibilityOf(button));
        action.doubleClick(button).perform();
    }

    public void rightClickBtn(WebElement button){
        wait.until(ExpectedConditions.visibilityOf(button));
        action.contextClick(button).perform();
    }

    public void onceClickBtn(WebElement button){
        wait.until(ExpectedConditions.visibilityOf(button));
        button.click();
    }

    public String successDoubleClickBtnText(){
        wait.until(ExpectedConditions.visibilityOf(doubleClickMessage));
        return doubleClickMessage.getText();
    }

    public String successRightClickBtnText(){
        wait.until(ExpectedConditions.visibilityOf(rightClickBtn));
        return rightClickMessage.getText();
    }

    public String successDynamicClickBtn(){
        wait.until(ExpectedConditions.visibilityOf(dynamicClickMessage));
        return dynamicClickMessage.getText();
    }
}
