package Day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class C02task {

    WebDriver driver;
//open chrom and maximize
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//Navigate to selenium and Verify word WebDriver
    @Test
     void test01() {
        driver.get("https://www.selenium.dev");
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("WebDriver"));
    }

    //Navigate to python and Verify word python
    @Test
    public void test02() {
        driver.get("https://www.python.org");
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Python"));
    }
//close the browser
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
