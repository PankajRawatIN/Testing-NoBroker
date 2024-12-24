package com.parameters;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    

    // Constructor to initialize with a manually provided file path

    // Method to get cell data based on row and column from the first sheet
    public static String getCellValue(int rowNum, int colNum) throws IOException  {
    	String excelFilePath = "src/test/resources/ExcelData/NoBrokerExcel.xlsx";
        FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0); // Default to the first sheet
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            return ""; // Return empty if row is null
        }
        Cell cell = row.getCell(colNum);
        if (cell == null) {
            return ""; // Return empty if cell is null
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((long) cell.getNumericCellValue()); // Convert numeric to String
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }   
}


