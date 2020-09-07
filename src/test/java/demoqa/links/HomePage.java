package demoqa.links;

/*
 * Description of locators and procedures
 * on page https://demoqa.com/home
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "home-banner") // Banner on homepage
    WebElement homePageBanner;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    /*
     * Get url of page
     */

    public String getCurrentUrl(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return driver.getCurrentUrl();
    }


}
