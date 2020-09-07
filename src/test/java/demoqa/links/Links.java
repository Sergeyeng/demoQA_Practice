package demoqa.links;

/*
 * Tests on page https://demoqa.com/links
 */

import demoqa.WebDriverSettings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class Links extends WebDriverSettings {

    /*
     * Click on link "Home"
     * Check url in new window
     */

    @Test
    public void clickOnSimleLink(){
        LinksPage linksPage = PageFactory.initElements(driver,LinksPage.class);
        linksPage.open();
        linksPage.clickOnLink(linksPage.simpleLink);
        linksPage.switchWindows();
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        Assert.assertEquals("https://demoqa.com/",homePage.getCurrentUrl(homePage.homePageBanner));
    }

    /*
     * Click on link with dynamic text
     * Check url in new window
     */

    @Test
    public void clickOnDynamicLink(){
        LinksPage linksPage = PageFactory.initElements(driver,LinksPage.class);
        linksPage.open();
        linksPage.clickOnLink(linksPage.dynamicLink);
        linksPage.switchWindows();
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        Assert.assertEquals("https://demoqa.com/",homePage.getCurrentUrl(homePage.homePageBanner));
    }

    /*
     * Click on link "Created"
     * Check text
     */

    @Test
    public void clickOnCreatedLink(){
        LinksPage linksPage = PageFactory.initElements(driver,LinksPage.class);
        linksPage.open();
        linksPage.clickOnLink(linksPage.createdLink);
        Assert.assertEquals("201",linksPage.checkRequest());
    }

    /*
     * Click on link "No Content"
     * Check text
     */

    @Test
    public void clickOnNoContentLink(){
        LinksPage linksPage = PageFactory.initElements(driver,LinksPage.class);
        linksPage.open();
        linksPage.clickOnLink(linksPage.noContentLink);
        Assert.assertEquals("204",linksPage.checkRequest());
    }

    /*
     * Click on link "Moved"
     * Check text
     */

    @Test
    public void clickOnMovedLink(){
        LinksPage linksPage = PageFactory.initElements(driver,LinksPage.class);
        linksPage.open();
        linksPage.clickOnLink(linksPage.movedLink);
        Assert.assertEquals("301",linksPage.checkRequest());
    }

    /*
     * Click on link "Bad Request"
     * Check text
     */

    @Test
    public void clickOnBadRequestLink(){
        LinksPage linksPage = PageFactory.initElements(driver,LinksPage.class);
        linksPage.open();
        linksPage.clickOnLink(linksPage.badRequestLink);
        Assert.assertEquals("400",linksPage.checkRequest());
    }

    /*
     * Click on link "Unauthorized"
     * Check text
     */

    @Test
    public void clickOnUnauthorizedLink(){
        LinksPage linksPage = PageFactory.initElements(driver,LinksPage.class);
        linksPage.open();
        linksPage.clickOnLink(linksPage.unauthorizedLink);
        Assert.assertEquals("401",linksPage.checkRequest());
    }

    /*
     * Click on link "Forbidden"
     * Check text
     */

    @Test
    public void clickOnForbiddenLink(){
        LinksPage linksPage = PageFactory.initElements(driver,LinksPage.class);
        linksPage.open();
        linksPage.clickOnLink(linksPage.forbiddenLink);
        Assert.assertEquals("403",linksPage.checkRequest());
    }

    /*
     * Click on link "Not Found"
     * Check text
     */

    @Test
    public void clickOnNotFoundLink(){
        LinksPage linksPage = PageFactory.initElements(driver,LinksPage.class);
        linksPage.open();
        linksPage.clickOnLink(linksPage.invalidUrlLink);
        Assert.assertEquals("404",linksPage.checkRequest());
    }

}
