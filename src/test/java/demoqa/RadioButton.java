package demoqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButton {

    @Test
    public void radioButtonYes() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver840414730.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://demoqa.com/radio-button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[for=\"yesRadio\"]")));
        driver.findElement(By.cssSelector("[for=\"yesRadio\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"text-success\"]")));
        Assert.assertEquals("Yes", driver.findElement(By.cssSelector("[class=\"text-success\"]")).getText());
        driver.quit();

    }

    @Test
    public void radioButtonImpressive() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver840414730.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://demoqa.com/radio-button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[for=\"impressiveRadio\"]")));
        driver.findElement(By.cssSelector("[for=\"impressiveRadio\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"text-success\"]")));
        Assert.assertEquals("Impressive", driver.findElement(By.cssSelector("[class=\"text-success\"]")).getText());
        driver.quit();

    }

    @Test
    public void radioButtonNo() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver840414730.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://demoqa.com/radio-button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[for=\"noRadio\"]")));
        Assert.assertFalse(driver.findElement(By.cssSelector("[id=\"noRadio\"]")).isEnabled());
        driver.quit();

    }

}
