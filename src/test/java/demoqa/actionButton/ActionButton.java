package demoqa.actionButton;
/*
 * Tests on page https://demoqa.com/button
 */

import demoqa.WebDriverSettings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class ActionButton extends WebDriverSettings {

    /*
     * Click on button "Double Click Me" using double click
     * Observe text after click
     */

    @Test
    public void correctClickOnDoubleClickBtn(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.doubleClickBtn(actionButtonPage.doubleClickBtn);
        Assert.assertEquals("You have done a double click",actionButtonPage.successClickText(actionButtonPage.doubleClickMessage));
    }

    /*
     * Click on button "Right Click Me" using right click
     * Observe text after click
     */

    @Test
    public void correctClickOnRightClickBtn(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.rightClickBtn(actionButtonPage.rightClickBtn);
        Assert.assertEquals("You have done a right click",actionButtonPage.successClickText(actionButtonPage.rightClickMessage));
    }

    /*
     * Click on button "Click Me" using once click
     * Observe text after click
     */

    @Test
    public void correctClickOnOnceClickBtn(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.onceClickBtn(actionButtonPage.dynamicBtn);
        Assert.assertEquals("You have done a dynamic click",actionButtonPage.successClickText(actionButtonPage.dynamicClickMessage));
    }

    /*
     * Click on all buttons on page using right methods
     * Observe all text after clicks
     */

    @Test
    public void correctClickOnAllBtns(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.doubleClickBtn(actionButtonPage.doubleClickBtn);
        actionButtonPage.rightClickBtn(actionButtonPage.rightClickBtn);
        actionButtonPage.onceClickBtn(actionButtonPage.dynamicBtn);
        Assert.assertEquals("You have done a double click",actionButtonPage.successClickText(actionButtonPage.doubleClickMessage));
        Assert.assertEquals("You have done a right click",actionButtonPage.successClickText(actionButtonPage.rightClickMessage));
        Assert.assertEquals("You have done a dynamic click",actionButtonPage.successClickText(actionButtonPage.dynamicClickMessage));
    }

    /*
     * Click on button "Double Click Me" using right click
     * Observe no success text
     */

    @Test
    public void doubleClickBtnUsingRightClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.rightClickBtn(actionButtonPage.doubleClickBtn);
        Assert.assertFalse(actionButtonPage.isElementExist(actionButtonPage.doubleClickMessage));
    }

    /*
     * Click on button "Double Click Me" using one click
     * Observe no success text
     */

    @Test
    public void doubleClickBtnUsingOnceClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.onceClickBtn(actionButtonPage.doubleClickBtn);
        Assert.assertFalse(actionButtonPage.isElementExist(actionButtonPage.doubleClickMessage));
    }

    /*
     * Click on button "Right Click Me" using double click
     * Observe no success text
     */

    @Test
    public void rightClickBtnUsingDoubleClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.doubleClickBtn(actionButtonPage.rightClickBtn);
        Assert.assertFalse(actionButtonPage.isElementExist(actionButtonPage.rightClickMessage));
    }

    /*
     * Click on button "Right Click Me" using one click
     * Observe no success text
     */

    @Test
    public void rightClickBtnUsingOnceClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.onceClickBtn(actionButtonPage.rightClickBtn);
        Assert.assertFalse(actionButtonPage.isElementExist(actionButtonPage.rightClickMessage));
    }

    /*
     * Click on button "Click Me" using one right click
     * Observe no success text
     */

    @Test
    public void onceClickBtnUsingRightClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.rightClickBtn(actionButtonPage.dynamicBtn);
        Assert.assertFalse(actionButtonPage.isElementExist(actionButtonPage.dynamicClickMessage));
    }
}
