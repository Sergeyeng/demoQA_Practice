package demoqa.accordian;

/*
 * Description of locators and procedures
 * used on page https://demoqa.com/accordian
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccordianPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "section1Heading")  // First active header
    WebElement firstElement;

    @FindBy(id = "section2Heading") // Second active header
    WebElement secondElement;

    @FindBy(id = "section3Heading") // Third active header
    WebElement thirdElement;

    @FindBy(xpath = "//div[./div[@id=\"section1Content\"]]") // Element that shows class of content for first element
    WebElement firstElementContentClass;

    @FindBy(xpath = "//div[./div[@id=\"section2Content\"]]") // Element that shows class of content for second element
    WebElement secondElementContentClass;

    @FindBy(xpath = "//div[./div[@id=\"section3Content\"]]") // Element that shows class of content for third element
    WebElement thirdElementContentClass;


    public AccordianPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    /*
     * Open required page
     */

    public void open() {
        driver.get("https://demoqa.com/accordian");
    }

    /*
     * Compare class of element for observe is it hidden or not
     */

    public boolean visibilityOfContent(WebElement content) {
        if (content.getAttribute("class").equals("collapse show")) {
            return true;
        }
        //if (content.getAttribute("class").equals("collapse"))
        else{
            return false;
        }

    }


}
