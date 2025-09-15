package tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.nio.file.Path;
public class N03files extends TestBase {
        /*
    Go to https://claruswaysda.github.io/downloadUpload.html
    Upload a PDF using single upload button
    Verify that 'Files uploaded successfully!'
    Do negative test (No file or other than PDF)
    Verify that 'Please upload at least one PDF file. Only PDF files are allowed!'
    Test multiple PDFs as well
    */
        @Test
        void testUserRegistrationAndScreenshots() throws IOException, InterruptedException {
            driver.get("https://claruswaysda.github.io/homepage.html");

            // Open registration form
            driver.findElement(By.id("userIcon")).click();
            driver.findElement(By.linkText("Register")).click();

            // Fill registration form
            driver.findElement(By.id("ssn")).sendKeys("123-45-6789");
            driver.findElement(By.id("first-name")).sendKeys("John");
            driver.findElement(By.id("last-name")).sendKeys("Doe");
            driver.findElement(By.id("address")).sendKeys("123 Main St");
            driver.findElement(By.id("phone")).sendKeys("9875898644");
            driver.findElement(By.id("username")).sendKeys("johndoe");
            driver.findElement(By.id("email")).sendKeys("oiuytfvb@gmile.com");
            driver.findElement(By.id("password")).sendKeys("12345");
            driver.findElement(By.id("confirm-password")).sendKeys("12345");

            // Submit registration
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(1000);

            // Verify success message
            Assertions.assertTrue(driver.findElement(By.id("successMessage")).isDisplayed());

            // Login with the registered user
            driver.findElement(By.className("login-button")).click();
            Thread.sleep(1000);

            // Take screenshots
            takeScreenshot("homepage_after_login.png");
            takeElementScreenshot(driver.findElement(By.id("celebrateLogin")), "celebrate_login_button.png");
            takeElementScreenshot(driver.findElement(By.id("confettiContainer")), "confetti_page.png");
        }

    private void takeScreenshot(String fileName) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path dest = Path.of(System.getProperty("user.dir"), "screenshots", fileName);
        Files.createDirectories(dest.getParent());
        Files.copy(src.toPath(), dest);
    }

    private void takeElementScreenshot(WebElement element, String fileName) throws IOException {
        File src = element.getScreenshotAs(OutputType.FILE);
        Path dest = Path.of(System.getProperty("user.dir"), "screenshots", fileName);
        Files.createDirectories(dest.getParent());
        Files.copy(src.toPath(), dest);
    }
}
