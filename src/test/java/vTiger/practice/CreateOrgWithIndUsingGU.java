package vTiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.Generic.Utilities.ExcelFileUtility2;
import vTiger.Generic.Utilities.JavaUtility2;
import vTiger.Generic.Utilities.PropFileUtility2;
import vTiger.Generic.Utilities.WebDriverUtility2;

public class CreateOrgWithIndUsingGU {
	public static void main(String[] args) throws Throwable {
		WebDriver d = null;
		// Create objects for all utility classes.
		ExcelFileUtility2 eUtil = new ExcelFileUtility2();
		JavaUtility2 jUtil = new JavaUtility2();
		PropFileUtility2 pUtil = new PropFileUtility2();
		WebDriverUtility2 wUtil = new WebDriverUtility2();

		// FETCH ALL THE DATA REQUIRED.
		String BROWSER = pUtil.readDataFromPropFile("browser");
		String URL = pUtil.readDataFromPropFile("url");
		String USERNAME = pUtil.readDataFromPropFile("username");
		String PASSWORD = pUtil.readDataFromPropFile("password");

		String ORGNAME = eUtil.readDataFromExcelFile("Sheet1", 4, 2) + jUtil.getRandomNumber();
		String INDUSTRYTYPE = eUtil.readDataFromExcelFile("Sheet1", 4, 3);
		
		// LAUNCH THE BROWSER.
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			d = new ChromeDriver();
		}
		d.get(URL);
		wUtil.maximizeWindow(d);
		wUtil.waitForPageLoading(d);
		d.findElement(By.name("user_name")).sendKeys(USERNAME);
		d.findElement(By.name("user_password")).sendKeys(PASSWORD);
		d.findElement(By.id("submitButton")).click();
		d.findElement(By.xpath("//td[@align='center']/a[text()='Organizations']")).click();
		d.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		d.findElement(By.name("accountname")).sendKeys(ORGNAME);
		WebElement d2 = d.findElement(By.name("industry"));
		wUtil.handleDropdown(d2, INDUSTRYTYPE);
		d.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String orgHeader = d.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (orgHeader.contains(ORGNAME)) {
			System.out.println("PASS");
			System.out.println(orgHeader);
		} else
			System.out.println("FAIL");
		WebElement d3 = d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(d, d3);
		d.findElement(By.xpath("//a[.='Sign Out']")).click();
		Thread.sleep(1000);
		d.quit();

	}
}
