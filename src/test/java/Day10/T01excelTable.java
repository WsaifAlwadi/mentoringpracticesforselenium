package Day10;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import utilities.TestBase2;

public class T01excelTable extends TestBase2 {
    @Test
    void writeTable1ToExcel() throws IOException {

        // Go to the website
        driver.get("https://claruswaysda.github.io/webTable.html");
        logger.info("Website opened...");

        // Locate Table 1
        WebElement table1 = driver.findElement(By.xpath("//table[@id='t1']"));

        // Get all rows of the table (including header)
        List<WebElement> rows = table1.findElements(By.tagName("tr"));

        // Create a new Excel workbook & sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Table1");

        // Loop through rows
        for (int i = 0; i < rows.size(); i++) {
            Row excelRow = sheet.createRow(i);
            List<WebElement> cells = rows.get(i).findElements(By.tagName("th"));
            if (cells.isEmpty()) {
                cells = rows.get(i).findElements(By.tagName("td"));
            }

            for (int j = 0; j < cells.size(); j++) {
                Cell excelCell = excelRow.createCell(j);
                excelCell.setCellValue(cells.get(j).getText());
            }
        }

        // Write to Excel file
        String filePath = "Table1.xlsx";
        FileOutputStream fileOut = new FileOutputStream(filePath);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();

        logger.info("Table 1 data has been written to " + filePath);
    }
}
