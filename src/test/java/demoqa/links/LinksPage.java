package demoqa.links;

/*
 * Description of locators and procedures
 * on page https://demoqa.com/links
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;

public class LinksPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id="simpleLink") // Link with text "Home"
    WebElement simpleLink;

    @FindBy(id="dynamicLink") // Link with dynamic text
    WebElement dynamicLink;

    @FindBy(id="created") // Link with text "Created"
    WebElement createdLink;

    @FindBy(id="no-content") // Link with text "No Content"
    WebElement noContentLink;

    @FindBy(id="moved") // Link with text "Moved"
    WebElement movedLink;

    @FindBy(id="bad-request") // Link with text "Bad Request"
    WebElement badRequestLink;

    @FindBy(id="unauthorized") // Link with text "Unauthorized"
    WebElement unauthorizedLink;

    @FindBy(id="forbidden") // Link with text "Forbidden"
    WebElement forbiddenLink;

    @FindBy(id="invalid-url") // Link with text "Invalid Url"
    WebElement invalidUrlLink;

    @FindBy(xpath = "//*[@id=\"linkResponse\"]/b[1]") // Text under all links
    WebElement linkResponseCode;

    public LinksPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    /*
     * Open required page
     */

    public void open() {
        driver.get("https://demoqa.com/links");
    }

    /*
     * Click on link
     */

    public void clickOnLink(WebElement link){
        wait.until(ExpectedConditions.visibilityOf(link));
        link.click();
    }

    /*
     * Get text under all links
     */

    public String checkRequest(){
        wait.until(ExpectedConditions.visibilityOf(linkResponseCode));
        return linkResponseCode.getText();
    }

    /*
     * Switch pages in browser
     */

    public void switchWindows() {

        String parent = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();

        for (String child_window : s) {
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
            }
        }
    }
}
