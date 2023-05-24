package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity2 {
    public static void main(String[] args) {

        // Disable fireforx logging in console
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        // Open the page
        driver.get("https://alchemy.hguy.co/crm/");

        // Print the header image url & close the browser
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='SuiteCRM']")));
        WebElement headImgUrl = driver.findElement(By.xpath("//a[text()='SuiteCRM']"));
        System.out.println("Header image url: " + headImgUrl.getAttribute("href"));
        driver.close();
    }
}
