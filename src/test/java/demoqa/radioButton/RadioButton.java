package demoqa.radioButton;
/*
 * Tests on page https://demoqa.com/radio-button
 */

import demoqa.WebDriverSettings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class RadioButton extends WebDriverSettings {

    /*
     * Click on "Yes" radio button
     * Observe text after click
     */
    @Test
    public void clickYesRadioButton() {
        RadioButtonPage radioButtonPage = PageFactory.initElements(driver,RadioButtonPage.class);
        radioButtonPage.open();
        radioButtonPage.clickRadioButton(radioButtonPage.yesRadioButton);
        Assert.assertEquals("Yes",radioButtonPage.successFieldText());
    }

    /*
     * Click on "Impressive" radio button
     * Observe text after click
     */
    @Test
    public void clickImpressiveRadioButton() {
        RadioButtonPage radioButtonPage = PageFactory.initElements(driver,RadioButtonPage.class);
        radioButtonPage.open();
        radioButtonPage.clickRadioButton(radioButtonPage.impressiveRadioButton);
        Assert.assertEquals("Impressive", radioButtonPage.successFieldText());
    }

    /*
     * Check that "No" radio button disabled
     */
    @Test
    public void radioButtonNo() {
        RadioButtonPage radioButtonPage = PageFactory.initElements(driver,RadioButtonPage.class);
        radioButtonPage.open();
        Assert.assertFalse(radioButtonPage.enableNoRadioButton());
    }

}
