package demoqa.radioButton;

/*
 * Description of locators and procedures
 * used for radio-button elements on
 * page https://demoqa.com/radio-button
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButtonPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "[for=\"yesRadio\"]")  // Active element of radio button "Yes"
    WebElement yesRadioButton;

    @FindBy(css="[for=\"impressiveRadio\"]") // Active element of radio button "Impressive"
    WebElement impressiveRadioButton;

    @FindBy(css="[for=\"noRadio\"]")  // Active element of radio button "No", element always disable
    private WebElement noRadioButtonText;

    @FindBy(id="noRadio")  // Element with text of radio button "No"
    private WebElement noRadioButtonActionField;

    @FindBy(css = "[class=\"text-success\"]") // Element with text indicating the passing of the test
    private WebElement successField;

    public RadioButtonPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    /*
     * Open required page
     */

    public void open(){
        driver.get("https://demoqa.com/radio-button");
    }

    /*
     * Click on active element of radio button
     */

    public void clickRadioButton(WebElement button){
        wait.until(ExpectedConditions.visibilityOf(button));
        button.click();
    }

    /*
     * Check enable of radio button "No"
     */

    public boolean enableNoRadioButton(){
        wait.until(ExpectedConditions.visibilityOf(noRadioButtonText));
        return noRadioButtonActionField.isEnabled();
    }

    /*
     * Get text after click on radio button
     */

    public String successFieldText(){
        wait.until(ExpectedConditions.visibilityOf(successField));
        return successField.getText();
    }



}
