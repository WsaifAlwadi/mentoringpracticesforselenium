package Day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class C04task {

    WebDriver driver;
    //Launch chrome and maximize
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    //Assert titles of Google - YouTube - LinkedIn
    @Test
    void test01() {
        //Navigate to Google
        driver.navigate().to("https://www.google.com");
        String googleTitle = driver.getTitle();
        Assertions.assertTrue(googleTitle.contains("Google"), "Title contain 'Google'");

        //Navigate to YouTube
        driver.navigate().to("https://www.youtube.com");
        String youtubeTitle = driver.getTitle();
        Assertions.assertTrue(youtubeTitle.contains("YouTube"), "Title contain 'YouTube'");

        //Navigate to LinkedIn
        driver.navigate().to("https://www.linkedin.com");
        String linkedInTitle = driver.getTitle();
        Assertions.assertTrue(linkedInTitle.contains("LinkedIn"), "Title contain 'LinkedIn'");
    }

    @Test
    void test02() {
        // Navigate Google → YouTube → LinkedIn
        driver.navigate().to("https://www.google.com");
        driver.navigate().to("https://www.youtube.com");
        driver.navigate().to("https://www.linkedin.com");


        //navigate back twice and assert the URL of Google
        driver.navigate().back();
        driver.navigate().back();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("google"), "must contain 'google'");

        //navigate back twice and assert the URL of Linked In
        driver.navigate().forward();
        driver.navigate().forward();
        String forwardUrl = driver.getCurrentUrl();
        Assertions.assertTrue(forwardUrl.contains("linkedin"), "must contain 'linkedIn' ");
    }
     //quite the browser
    @AfterEach
    void tearDown() {
            driver.quit();
    }
}


