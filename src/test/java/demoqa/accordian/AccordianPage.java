package demoqa.accordian;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccordianPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "section1Heading")
    WebElement firstElement;

    @FindBy(id = "section2Heading")
    WebElement secondElement;

    @FindBy(id = "section3Heading")
    WebElement thirdElement;

    @FindBy(xpath = "//div[./div[@id=\"section1Content\"]]")
    WebElement firstElementContentClass;

    @FindBy(xpath = "//div[./div[@id=\"section2Content\"]]")
    WebElement secondElementContentClass;

    @FindBy(xpath = "//div[./div[@id=\"section3Content\"]]")
    WebElement thirdElementContentClass;


    public AccordianPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void open() {
        driver.get("https://demoqa.com/accordian");
    }

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
