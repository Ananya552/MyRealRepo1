package vTiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile2 {
	public static void main(String[] args) throws Throwable {
		// STEP-1-OPEN THE FILE IN JAVA READABLE FORMAT
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData2.xlsx");
		// STEP-2-CREATE A WORKBOOK
		Workbook wb = WorkbookFactory.create(fis);
		// STEP-3-NAVIGATE TO REQUIRED SHEET
		Sheet sh = wb.getSheet("Sheet1");
		// STEP-4-NAVIGATE TO REQUIRED ROW
		Row rw = sh.getRow(1);
		// STEP-5-NAVIGATE TO REQUIRED CELL
		Cell cl = rw.getCell(2);
		String val = cl.getStringCellValue();
		// STEP-6-READ THE DATA INSIDE THE CELL
		System.out.println(val);
		//STEP-7-CLOSE THE WORKBOOK TO AVOID DATA LEAKAGE
		wb.close();
	}
}
