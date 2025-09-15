package Day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.util.List;

public class N01task extends TestBase{
    /*
     Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
     Click all the buttons and verify they are all clicked
    */
    @Test
    void javaScriptEventsTestWithListSafe() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        // Get all buttons
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        for (WebElement button : buttons) {
            try {
                button.click();
                Thread.sleep(200);
            } catch (Exception e) {
                System.out.println("Skipping button: " + button.getAttribute("id"));
            }
        }

        // Get all result messages
        List<WebElement> messages = driver.findElements(By.cssSelector("p.explanation"));

        boolean allClicked = true;
        for (WebElement message : messages) {
            if (!message.getText().toLowerCase().contains("clicked")) {
                allClicked = false;
                System.out.println("Not clicked: " + message.getAttribute("id"));
            }
        }

        Assertions.assertTrue(allClicked, "Some JavaScript event buttons were not clicked successfully!");
        System.out.println("All buttons clicked successfully (or skipped if not found).");
    }

}
