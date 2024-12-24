

// ===========================================================================================================================

package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelReader {
 
    private Workbook workbook;
 
    public ExcelReader() {
        String filePath = ReadProperties.excelFilePath();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            workbook = new XSSFWorkbook(fis); // Open the Excel file
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while reading the Excel file: " + filePath);
            throw new RuntimeException("Failed to load the Excel file: " + filePath, e);
        }
    }
 
//    private String getExcelFilePathFromProperties() {
//        Properties properties = new Properties();
//        try (FileInputStream fis = new FileInputStream("src\\test\\java\\com\\parameters\\home.properties")) {
//            properties.load(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to load the properties file.", e);
//        }
//        return properties.getProperty("excelFilePath");
//    }
 
    public String readData(String sheetName, int rowNum, int colNum) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            return "Sheet not found!";
        }
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            return "Row not found!";
        }
        Cell cell = row.getCell(colNum);
        if (cell == null) {
            return "Cell not found!";
        }
        return cell.toString();
    }
    
//    public List<String[]> getAllRows(String sheetName) {
//        List<String[]> rows = new ArrayList<>();
//        Sheet sheet = workbook.getSheet(sheetName);
//        if (sheet == null) {
//            throw new RuntimeException("Sheet not found: " + sheetName);
//        }
//
//        for (Row row : sheet) {
//            List<String> rowData = new ArrayList<>();
//            for (Cell cell : row) {
//                rowData.add(cell.toString());
//            }
//            rows.add(rowData.toArray(new String[0]));
//        }
//        return rows;
//    }
 
    public void close() {
        try {
            if (workbook != null) {
                workbook.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}