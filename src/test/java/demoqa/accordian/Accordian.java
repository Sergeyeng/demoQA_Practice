package demoqa.accordian;

/*
 * Tests on page https://demoqa.com/accordian
 */

import demoqa.WebDriverSettings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Accordian extends WebDriverSettings {

    /*
     * Check that after opening page first content is shown
     */

    @Test
    public void defaultOpenPage(){
        AccordianPage accordianPage = PageFactory.initElements(driver,AccordianPage.class);
        accordianPage.open();
        wait.until(ExpectedConditions.visibilityOf(accordianPage.firstElement));
        Assert.assertTrue(accordianPage.visibilityOfContent(accordianPage.firstElementContentClass));
        Assert.assertFalse(accordianPage.visibilityOfContent(accordianPage.secondElementContentClass));
        Assert.assertFalse(accordianPage.visibilityOfContent(accordianPage.thirdElementContentClass));
    }

    /*
     * Check that after click on second element content will open
     * Check that all other contents are hidden
     */

    @Test
    public void clickOnSecondElementCheck() throws InterruptedException {
        AccordianPage accordianPage = PageFactory.initElements(driver,AccordianPage.class);
        accordianPage.open();
        wait.until(ExpectedConditions.visibilityOf(accordianPage.firstElement));
        accordianPage.secondElement.click();
        Thread.sleep(1000); // find another way
        Assert.assertFalse(accordianPage.visibilityOfContent(accordianPage.firstElementContentClass));
        Assert.assertTrue(accordianPage.visibilityOfContent(accordianPage.secondElementContentClass));
        Assert.assertFalse(accordianPage.visibilityOfContent(accordianPage.thirdElementContentClass));
    }

    /*
     * Check that after click on third element content will open
     * Check that all other contents are hidden
     */

    @Test
    public void clickOnThirdElementCheck() throws InterruptedException {
        AccordianPage accordianPage = PageFactory.initElements(driver,AccordianPage.class);
        accordianPage.open();
        wait.until(ExpectedConditions.visibilityOf(accordianPage.firstElement));
        accordianPage.thirdElement.click();
        Thread.sleep(1000); // find another way
        Assert.assertFalse(accordianPage.visibilityOfContent(accordianPage.firstElementContentClass));
        Assert.assertFalse(accordianPage.visibilityOfContent(accordianPage.secondElementContentClass));
        Assert.assertTrue(accordianPage.visibilityOfContent(accordianPage.thirdElementContentClass));
    }

    /*
     * Check that after click on first element content will be hidden
     * Check that all other contents are hidden
     */

    @Test
    public void closeFirstElementCheck() throws InterruptedException {
        AccordianPage accordianPage = PageFactory.initElements(driver,AccordianPage.class);
        defaultOpenPage();
        accordianPage.firstElement.click();
        Thread.sleep(1000); // find another way
        Assert.assertFalse(accordianPage.visibilityOfContent(accordianPage.firstElementContentClass));
        Assert.assertFalse(accordianPage.visibilityOfContent(accordianPage.secondElementContentClass));
        Assert.assertFalse(accordianPage.visibilityOfContent(accordianPage.thirdElementContentClass));
    }

    /*
     * Check that after click on second element content will be hidden
     * Check that all other contents are hidden
     */

    @Test
    public void closeSecondElementCheck() throws InterruptedException {
        AccordianPage accordianPage = PageFactory.initElements(driver,AccordianPage.class);
        clickOnSecondElementCheck();
        accordianPage.secondElement.click();
        Thread.sleep(1000); // find another way
        Assert.assertFalse(accordianPage.visibilityOfContent(accordianPage.firstElementContentClass));
        Assert.assertFalse(accordianPage.visibilityOfContent(accordianPage.secondElementContentClass));
        Assert.assertFalse(accordianPage.visibilityOfContent(accordianPage.thirdElementContentClass));
    }

    /*
     * Check that after click on third element content will be hidden
     * Check that all other contents are hidden
     */

    @Test
    public void closeThirdElementCheck() throws InterruptedException {
        AccordianPage accordianPage = PageFactory.initElements(driver,AccordianPage.class);
        clickOnThirdElementCheck();
        accordianPage.thirdElement.click();
        Thread.sleep(1000); // find another way
        Assert.assertFalse(accordianPage.visibilityOfContent(accordianPage.firstElementContentClass));
        Assert.assertFalse(accordianPage.visibilityOfContent(accordianPage.secondElementContentClass));
        Assert.assertFalse(accordianPage.visibilityOfContent(accordianPage.thirdElementContentClass));
    }
}
