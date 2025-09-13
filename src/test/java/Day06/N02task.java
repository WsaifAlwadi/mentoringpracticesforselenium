package Day06;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class N02task {
     static WebDriver driver;
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/guru99home/");
    }


    @Test
    public void multipleIframes() throws InterruptedException {

        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("The number of iframes is =" + iframes.size());
        driver.switchTo().frame(1);
        WebElement link = driver.findElement(By.xpath("//a[contains(@href,'live-selenium-project')]"));
        link.click();
        Thread.sleep(600);
        driver.switchTo().defaultContent();
    }

    @AfterAll
    static void tearDown() {
        driver.quit();

    }
}
