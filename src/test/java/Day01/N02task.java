package Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class N02task {
    public static void main(String[] args) {
        // Invoke firefox driver
        WebDriver driver2 = new FirefoxDriver();

        // Go to YouTube
        driver2.get("https://www.youtube.com/");

        //Verify the page title contains the word "video"
        String title = driver2.getTitle();
        System.out.println("Title Page is "+ title);

        if ( title.toLowerCase().contains("video")) {
            System.out.println("Correct Title contain 'video'");
        } else {
            System.out.println("Filed Title not contains 'video'");
        }

        // Close the driver
        driver2.close();
    }
}
