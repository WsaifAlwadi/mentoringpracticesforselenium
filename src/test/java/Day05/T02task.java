package Day05;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;
public class T02task {
    WebDriver driver;
    @BeforeEach
   void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void oldStyletest01() {
        driver.get("https://demoqa.com/select-menu");
//Select old style using element id
        By oldStyleLocator = By.id("oldSelectMenu");
        WebElement oldStyleDropdown =driver.findElement(oldStyleLocator);
        Select select = new Select(oldStyleDropdown);
//To print all option
        List<WebElement> options = select.getOptions();
        System.out.println("Oled style menu :");
        for (WebElement option : options ) {
            System.out.println(option.getText());
        }
//To select 'purple' by index
        select.selectByIndex(4);
        System.out.println("Selcted by index : " + select.getFirstSelectedOption().getText());
//To select 'Magenta' by using visible text
        select.selectByVisibleText("Magenta");
        System.out.println("Selected by visible text: " + select.getFirstSelectedOption().getText());
//To select the option by value
        select.selectByValue("6"); // You can inspect the value from browser DevTools
        System.out.println("Selected by value: " + select.getFirstSelectedOption().getText());
    }
@AfterEach
void tearDown(){
        driver.quit();
}
}
