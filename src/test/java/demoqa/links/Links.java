package demoqa.links;

import demoqa.WebDriverSettings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class Links extends WebDriverSettings {

    @Test
    public void clickOnSimleLink(){
        LinksPage linksPage = PageFactory.initElements(driver,LinksPage.class);
        linksPage.open();
        linksPage.clickOnLink(linksPage.simpleLink);
        linksPage.switchWindows();
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        Assert.assertEquals("https://demoqa.com/",homePage.getCurrentUrl(homePage.homePageBanner));
    }

    @Test
    public void clickOnDynamicLink(){
        LinksPage linksPage = PageFactory.initElements(driver,LinksPage.class);
        linksPage.open();
        linksPage.clickOnLink(linksPage.dynamicLink);
        linksPage.switchWindows();
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        Assert.assertEquals("https://demoqa.com/",homePage.getCurrentUrl(homePage.homePageBanner));
    }

    @Test
    public void clickOnCreatedLink(){
        LinksPage linksPage = PageFactory.initElements(driver,LinksPage.class);
        linksPage.open();
        linksPage.clickOnLink(linksPage.createdLink);
        Assert.assertEquals("201",linksPage.checkRequest());
    }

    @Test
    public void clickOnNoContentLink(){
        LinksPage linksPage = PageFactory.initElements(driver,LinksPage.class);
        linksPage.open();
        linksPage.clickOnLink(linksPage.noContentLink);
        Assert.assertEquals("204",linksPage.checkRequest());
    }

    @Test
    public void clickOnMovedLink(){
        LinksPage linksPage = PageFactory.initElements(driver,LinksPage.class);
        linksPage.open();
        linksPage.clickOnLink(linksPage.movedLink);
        Assert.assertEquals("301",linksPage.checkRequest());
    }

    @Test
    public void clickOnBadRequestLink(){
        LinksPage linksPage = PageFactory.initElements(driver,LinksPage.class);
        linksPage.open();
        linksPage.clickOnLink(linksPage.badRequestLink);
        Assert.assertEquals("400",linksPage.checkRequest());
    }

    @Test
    public void clickOnUnauthorizedLink(){
        LinksPage linksPage = PageFactory.initElements(driver,LinksPage.class);
        linksPage.open();
        linksPage.clickOnLink(linksPage.unauthorizedLink);
        Assert.assertEquals("401",linksPage.checkRequest());
    }

    @Test
    public void clickOnForbiddenLink(){
        LinksPage linksPage = PageFactory.initElements(driver,LinksPage.class);
        linksPage.open();
        linksPage.clickOnLink(linksPage.forbiddenLink);
        Assert.assertEquals("403",linksPage.checkRequest());
    }

    @Test
    public void clickOnNotFoundLink(){
        LinksPage linksPage = PageFactory.initElements(driver,LinksPage.class);
        linksPage.open();
        linksPage.clickOnLink(linksPage.invalidUrlLink);
        Assert.assertEquals("404",linksPage.checkRequest());
    }

}
