package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) {

        // Disable fireforx logging in console
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/crm/");

        // Print the title of the page & close the browser
        String Title = driver.getTitle();
        if(Title.contains("SuiteCRM")){
            System.out.println("Home page title: " + Title);
            driver.close();
        }else{
            System.out.println("Home page title not matching: " + Title);
        }

    }
}
