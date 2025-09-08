package Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class N01task {
    public static void main(String[] args) {
        // Create chrome driver
        WebDriver driver = new ChromeDriver();
        // Open google home page
        driver.get("https://www.google.com");

        // Get title on page
        String title = driver.getTitle();
        System.out.println( title);

        //  Get current URL on page
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        // Close/Quit the browser
        driver.quit();
        driver.close();
    }
}
