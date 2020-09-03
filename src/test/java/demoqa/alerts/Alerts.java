package demoqa.alerts;

import demoqa.WebDriverSettings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class Alerts extends WebDriverSettings {

    @Test
    public void confirmAlert(){
        AlertsPage alertsPage = PageFactory.initElements(driver,AlertsPage.class);
        alertsPage.open();
        alertsPage.clickOnBtn(alertsPage.alertBtn);
        Assert.assertEquals("You clicked a button",alertsPage.confimAlertByText());
    }

    @Test
    public void acceptAlert(){
        AlertsPage alertsPage = PageFactory.initElements(driver,AlertsPage.class);
        alertsPage.open();
        alertsPage.clickOnBtn(alertsPage.confirmBtn);
        Assert.assertEquals("Do you confirm action?",alertsPage.confimAlertByText());
        Assert.assertEquals("You selected Ok",alertsPage.textAfterAcceptAlert(alertsPage.confirmResult));
    }

    @Test
    public void dismissAlert(){
        AlertsPage alertsPage = PageFactory.initElements(driver,AlertsPage.class);
        alertsPage.open();
        alertsPage.clickOnBtn(alertsPage.confirmBtn);
        Assert.assertEquals("Do you confirm action?",alertsPage.confimAlertByText());
        Assert.assertEquals("You selected Cancel",alertsPage.textAfterDismissAlert(alertsPage.confirmResult));
    }

    @Test
    public void promptAlert(){
        AlertsPage alertsPage = PageFactory.initElements(driver,AlertsPage.class);
        alertsPage.open();
        alertsPage.clickOnBtn(alertsPage.promtBtn);
        Assert.assertEquals("Please enter your name",alertsPage.confimAlertByText());
        Assert.assertEquals("You entered test",alertsPage.inputTextAlert(alertsPage.promptResult, "test"));
    }

    @Test
    public void alertAfter5Sec() throws InterruptedException {
        AlertsPage alertsPage = PageFactory.initElements(driver,AlertsPage.class);
        alertsPage.open();
        alertsPage.clickOnBtn(alertsPage.timerAlertBtn);
        Assert.assertTrue(alertsPage.checkAlertAfterTime(5000));
    }

    @Test
    public void alertAfter7Sec() throws InterruptedException {
        AlertsPage alertsPage = PageFactory.initElements(driver,AlertsPage.class);
        alertsPage.open();
        alertsPage.clickOnBtn(alertsPage.timerAlertBtn);
        Assert.assertTrue(alertsPage.checkAlertAfterTime(7000));
    }

    @Test
    public void alertAfter3Sec() throws InterruptedException {
        AlertsPage alertsPage = PageFactory.initElements(driver,AlertsPage.class);
        alertsPage.open();
        alertsPage.clickOnBtn(alertsPage.timerAlertBtn);
        Assert.assertFalse(alertsPage.checkAlertAfterTime(3000));
    }
}
