package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.IOException;
import java.io.InputStream;

public class ExcelUtils {

    private Sheet sheet;

    public ExcelUtils(String excelFileNameOnClasspath, String sheetName) {
        try {
            // Load Excel from src/test/resources via classpath
            InputStream is = ExcelUtils.class
                    .getClassLoader()
                    .getResourceAsStream(excelFileNameOnClasspath);

            if (is == null) {
                throw new RuntimeException("Excel file not found on classpath: " + excelFileNameOnClasspath);
            }

            Workbook workbook = WorkbookFactory.create(is);
            sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet not found in Excel: " + sheetName);
            }

        } catch (IOException e) {
            throw new RuntimeException("Unable to read Excel file: " + excelFileNameOnClasspath, e);
        }
    }

    public String getCellData(int row, int col) {
        return sheet.getRow(row).getCell(col).getStringCellValue();
    }
}
