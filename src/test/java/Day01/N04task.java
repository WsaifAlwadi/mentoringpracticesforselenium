package Day01;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;
public class N04task {
    public static void main(String[] args) throws InterruptedException {
        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        //Open URL
        driver.get("https://www.google.com/");

        // Maximize the window
        driver.manage().window().maximize();

        // Print the position and size of the page
        Point position = driver.manage().window().getPosition();
        Dimension size = driver.manage().window().getSize();
        System.out.println("Initial Position: " + position);
        System.out.println("Initial Size: " + size);

        // Minimize the page
        driver.manage().window().minimize();

        // Wait 5 seconds in the icon state
        Thread.sleep(5000);

        // Maximize the page again
        driver.manage().window().maximize();

        //Print the position and dimensions of the page in maximized state
        Point newPosition = driver.manage().window().getPosition();
        Dimension newSize = driver.manage().window().getSize();
        System.out.println("After Maximize - Position: " + newPosition);
        System.out.println("After Maximize - Size: " + newSize);

        // make the page fullscreen
        driver.manage().window().fullscreen();

        // Close the Browser
        driver.close();
    }
}
