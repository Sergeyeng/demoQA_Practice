package demoqa.alerts;

/*
 * Description of locators and procedures
 * used for alerts on
 * page https://demoqa.com/alerts
 */

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "alertButton") // Button "Click Button to see alert"
    WebElement alertBtn;

    @FindBy(id ="timerAlertButton") // Button "On button click, alert will appear after 5 seconds"
    WebElement timerAlertBtn;

    @FindBy(id="confirmButton") // Button "On button click, confirm box will appear"
    WebElement confirmBtn;

    @FindBy(id="promtButton") // Button "On button click, prompt box will appear"
    WebElement promtBtn;

    @FindBy(id="confirmResult") // Text under description "On button click, confirm box will appear"
    WebElement confirmResult;

    @FindBy(id="promptResult") // Text under description "On button click, prompt box will appear"
    WebElement promptResult;

    public AlertsPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    /*
     * Open required page
     */

    public void open() {
        driver.get("https://demoqa.com/alerts");
    }

    /*
     * Click on button
     */

    public void clickOnBtn(WebElement button){
        wait.until(ExpectedConditions.visibilityOf(button));
        button.click();
    }

    /*
     * Get text of alert
     */

    public String confimAlertByText(){
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    /*
     * Get text after confirm alert
     */

    public String textAfterAcceptAlert(WebElement text){
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.visibilityOf(text));
        return text.getText();
    }

    /*
     * Get text after dismiss alert
     */

    public String textAfterDismissAlert(WebElement text){ // rewrite using if for accept and dismiss alert
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
        wait.until(ExpectedConditions.visibilityOf(text));
        return text.getText();
    }

    /*
     * Input text in alert field and get result
     */

    public String inputTextAlert(WebElement text,String inputText){
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(inputText);
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.visibilityOf(text));
        return text.getText();
    }

    /*
     * Check visibility of alert after time
     */

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
