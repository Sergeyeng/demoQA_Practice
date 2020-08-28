package demoqa.radioButton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButtonPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "[for=\"yesRadio\"]")
    WebElement yesRadioButton;

    @FindBy(css="[for=\"impressiveRadio\"]")
    WebElement impressiveRadioButton;

    @FindBy(css="[for=\"noRadio\"]")
    private WebElement noRadioButtonText;

    @FindBy(id="noRadio")
    private WebElement noRadioButtonActionField;

    @FindBy(css = "[class=\"text-success\"]")
    private WebElement successField;

    public RadioButtonPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public void open(){
        driver.get("https://demoqa.com/radio-button");
    }

    public void clickRadioButton(WebElement button){
        wait.until(ExpectedConditions.visibilityOf(button));
        button.click();
    }

    public boolean enableNoRadioButton(){
        wait.until(ExpectedConditions.visibilityOf(noRadioButtonText));
        return noRadioButtonActionField.isEnabled();
    }


    public String successFieldText(){
        wait.until(ExpectedConditions.visibilityOf(successField));
        return successField.getText();
    }



}
