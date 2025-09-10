package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class N04Adddeletstars {

    WebDriver driver;
    WebDriverWait wait;
    String url = "https://claruswaysda.github.io/addDeleteStar.html";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    void addDeleteStarsTest() {
        driver.get(url);
        int addStars=5;
        int deletedStars1=2;
        int deletedStars2=3;



        addStars(5);
        Assertions.assertEquals(5, countStars());

        deleteStars(3);
        Assertions.assertEquals(2, countStars());
    }


    void addStars(int count) {
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Star']")));
        for (int i = 0; i < count; i++) {
            addButton.click();
            sleep(100);
        }
    }


    void deleteStars(int count) {
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Delete Star']")));
        for (int i = 0; i < count; i++) {
            deleteButton.click();
            sleep(100);
        }
    }


    int countStars() {
        List<WebElement> stars = driver.findElements(By.cssSelector("span.star"));
        return stars.size();
    }


    void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
