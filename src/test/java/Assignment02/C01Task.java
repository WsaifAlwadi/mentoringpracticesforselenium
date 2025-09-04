package Assignment02;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class C01Task {
    WebDriver driver;
    //Task 1: Browser History Exploration
//Setup:
    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Test is running");

    }

    @AfterEach
    void tearDown() {
        driver.quit();
        System.out.println("Test finished");
    }


    //Test one include Back and Forward multi times
    @Test
    public void test01() {

        driver.navigate().to("https://www.wikipedia.org");
        System.out.println(driver.getTitle());
        Assertions.assertTrue(driver.getTitle().contains("Wikipedia"));
        driver.navigate().to("https://www.google.com");
        Assertions.assertTrue(driver.getTitle().contains("Google"));


        driver.navigate().back();
        Assertions.assertTrue(driver.getTitle().contains("Wikipedia"));
        driver.navigate().forward();
        Assertions.assertTrue(driver.getTitle().contains("Google"));

        driver.navigate().back();
        Assertions.assertTrue(driver.getTitle().contains("Wikipedia"));
        driver.navigate().forward();
        Assertions.assertTrue(driver.getTitle().contains("Google"));

    }
    @Test
    void test02(){
        driver.get("https://www.google.com");
        driver.navigate().refresh();
        String refreshedTitle = driver.getTitle();
        Assertions.assertTrue(refreshedTitle.contains("Google"));
    }
    @Test
    public void test2() {
        driver.navigate().to("https://www.google.com");
        Assertions.assertTrue(driver.getTitle().contains("Google"));


        driver.navigate().refresh();
        Assertions.assertTrue(driver.getTitle().contains("Google"));
    }

}
