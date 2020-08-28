package demoqa.radioButton;

import demoqa.WebDriverSettings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class RadioButton extends WebDriverSettings {

    @Test
    public void radioButtonYes() {
        RadioButtonPage radioButtonPage = PageFactory.initElements(driver,RadioButtonPage.class);
        radioButtonPage.open();
        radioButtonPage.clickRadioButton(radioButtonPage.yesRadioButton);
        Assert.assertEquals("Yes",radioButtonPage.successFieldText());
    }

    @Test
    public void radioButtonImpressive() {
        RadioButtonPage radioButtonPage = PageFactory.initElements(driver,RadioButtonPage.class);
        radioButtonPage.open();
        radioButtonPage.clickRadioButton(radioButtonPage.impressiveRadioButton);
        Assert.assertEquals("Impressive", radioButtonPage.successFieldText());
    }

    @Test
    public void radioButtonNo() {
        RadioButtonPage radioButtonPage = PageFactory.initElements(driver,RadioButtonPage.class);
        radioButtonPage.open();
        Assert.assertFalse(radioButtonPage.enableNoRadioButton());
    }

}
