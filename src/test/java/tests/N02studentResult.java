package tests;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class N02studentResult extends TestBase {
    @Test
    void addGrades() throws IOException {
        Path filePath = Path.of("./resources/TestData02.xlsx");


        FileInputStream fis = new FileInputStream(filePath.toFile());
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);
        fis.close();


        sheet.getRow(0).createCell(2).setCellValue("Grade");


        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            int score = (int) row.getCell(1).getNumericCellValue();
            row.createCell(2).setCellValue(getGrade(score));
        }

        FileOutputStream fos = new FileOutputStream(filePath.toFile());
        workbook.write(fos);
        fos.close();
        workbook.close();
    }

    private String getGrade(int score) {
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }
}
