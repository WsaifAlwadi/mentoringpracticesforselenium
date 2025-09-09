package Day05;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class T01task {
    WebDriver driver;
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void dropDownTest() {
      //dropDown page
        driver.get("https://the-internet.herokuapp.com/dropdown");
//Select options values
        By dropdownLocator = By.id("dropdown");
        Select dropdown = new Select(driver.findElement(dropdownLocator));
        dropdown.selectByIndex(1);
        assertEquals("Option one 1 ", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("2");
        assertEquals("Option two 2 ", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("Option 1");
        assertEquals("Option 1", dropdown.getFirstSelectedOption().getText());
//Print all dropdown values
        System.out.println("Dropdown values:");
        List<WebElement> allOptions = dropdown.getOptions();
        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }

//Verify dropdown contains option 2
        boolean containsOption2 = allOptions.stream()
                .anyMatch(option -> option.getText().equals("option 2"));
        assertTrue(containsOption2, "Option 2 is not found in the dropdown options!");
        //print first selected option
        WebElement firstSelected = dropdown.getFirstSelectedOption();
        System.out.println("The first selected option is : " + firstSelected.getText());
        //Verify dropdown size = 3
        int size = allOptions.size();
        System.out.println("DropDown the size: " + size);
        Assertions.assertEquals(3, size, "Expected dropdown are 3 options ");
    }
//close
    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
