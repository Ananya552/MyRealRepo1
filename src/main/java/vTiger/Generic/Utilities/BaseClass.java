package vTiger.Generic.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.Generic.Utilities.ExcelFileUtility2;
import vTiger.Generic.Utilities.JavaUtility2;
import vTiger.Generic.Utilities.PropFileUtility2;
import vTiger.Generic.Utilities.WebDriverUtility2;
import vTiger.POM.classes.HomePage;
import vTiger.POM.classes.LoginPage;
/*
 * THIS CLASS CONSISTS OF ALL BASIC CONFIGURATIONS.
 */
public class BaseClass {
	public JavaUtility2 jUtil = new JavaUtility2();
	public PropFileUtility2 pUtil = new PropFileUtility2();
	public ExcelFileUtility2 eUtil = new ExcelFileUtility2();
	public WebDriverUtility2 wUtil = new WebDriverUtility2();
	public WebDriver d =null;
	public static WebDriver sdriver = null; 
@BeforeSuite(alwaysRun = true)
public void bsConfig() {
	System.out.println("======Database connection successful.======");
}
@AfterSuite(alwaysRun = true)
public void asConfig() {
	
	System.out.println("======Database connection closed.======");
}
//@Parameters("browser")
//@BeforeTest
@BeforeClass(alwaysRun = true)
public void bcConfig() throws Throwable {
	String BROWSER = pUtil.readDataFromPropFile("browser");
	String URL = pUtil.readDataFromPropFile("url");
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
	}
	else if (BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		d = new FirefoxDriver();
	}
	else if(BROWSER.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		d = new EdgeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("safari"))
	{
		WebDriverManager.edgedriver().setup();
		d = new SafariDriver();
	}
	else System.out.println("Invalid browser name");
	d.get(URL);
	wUtil.maximizeWindow(d);
	wUtil.waitForPageLoading(d);
	System.out.println("===Browser launched===");
	sdriver=d;
}

//@AfterTest
@AfterClass(alwaysRun = true)
public void acConfig() {
	d.close();
	System.out.println("===Browser closed.===");
}
@BeforeMethod(alwaysRun = true)
public void bmConfig() throws Throwable {
	String USERNAME = pUtil.readDataFromPropFile("username");
	String PASSWORD = pUtil.readDataFromPropFile("password");
	LoginPage lp = new LoginPage(d);
	lp.loginToApp(USERNAME,PASSWORD);
	System.out.println("===Login successful.===");
}
@AfterMethod(alwaysRun = true)
public void amConfig() throws Throwable {
	HomePage hp = new HomePage(d);
	hp.logOut(d);
	System.out.println("===Logout successful.===");
}
//@Test
//public void sampleTestMethod() {
//	System.out.println("===Just a sample TestNG method.===");
//}
}
