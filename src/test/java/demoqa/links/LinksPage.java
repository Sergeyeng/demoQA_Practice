package demoqa.links;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;

public class LinksPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id="simpleLink")
    WebElement simpleLink;

    @FindBy(id="dynamicLink")
    WebElement dynamicLink;

    @FindBy(id="created")
    WebElement createdLink;

    @FindBy(id="no-content")
    WebElement noContentLink;

    @FindBy(id="moved")
    WebElement movedLink;

    @FindBy(id="bad-request")
    WebElement badRequestLink;

    @FindBy(id="unauthorized")
    WebElement unauthorizedLink;

    @FindBy(id="forbidden")
    WebElement forbiddenLink;

    @FindBy(id="invalid-url")
    WebElement invalidUrlLink;

    @FindBy(xpath = "//*[@id=\"linkResponse\"]/b[1]")
    WebElement linkResponseCode;

    public LinksPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void open() {
        driver.get("https://demoqa.com/links");
    }

    public void clickOnLink(WebElement link){
        wait.until(ExpectedConditions.visibilityOf(link));
        link.click();
    }

    public String checkRequest(){
        wait.until(ExpectedConditions.visibilityOf(linkResponseCode));
        return linkResponseCode.getText();
    }

    public void switchWindows() {

        String parent = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();

        Iterator<String> I1 = s.iterator();

        while (I1.hasNext()) {
            String child_window = I1.next();
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
            }
        }
    }
}
