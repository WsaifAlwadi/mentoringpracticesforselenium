package Day03;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class V03task {
    static WebDriver driver;
    static String url= "https://opensource-demo.orangehrmlive.com/";
    String userName ="Ahmad";
    String userPassword ="0987Ah";

    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Navigate to: https://opensource-demo.orangehrmlive.com/
        driver.navigate().to(url);

    }
     @Test
     void absoltuXpathTest() {
         // TODO: Locate username & password & log in  using absolut XPath
      By usernameAbsXpath = By.xpath("/html/body/div/div/div/div/div/div[2]/div[2]/form/div[1]/div/div[2]/input");
      By passwordAbsXpath = By.xpath("/html/body/div/div/div/div/div/div[2]/div[2]/form/div[2]/div/div[2]/input");
      By loginAbsXpath = By.xpath("/html/body/div/div/div/div/div/div[2]/div[2]/form/div[3]/button");

         WebElement username1 =driver.findElement( usernameAbsXpath);
         WebElement password1 =driver.findElement(passwordAbsXpath );
         WebElement login1 =driver.findElement(loginAbsXpath );

         Assertions.assertTrue(username1.isDisplayed());
         Assertions.assertTrue(password1.isDisplayed());
         Assertions.assertTrue(login1.isDisplayed());
         //TODO: Test both approaches work
         username1.sendKeys(userName);
         password1.sendKeys(userPassword);
         login1.click();
     }
    @Test
    void relativeXpathTest() {
        driver.get(url);
        // TODO: Locate username & password & log in  using relative XPath
        By userNameRlatXpath = By.xpath("//input[@name='username']");
        By passwordRlatXpath = By.xpath("//input[@name='password']");
        By loginButRelaXpath = By.xpath("//button[@type='submit']");

      WebElement username1 =driver.findElement(userNameRlatXpath );
      WebElement password1 =driver.findElement(passwordRlatXpath );
      WebElement login1 =driver.findElement(loginButRelaXpath );

        Assertions.assertTrue(username1.isDisplayed());
        Assertions.assertTrue(password1.isDisplayed());
        Assertions.assertTrue(login1.isDisplayed());
        //TODO: Test both approaches work
        username1.sendKeys(userName);
        password1.sendKeys(userPassword);
         login1.click();

    }
    @AfterAll
    static void tearDown() {
        driver.quit();
    }


    }



