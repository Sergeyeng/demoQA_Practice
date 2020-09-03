package demoqa.alerts;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "alertButton")
    WebElement alertBtn;

    @FindBy(id ="timerAlertButton")
    WebElement timerAlertBtn;

    @FindBy(id="confirmButton")
    WebElement confirmBtn;

    @FindBy(id="promtButton")
    WebElement promtBtn;

    @FindBy(id="confirmResult")
    WebElement confirmResult;

    @FindBy(id="promptResult")
    WebElement promptResult;

    public AlertsPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void open() {
        driver.get("https://demoqa.com/alerts");
    }

    public void clickOnBtn(WebElement button){
        wait.until(ExpectedConditions.visibilityOf(button));
        button.click();
    }

    public String confimAlertByText(){
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public String textAfterAcceptAlert(WebElement text){
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.visibilityOf(text));
        return text.getText();
    }

    public String textAfterDismissAlert(WebElement text){
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
        wait.until(ExpectedConditions.visibilityOf(text));
        return text.getText();
    }

    public String inputTextAlert(WebElement text,String inputText){
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(inputText);
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.visibilityOf(text));
        return text.getText();
    }

    public Boolean checkAlertAfterTime(long milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
        try {
            driver.switchTo().alert().accept();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
