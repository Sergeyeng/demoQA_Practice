package demoqa.actionButton;

import demoqa.WebDriverSettings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class ActionButton extends WebDriverSettings {

    @Test
    public void doubleClickBtnCorrectClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.doubleClickBtn(actionButtonPage.doubleClickBtn);
        Assert.assertEquals("You have done a double click",actionButtonPage.successClickText(actionButtonPage.doubleClickMessage));
    }

    @Test
    public void rightClickBtnCorrectClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.rightClickBtn(actionButtonPage.rightClickBtn);
        Assert.assertEquals("You have done a right click",actionButtonPage.successClickText(actionButtonPage.rightClickMessage));
    }

    @Test
    public void dynamicClickBtnCorrectClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.onceClickBtn(actionButtonPage.dynamicBtn);
        Assert.assertEquals("You have done a dynamic click",actionButtonPage.successClickText(actionButtonPage.dynamicClickMessage));
    }

    @Test
    public void allButtonsClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.doubleClickBtn(actionButtonPage.doubleClickBtn);
        actionButtonPage.rightClickBtn(actionButtonPage.rightClickBtn);
        actionButtonPage.onceClickBtn(actionButtonPage.dynamicBtn);
        Assert.assertEquals("You have done a double click",actionButtonPage.successClickText(actionButtonPage.doubleClickMessage));
        Assert.assertEquals("You have done a right click",actionButtonPage.successClickText(actionButtonPage.rightClickMessage));
        Assert.assertEquals("You have done a dynamic click",actionButtonPage.successClickText(actionButtonPage.dynamicClickMessage));
    }

    @Test
    public void doubleClickBtnRightClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.rightClickBtn(actionButtonPage.doubleClickBtn);
        Assert.assertFalse(actionButtonPage.isElementExist(actionButtonPage.doubleClickMessage));
    }

    @Test
    public void doubleClickBtnOnceClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.onceClickBtn(actionButtonPage.doubleClickBtn);
        Assert.assertFalse(actionButtonPage.isElementExist(actionButtonPage.doubleClickMessage));
    }

    @Test
    public void rightClickBtnDoubleClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.doubleClickBtn(actionButtonPage.rightClickBtn);
        Assert.assertFalse(actionButtonPage.isElementExist(actionButtonPage.rightClickMessage));
    }

    @Test
    public void rightClickBtnOnceClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.onceClickBtn(actionButtonPage.rightClickBtn);
        Assert.assertFalse(actionButtonPage.isElementExist(actionButtonPage.rightClickMessage));
    }

    @Test
    public void onceClickBtnRightClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.rightClickBtn(actionButtonPage.dynamicBtn);
        Assert.assertFalse(actionButtonPage.isElementExist(actionButtonPage.dynamicClickMessage));
    }
}
