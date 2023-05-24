package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Activity6 {
    public static void main(String[] args) {

        // Disable fireforx logging in console
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // Create the Actions object
        Actions builder = new Actions(driver);

        // Open the page
        driver.get("https://alchemy.hguy.co/crm/");

        // Find the username field and enter the username
        driver.findElement(By.id("user_name")).sendKeys("admin");
        // Find the password field and enter the password
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        // Find the login button and click it
        driver.findElement(By.xpath("//input[@id='bigbutton']")).click();

        // Check if Home Page is displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sales']")));
        System.out.println("Home Page is displayed");

        // Create static list
        List<String> activitiesList = new ArrayList<>(Arrays.asList(
                "Home",
                "Calendar",
                "Calls",
                "Meetings",
                "Emails",
                "Tasks",
                "Notes"
        ));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()= 'Activities']"))).click();

        List<String> actualActivitiesList = new ArrayList<String>();
        List<WebElement> e = driver.findElements(By.xpath("(//ul[@class='dropdown-menu'])[5]/li"));
        for(int i =0; i< e.size(); i++){
            actualActivitiesList.add(e.get(i).getText());
        }

        if(actualActivitiesList.containsAll(activitiesList)){
            System.out.println("Activities menu items exists.");
            driver.close();
        }else{
            System.out.println("Activities menu items not exists.");
        }

    }
}
