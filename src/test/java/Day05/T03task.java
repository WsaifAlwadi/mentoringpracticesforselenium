package Day05;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
public class T03task {
    WebDriver driver;
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        By multiLocator =By.id("cars");
        WebElement multiElement = driver.findElement(multiLocator);
        Select multiSelect = new Select(multiElement);
//To verify if its multi select dropdown
        Assertions.assertTrue(multiSelect.isMultiple(), "The dropdown is not multi!");

        multiSelect.selectByIndex(2);
        System.out.println("Selected by index: Opel");
        Thread.sleep(300);
        multiSelect.deselectByIndex(2);
        System.out.println("Deselected by index: Opel");

        multiSelect.selectByValue("saab");
        System.out.println("Selected by value: Saab");
        Thread.sleep(300);
        multiSelect.deselectByValue("saab");
        System.out.println("Deselected by value: Saab");

        multiSelect.selectByVisibleText("Volvo");
        multiSelect.selectByVisibleText("Opel");
        multiSelect.selectByVisibleText("Saab");
//To deselect all
        System.out.println("Select mlti options to test ' deselect all '");
        Thread.sleep(500);
        multiSelect.deselectAll();
        System.out.println("All options are selected");
    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
