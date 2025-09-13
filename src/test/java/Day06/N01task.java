package Day06;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class N01task {
   static WebDriver driver;
    @BeforeAll
    // Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    // Maximize the website
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

    }
@Test
    void testEmoji() throws InterruptedException {
    driver.switchTo().frame("emoojis");
    WebElement secondEmoji = driver.findElement(By.xpath("//a[@href='#nature']"));
    secondEmoji.click();

    List<WebElement> emojiList = driver.findElements(By.xpath("//div[@id='nature']//img"));
    for (WebElement emoji : emojiList) {
        emoji.click();
    }

    driver.switchTo().defaultContent();

    driver.findElement(By.id("text")).sendKeys("Test Name");
    driver.findElement(By.id("smiles")).sendKeys("Happy");
    driver.findElement(By.id("food")).sendKeys("Pizza");
    driver.findElement(By.id("send")).click();
    Thread.sleep(400);


}
@AfterAll
    public static void tearDown(){
        driver.quit();
}

}
