package demoqa;

/*
 * Description of what happens at the beginning
 * and at the end of each test
 */

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverSettings {

    public WebDriver driver;
    public WebDriverWait wait;

    /*
     * Initializing webdriver and required variables
     */

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver840414730.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    /*
     * Browser shut down
     */

    @After
    public void close(){
        driver.quit(); }
}
