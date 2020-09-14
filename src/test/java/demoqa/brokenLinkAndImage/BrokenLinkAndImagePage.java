package demoqa.brokenLinkAndImage;

/*
 * Description of locators and procedures
 * used for button elements on
 * page https://demoqa.com/broken
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrokenLinkAndImagePage {

    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath = "//img[1]")  // Correct image
    WebElement correctImage;

    @FindBy(xpath = "//img[2]")  // Brocken image
    WebElement brockenImage;

    @FindBy(xpath = "//a[1]")    // Correct link
    WebElement correctLink;

    @FindBy(xpath="//a[2]")      // Brocken link
    WebElement brockenLink;

    @FindBy(xpath = "//body") // For waiting page, in real cases we should wait for real element
    private WebElement pageBody;

    public BrokenLinkAndImagePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    /*
     * Open required page
     */

    public void open() {
        driver.get("https://demoqa.com/broken");
    }

    /*
     * Get image height and width, return like 100x100
     */

    public String getImageHeightAndWidth(WebElement image){
        wait.until(ExpectedConditions.visibilityOf(image));
        return image.getSize().width +"x"+ image.getSize().height;
    }

    /*
     * Get url after click on on link
     */

    public String getUrlAfterClickOnLink(WebElement link){
        wait.until(ExpectedConditions.visibilityOf(link));
        link.click();
        wait.until(ExpectedConditions.visibilityOf(pageBody));
        return driver.getCurrentUrl();
    }
}
