package Day08;

import utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.awt.*;
import java.awt.event.KeyEvent;

public class N02task extends TestBase {
    /*
     * Open a demo login page (https://the-internet.herokuapp.com/login).
     * Click into the username field.
     * Type the username using sendKeys.
     * Use the Robot class to:
     *   - Press Tab → go to password field.
     *   - Type the password using sendKeys.
     *   - Press Enter → submit the form.
     * Verify login success or error message.
     */

    @Test
    void loginWithRobot() throws Exception {
        driver.get("https://the-internet.herokuapp.com/login");

        //  Click into the username field.
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");

        //  Press Tab → go to password field.
        Robot robot = new Robot();
        robot.setAutoDelay(200);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        //Type password via sendKeys
        WebElement passwordField = driver.switchTo().activeElement();
        passwordField.sendKeys("SuperSecretPassword!");

        // Robot submit it
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(2000);
        //Log in successfully
        String successMessage = driver.findElement(By.id("flash")).getText();
        Assertions.assertTrue(successMessage.contains("You logged into a secure area!"),
                "Login was not successful!");
        System.out.println(" Login test passed!");
    }
}
