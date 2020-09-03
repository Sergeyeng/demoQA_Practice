package demoqa.links;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

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

        for (String child_window : s) {
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
            }
        }
    }
}
