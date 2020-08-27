package demoqa.actionButton;

import demoqa.WebDriverSettings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActionButton extends WebDriverSettings {

    @Test
    public void doubleClickBtnCorrectClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.doubleClickBtn(actionButtonPage.doubleClickBtn);
        Assert.assertEquals("You have done a double click",actionButtonPage.successDoubleClickBtnText());
    }

    @Test
    public void rightClickBtnCorrectClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.rightClickBtn(actionButtonPage.rightClickBtn);
        Assert.assertEquals("You have done a right click",actionButtonPage.successRightClickBtnText());
    }

    @Test
    public void dynamicClickBtnCorrectClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.onceClickBtn(actionButtonPage.dynamicBtn);
        Assert.assertEquals("You have done a dynamic click",actionButtonPage.successDynamicClickBtn());
    }

    @Test
    public void allButtonsClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.doubleClickBtn(actionButtonPage.doubleClickBtn);
        actionButtonPage.rightClickBtn(actionButtonPage.rightClickBtn);
        actionButtonPage.onceClickBtn(actionButtonPage.dynamicBtn);
        Assert.assertEquals("You have done a double click",actionButtonPage.successDoubleClickBtnText());
        Assert.assertEquals("You have done a right click",actionButtonPage.successRightClickBtnText());
        Assert.assertEquals("You have done a dynamic click",actionButtonPage.successDynamicClickBtn());
    }





}
