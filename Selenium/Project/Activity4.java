package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity4 {
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

        // Find the username field and enter the username
        driver.findElement(By.id("user_name")).sendKeys("admin");
        // Find the password field and enter the password
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        // Find the login button and click it
        driver.findElement(By.xpath("//input[@id='bigbutton']")).click();

        // Verify If home page is displayed & close the browser
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sales']")));
        if(driver.findElement(By.xpath("//a[text()='Sales']")).isDisplayed()){
            System.out.println("Home Page is displayed");
            driver.close();
        }else{
            System.out.println("Home Page is not displayed");
        }
    }
}
