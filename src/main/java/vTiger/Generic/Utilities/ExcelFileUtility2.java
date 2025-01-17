package vTiger.Generic.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Ananya THIS CLASS CONSISTS OF REUSABLE METHODS RELATED TO EXCEL FILE.
 */
public class ExcelFileUtility2 {
	/**
	 * @author Ananya THIS METHOD WILL READ DATA FROM AN EXCEL FILE.
	 * @param sheet
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcelFile(String sheet, int rowNum, int celNum) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}

	/**
	 * @author Ananya THIS METHOD WILL WRITE DATA INTO AN EXCEL FILE.
	 * @param sheet
	 * @param rowNum
	 * @param celNum
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataIntoExcelFile(String sheet, int rowNum, int celNum, String value) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.createSheet(sheet).createRow(rowNum).createCell(celNum).setCellValue(value);
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData2.xlsx");
		wb.write(fos);
		wb.close();
	}
	/**
	 * THIS METHOD WILL READ MULTIPLE DATA FROM THE SHEET PROVIDED.
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMultipleDataFromExcel(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();//3
		int lastCell = sh.getRow(0).getLastCellNum();//2
		Object[][] data = new Object[lastRow][lastCell];
		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		wb.close();
		return data;
	}
}



