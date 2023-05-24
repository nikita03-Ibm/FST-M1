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
import java.util.List;

public class Activity8 {
    public static void main(String[] args) {

        // Disable fireforx logging in console
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

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

        // Locating the Main Menu
        WebElement salesMenu = driver.findElement(By.xpath("//a[text()='Sales']"));

        // Instantiating Actions class
        Actions actions = new Actions(driver);

        // Hovering on main menu
        actions.moveToElement(salesMenu);

        // Locating the element from Sub Menu
        WebElement subMenu = driver.findElement(By.xpath("//a[text()='Accounts']"));

        // To mouseover on sub menu & click
        actions.moveToElement(subMenu);
        actions.click().build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='list view table-responsive']//tbody//tr")));

        // Get all the table row elements from the table
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@class='list view table-responsive']//tbody//tr[@class='oddListRowS1']"));

        // And iterate over them and get all the cells
        for (int i = 0; i < allRows.size(); i++) {
            if (i == 5) {
                break;
            }

            List<WebElement> cells = driver.findElements(By.xpath("//table[@class='list view table-responsive']//tbody//tr[@class='oddListRowS1']//td[3]"));
            // Print the contents of each cell
            System.out.println(cells.get(i).getText());
        }
        driver.close();
    }
}
