package demoqa.alerts;

/*
 * Tests on page https://demoqa.com/alerts
 */

import demoqa.WebDriverSettings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class Alerts extends WebDriverSettings {

    /*
     * Click on button calling  alert
     * Check text in alert
     */

    @Test
    public void confirmAlert(){
        AlertsPage alertsPage = PageFactory.initElements(driver,AlertsPage.class);
        alertsPage.open();
        alertsPage.clickOnBtn(alertsPage.alertBtn);
        Assert.assertEquals("You clicked a button",alertsPage.confimAlertByText());
    }

    /*
     * Click on button calling  alert
     * Accept alert
     * Check text after accepting alert
     */

    @Test
    public void acceptAlert(){
        AlertsPage alertsPage = PageFactory.initElements(driver,AlertsPage.class);
        alertsPage.open();
        alertsPage.clickOnBtn(alertsPage.confirmBtn);
        Assert.assertEquals("Do you confirm action?",alertsPage.confimAlertByText());
        Assert.assertEquals("You selected Ok",alertsPage.textAfterAcceptAlert(alertsPage.confirmResult));
    }

    /*
     * Click on button calling  alert
     * Dismiss alert
     * Check text after dismissing alert
     */

    @Test
    public void dismissAlert(){
        AlertsPage alertsPage = PageFactory.initElements(driver,AlertsPage.class);
        alertsPage.open();
        alertsPage.clickOnBtn(alertsPage.confirmBtn);
        Assert.assertEquals("Do you confirm action?",alertsPage.confimAlertByText());
        Assert.assertEquals("You selected Cancel",alertsPage.textAfterDismissAlert(alertsPage.confirmResult));
    }

    /*
     * Click on button calling  alert
     * Input text "test" in alert
     * Check text after accepting alert
     */

    @Test
    public void promptAlert(){
        AlertsPage alertsPage = PageFactory.initElements(driver,AlertsPage.class);
        alertsPage.open();
        alertsPage.clickOnBtn(alertsPage.promtBtn);
        Assert.assertEquals("Please enter your name",alertsPage.confimAlertByText());
        Assert.assertEquals("You entered test",alertsPage.inputTextAlert(alertsPage.promptResult, "test"));
    }

    /*
     * Click on button "Alert after 5 sec"
     * Wait 5 sec
     * Check enable of alert
     */

    @Test
    public void alertAfter5Sec() throws InterruptedException {
        AlertsPage alertsPage = PageFactory.initElements(driver,AlertsPage.class);
        alertsPage.open();
        alertsPage.clickOnBtn(alertsPage.timerAlertBtn);
        Assert.assertTrue(alertsPage.checkAlertAfterTime(5000));
    }

    /*
     * Click on button "Alert after 5 sec"
     * Wait 7 sec
     * Check enable of alert
     */

    @Test
    public void alertAfter7Sec() throws InterruptedException {
        AlertsPage alertsPage = PageFactory.initElements(driver,AlertsPage.class);
        alertsPage.open();
        alertsPage.clickOnBtn(alertsPage.timerAlertBtn);
        Assert.assertTrue(alertsPage.checkAlertAfterTime(7000));
    }

    /*
     * Click on button "Alert after 5 sec"
     * Wait 3 sec
     * Check disable of alert
     */

    @Test
    public void alertAfter3Sec() throws InterruptedException {
        AlertsPage alertsPage = PageFactory.initElements(driver,AlertsPage.class);
        alertsPage.open();
        alertsPage.clickOnBtn(alertsPage.timerAlertBtn);
        Assert.assertFalse(alertsPage.checkAlertAfterTime(3000));
    }
}
