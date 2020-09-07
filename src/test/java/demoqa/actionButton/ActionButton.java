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
     * Click on button "Double Click Me"
     * Observe required text
     */

    @Test
    public void doubleClickBtnCorrectClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.doubleClickBtn(actionButtonPage.doubleClickBtn);
        Assert.assertEquals("You have done a double click",actionButtonPage.successClickText(actionButtonPage.doubleClickMessage));
    }

    /*
     * Click on button "Right Click Me"
     * Observe required text
     */

    @Test
    public void rightClickBtnCorrectClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.rightClickBtn(actionButtonPage.rightClickBtn);
        Assert.assertEquals("You have done a right click",actionButtonPage.successClickText(actionButtonPage.rightClickMessage));
    }

    /*
     * Click on button "Click Me"
     * Observe required text
     */

    @Test
    public void dynamicClickBtnCorrectClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.onceClickBtn(actionButtonPage.dynamicBtn);
        Assert.assertEquals("You have done a dynamic click",actionButtonPage.successClickText(actionButtonPage.dynamicClickMessage));
    }

    /*
     * Click on all buttons on page
     * Observe all texts
     */

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

    /*
     * Click on button "Double Click Me" using right click
     * Observe no success text
     */

    @Test
    public void doubleClickBtnRightClick(){
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
    public void doubleClickBtnOnceClick(){
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
    public void rightClickBtnDoubleClick(){
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
    public void rightClickBtnOnceClick(){
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
    public void onceClickBtnRightClick(){
        ActionButtonPage actionButtonPage = PageFactory.initElements(driver,ActionButtonPage.class);
        actionButtonPage.open();
        actionButtonPage.rightClickBtn(actionButtonPage.dynamicBtn);
        Assert.assertFalse(actionButtonPage.isElementExist(actionButtonPage.dynamicClickMessage));
    }
}
