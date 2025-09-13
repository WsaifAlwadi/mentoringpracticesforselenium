package Day07;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class N02task {

    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @Test
    public void testActions() {

        driver.get("https://claruswaysda.github.io/submit-button.html");


        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("submitBtn")));
        submitBtn.click();


        String url = driver.getCurrentUrl();
        assertTrue(url.contains("actionsClickDrag"));

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(drag, drop).perform();
        WebElement dragDropMsg = driver.findElement(By.id("dragMsg"));
        assertTrue(dragDropMsg.getText().contains("Dropped!"));

        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClick).perform();
        WebElement rightClickMsg = driver.findElement(By.id("rightClickMsg"));
        assertTrue(rightClickMsg.getText().contains("Right-clicked!"));

        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClick).perform();
        WebElement doubleClickMsg = driver.findElement(By.id("doubleClickMsg"));
        assertTrue(doubleClickMsg.getText().contains("Double-clicked!"));

        // Hover
        WebElement hover = driver.findElement(By.id("hoverBtn"));
        actions.moveToElement(hover).perform();
        WebElement hoverMsg = driver.findElement(By.id("hoverMsg"));
        assertTrue(hoverMsg.getText().contains("Hovered!"));
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
