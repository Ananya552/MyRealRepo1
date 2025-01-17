package vTiger.practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrg2 {
public static void main(String[] args) {
	//Step-1-LAUNCH THE BROWSER
	WebDriverManager.chromedriver().setup();
	WebDriver d = new ChromeDriver();
	d.manage().window().maximize();
	d.get("http://localhost:8888");
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//Step-2-LOGIN TO THE APPLICATION
	d.findElement(By.name("user_name")).sendKeys("admin");
	d.findElement(By.name("user_password")).sendKeys("admin");
	d.findElement(By.id("submitButton")).click();
	//Step-3-CLICK ON CONTACTS LINK
	d.findElement(By.linkText("Contacts")).click();
	//Step-4-CLICK ON CREATE CONTACT LOOK UP IMAGE
	d.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	//Step-5-CREATE CONTACT WITH MANDATORY FIELDS
	d.findElement(By.name("lastname")).sendKeys("Spiderman399");
	//Step-6-CLICK ON ORGANISATION LOOK UP IMAGE
	d.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
	//NOW SWITCH THE DRIVER'S FOCUS TO THE CHILD WINDOW
	
	String mainWinID= d.getWindowHandle();
	System.out.println(mainWinID);
	String mainWinId=d.getWindowHandle();
	Set<String>allWinIDs=d.getWindowHandles();
	for(String ID : allWinIDs) {
		if(!ID.equals(mainWinId)) {
			d.switchTo().window(ID);
			System.out.println(ID);
			System.out.println("Control switched to child window.");
		}
	}
	//SEARCH FOR THE REQUIRED ORGANISATION
	d.findElement(By.xpath("//input[@name='search_text']")).sendKeys("Biriyani71");
	d.findElement(By.xpath("//input[@name='search']")).click();
	d.findElement(By.xpath("//a[text()='PizzaNow123']")).click();
	//NOW SWITCH THE DRIVER'S FOCUS TO THE MAIN WINDOW
	System.out.println("Control switched to main window.");
	d.switchTo().window(mainWinId);
	//Step-7-SAVE
	d.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//Step-8-VALIDATE
	String contctInfoHeaderText= d.findElement(By.xpath("//table[@align='center']/descendant::span[@class='dvHeaderText']")).getText();
	if(contctInfoHeaderText.contains("Spiderman")) {
		System.out.println("PASS");
		System.out.println(contctInfoHeaderText);
	}
	else System.out.println("Fail");
	//Step-9-LOG OUT OF THE APPLICATION
	WebElement d4 = d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act = new Actions(d);
	act.moveToElement(d4).perform();
	d.findElement(By.xpath("//a[text()='Sign Out']")).click();	
	//Step-10-CLOSE THE BROWSER
	d.quit();
}
}
