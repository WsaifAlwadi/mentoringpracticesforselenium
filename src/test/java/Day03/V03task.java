package Day03;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class V03task {

    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    @Test
    public void test01() {

        String[] movies = {"Green Mile", "Premonition", "The Curious Case of Benjamin Button"};
        for (String movie : movies) {
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.clear();
            searchBox.sendKeys(movie);
            searchBox.sendKeys(Keys.ENTER);
            System.out.println("The title after search " + driver.getTitle());
            driver.navigate().back();
        }
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
