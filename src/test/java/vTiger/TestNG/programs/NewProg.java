package vTiger.TestNG.programs;

import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class NewProg {
public static void main(String[] args) throws Throwable {
	readMultipleDataFromExcel("Sheet4");
}
public static Object[][] readMultipleDataFromExcel(String sheetName) throws Throwable {
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData2.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	int lastRow = sh.getLastRowNum();//3
	int lastCell = sh.getRow(0).getLastCellNum();//2
	System.out.println(lastRow + " and "+ lastCell);
	Object[][] data = new Object[lastRow][lastCell];
	for (int i = 0; i < lastRow; i++) {
		for (int j = 0; j < lastCell; j++) {
			data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	System.out.println(Arrays.deepToString(data));
	return data;
}
}
