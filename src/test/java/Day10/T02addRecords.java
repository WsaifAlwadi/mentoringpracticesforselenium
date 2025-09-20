package Day10;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase2;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class T02addRecords extends TestBase2 {
    @Test
    void addRecordsAndFindYoungest() {

        // Go to the website
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        logger.info("Website opened...");

        Faker faker = new Faker();

        // Add 10 records
        for (int i = 0; i < 10; i++) {
            driver.findElement(By.id("addNewRecordButton")).click();

            driver.findElement(By.id("firstName")).sendKeys(faker.name().firstName());
            driver.findElement(By.id("lastName")).sendKeys(faker.name().lastName());
            driver.findElement(By.id("age")).sendKeys(String.valueOf(faker.number().numberBetween(18, 70)));
            driver.findElement(By.id("email")).sendKeys(faker.internet().emailAddress());
            driver.findElement(By.id("salary")).sendKeys(String.valueOf(faker.number().numberBetween(3000, 15000)));
            driver.findElement(By.id("department")).sendKeys(faker.company().industry());

            driver.findElement(By.id("submit")).click();
        }

        logger.info("10 records have been added...");

        // Get all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));

        // Store names and ages
        List<String> names = new ArrayList<>();
        List<Integer> ages = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.className("rt-td"));
            if (cells.size() > 2) {
                String fullName = cells.get(0).getText() + " " + cells.get(1).getText();
                String ageText = cells.get(2).getText();

                if (!ageText.isEmpty()) {
                    names.add(fullName);
                    ages.add(Integer.parseInt(ageText));
                }
            }
        }

        // Find the youngest
        int minAge = ages.stream().min(Comparator.naturalOrder()).orElse(-1);
        int index = ages.indexOf(minAge);
        String youngestName = names.get(index);

        logger.info("Youngest person: " + youngestName + " (" + minAge + " years old)");
        System.out.println("Youngest person: " + youngestName + " (" + minAge + " years old)");

        // Assertion: youngest age must be >= 18
        Assertions.assertTrue(minAge >= 18, "Youngest age should be at least 18");
    }
}
