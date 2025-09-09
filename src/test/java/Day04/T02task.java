package Day04;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class T02task {

    @Test
    public void test01() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Faker faker = new Faker();
        JavascriptExecutor javascript = (JavascriptExecutor) driver;

        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

        // Add five random tasks
        WebElement inputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='text']")));
        for (int i = 0; i < 5; i++) {
            String randomTask = faker.job().title();
            inputBox.sendKeys(randomTask);
            inputBox.sendKeys(Keys.ENTER);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(text(),'" + randomTask + "')]")));
            Thread.sleep(300);
        }

        // Mark every second task as completed
        List<WebElement> allTasks = driver.findElements(By.cssSelector("ul li"));
        for (int i = 0; i < allTasks.size(); i++) {
            if (i % 2 == 0) {
                allTasks.get(i).click();
            }
            Thread.sleep(300);
        }

        // Delete all completed tasks using JavaScript
        List<WebElement> completedTasks = driver.findElements(By.cssSelector("ul li.completed"));
        for (WebElement task : completedTasks) {
            javascript.executeScript("arguments[0].remove();", task);
            Thread.sleep(300);
        }

        // Final verification: no task should be marked as completed
        List<WebElement> remainingTasks = driver.findElements(By.cssSelector("ul li"));
        for (WebElement task : remainingTasks) {
            boolean isCompleted = task.getAttribute("class").contains("completed");
            assertFalse(isCompleted, "Task should not be marked as completed");
            Thread.sleep(300);
        }

        driver.quit(); // Close browser session
    }
}
