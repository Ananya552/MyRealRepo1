package vTiger.practice;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelSheet2 {
public static void main(String[] args) throws Throwable {
	//OPEN THE DOCUMENT IN JAVA READABLE FORMAT.
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData2.xlsx");
	//CREATE A WORKBOOK.
	Workbook wb = WorkbookFactory.create(fis);
	//CREATE A SHEET
	Sheet sh = wb.createSheet("Sheet3");
	//CREATE A ROW
	Row rw =sh.createRow(0);
	//CREATE A CELL
	Cell cl = rw.createCell(1);
	//PROVIDE DATA
	cl.setCellValue("Happy");
	//OPEN THE DOCUMENT IN JAVA WRITABLE FORMAT
	FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData2.xlsx");
	//DATA IS WRITTEN
	wb.write(fos);
	
	System.out.println("Data added successfully.");
	//CLOSE THE WORKBOOK TO AVOID DATA LEAKAGE
	wb.close();
}
}
