package Day03;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class V01task {
    WebDriver driver;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    //t1

    @Test
    public void test01() throws InterruptedException {
        //TODO: Navigate totest page
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        //TODO: Click on "Locators - Find By Playground Test Page"
        WebElement locatorsLink = driver.findElement(By.linkText("Locators - Find By Playground Test Page"));
        locatorsLink.click();
        Thread.sleep(2000);
        System.out.println("Current URL after Locators click: " + driver.getCurrentUrl());

        driver.navigate().back();
        Thread.sleep(2000);


        System.out.println("URL after going back: " + driver.getCurrentUrl());

        //TODO: Click on "WebDriver Example Page"
        WebElement webDriverExampleLink = driver.findElement(By.linkText("WebDriver Example Page"));
        webDriverExampleLink.click();
        Thread.sleep(2000);

        //TODO:  Print current URL
        System.out.println("Current URL after WebDriver Example click: " + driver.getCurrentUrl());

        //TODO: Enter value 20 in number input
        WebElement numberInput = driver.findElement(By.id("numentry"));
        numberInput.sendKeys("20");
        Thread.sleep(2000);
        WebElement submitBtn = driver.findElement(By.id("submit-to-server"));
        submitBtn.click();
        Thread.sleep(2000);
        //TODO: Verify'TWO-ZERO' message
        WebElement resultMsg = driver.findElement(By.id("message"));
        String msgText = resultMsg.getText();
        System.out.println("Result Message: " + msgText);
        assertTrue(msgText.contains("two, zero"));
    }
    //close
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
