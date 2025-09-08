package Day01;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;
public class N03task {
    public static void main(String[] args) {
        // Launch Chrome and go to Amazon

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        // Print the current position and size
        Point initialPos = driver.manage().window().getPosition();
        Dimension initialSize = driver.manage().window().getSize();

        System.out.println("Initial Position: " + initialPos);
        System.out.println("Initial Size: " + initialSize);

        // Adjust the position and size as desired
        Point desiredPos = new Point(50, 50);   // x=100, y=50
        Dimension desiredSize = new Dimension(600, 600); // width=1200, height=800

        driver.manage().window().setPosition(desiredPos);
        driver.manage().window().setSize(desiredSize);

        // 4- Test that the page is in the position and size you want
        Point actualPos = driver.manage().window().getPosition();
        Dimension actualSize = driver.manage().window().getSize();

        if (actualPos.equals(desiredPos) && actualSize.equals(desiredSize)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
            System.out.println("Actual position" + actualPos + "The new" + desiredPos);
            System.out.println("Actual size" + actualSize + "The new" + desiredSize);
        }

        // Close the page
        driver.close();
    }
}


