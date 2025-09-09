package Day04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T01task {
    @Test
    public void setUp(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
//Checks the current state of both checkboxes
        WebElement box1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement box2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
// Ensures both checkboxes are selected (click only if not already selected)
        if (!box1.isSelected()){
            box1.click();
        }
        if (!box2.isSelected()){
            box2.click();
        }
//Verify both checkboxes are checked after the operations
        Assertions.assertTrue(box1.isSelected(),"Check box 1 must selected");
        Assertions.assertTrue(box2.isSelected(),"Check box 2 must selected");
//Print the status of each checkbox to console */
        System.out.println("The selected Check box 1 is : "+box1.isSelected());
        System.out.println("The selected Check box 2 is : "+box2.isSelected());

driver.quit();
    }
}
