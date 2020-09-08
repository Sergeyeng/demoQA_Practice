package demoqa.brokenLinkAndImage;

import demoqa.WebDriverSettings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class BrokenLinkAndImage extends WebDriverSettings {

    /*
     * Open page
     * Compare expected and actual dimensions of correct image
     */

    @Test
    public void getDimensionsOfCorrectImage(){
        BrokenLinkAndImagePage brokenLinkAndImagePage = PageFactory.initElements(driver,BrokenLinkAndImagePage.class);
        brokenLinkAndImagePage.open();
        Assert.assertEquals("347x100",brokenLinkAndImagePage.getImageHeightAndWidth(brokenLinkAndImagePage.correctImage));
    }

    /*
     * Open page
     * Compare expected and actual dimensions of brocken image
     * In this case I know that brocken image is 16x16 and assert it only to get passed test
     * Correct test for such case is getDimensionsOfCorrectImage
     */

    @Test
    public void getDimensionsOfBrockenImage(){
        BrokenLinkAndImagePage brokenLinkAndImagePage = PageFactory.initElements(driver,BrokenLinkAndImagePage.class);
        brokenLinkAndImagePage.open();
        Assert.assertEquals("16x16",brokenLinkAndImagePage.getImageHeightAndWidth(brokenLinkAndImagePage.brockenImage));
    }

    /*
     * Open page
     * Click on link
     * Assert expected url and actual
     */

    @Test
    public void getUrlAfterClickOnValidLink(){
        BrokenLinkAndImagePage brokenLinkAndImagePage = PageFactory.initElements(driver,BrokenLinkAndImagePage.class);
        brokenLinkAndImagePage.open();
        Assert.assertEquals("https://demoqa.com/",brokenLinkAndImagePage.getUrlAfterClickOnLink(brokenLinkAndImagePage.correctLink));
    }

    /*
     * Open page
     * Click on link
     * Assert expected url and actual
     * In this case I know that after click on brocken link url will be http://demoooqa.com/
     * Correct test for such case is getUrlAfterClickOnValidLink
     */

    @Test
    public void getUrlAfterClickOnBrockenLink(){
        BrokenLinkAndImagePage brokenLinkAndImagePage = PageFactory.initElements(driver,BrokenLinkAndImagePage.class);
        brokenLinkAndImagePage.open();
        Assert.assertEquals("http://demoooqa.com/",brokenLinkAndImagePage.getUrlAfterClickOnLink(brokenLinkAndImagePage.brockenLink));
    }
}
