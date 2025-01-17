package vTiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithIndDDT2 {
	public static void main(String[] args) throws Throwable {
		WebDriver d = null;
		Random r = new Random();
		int random = r.nextInt(300,400);
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\CommonData3.properties");
		Properties p = new Properties();
		p.load(fis1);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		FileInputStream fis2 = new FileInputStream(".\\src\\test\\resources\\TestData2.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		String ORGNAME = wb.getSheet("Sheet1").getRow(4).getCell(2).getStringCellValue();
		String INDUSTRYTYPE = wb.getSheet("Sheet1").getRow(4).getCell(3).getStringCellValue();
		wb.close();
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			d = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			d = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			d = new EdgeDriver();
		}
		d.get(URL);
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().window().maximize();
		d.findElement(By.name("user_name")).sendKeys(USERNAME);
		d.findElement(By.name("user_password")).sendKeys(PASSWORD);
		d.findElement(By.id("submitButton")).click();
		d.findElement(By.xpath("//td[@align='center']/a[text()='Organizations']")).click();
		d.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		d.findElement(By.name("accountname")).sendKeys(ORGNAME+random);
		WebElement d2 = d.findElement(By.name("industry"));
		Select sl= new Select(d2);
		sl.selectByValue(INDUSTRYTYPE);
		d.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String orgName= d.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (orgName.contains(ORGNAME)) {
			System.out.println("PASS");
			System.out.println(orgName);
		}
		else System.out.println("FAIL");
		WebElement d3 = d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(d);
		act.moveToElement(d3).perform();
		d.findElement(By.xpath("//a[.='Sign Out']")).click();
		Thread.sleep(1000);
//		d.close();
		d.quit();
		
	}
}
