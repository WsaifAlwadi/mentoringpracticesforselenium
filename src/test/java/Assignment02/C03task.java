package Assignment02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

public class C03task {
    WebDriver driver;
     // open chrome
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

//Navigate to bbc
//Set browser size to 800x600 and assert the window size
    @Test
    void test01() {
        driver.get("https://www.bbc.com/");

        Dimension dimension = new Dimension(800, 600);
        driver.manage().window().setSize(dimension);

        Dimension currentSize = driver.manage().window().getSize();
        System.out.println("currentSize = " + currentSize);
        Assertions.assertEquals(802, currentSize.getWidth());

        Assertions.assertEquals(602, currentSize.getHeight());    }

    //Move the window to position (100, 100) and assert its position
    @Test
    void test02() {

        Point point = new Point(100, 100);
        driver.manage().window().setPosition(point);

        Point currentPosition = driver.manage().window().getPosition();
        Assertions.assertEquals(100, currentPosition.getX());
        Assertions.assertEquals(100, currentPosition.getY());
    }

    //Close the browser
    @AfterEach
    void tearDown() {
        driver.quit();
    }
}


