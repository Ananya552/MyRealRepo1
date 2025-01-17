package vTiger.practice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithInd {
public static void main(String[] args) {
	//Step-1-LAUNCH THE BROWSER
	WebDriverManager.chromedriver().setup();
	WebDriver d = new ChromeDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	d.get("http://localhost:8888");
	d.manage().window().maximize();
	//Step-2-LOG IN TO THE APPLICATION
	d.findElement(By.name("user_name")).sendKeys("admin");
	d.findElement(By.name("user_password")).sendKeys("admin");
	d.findElement(By.id("submitButton")).click();
	//Step-3-NAVIGATE TO ORGANISATIONS LINK
	d.findElement(By.xpath("//td[@align='center']/a[text()='Organizations']")).click();
	//Step-4-CLICK ON CREATE ORGANISATION LOOK UP IMAGE
	d.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	//Step-5-CREATE ORGANISATION WITH MANDATORY INFORMATIONS
	d.findElement(By.name("accountname")).sendKeys("Biriyani71");
	//Step-6-SELECT CHEMICALS FROM THE INDUSTRY DROPDOWN
	WebElement d2 = d.findElement(By.name("industry"));
	Select d3 = new Select(d2);
	d3.selectByValue("Chemicals");
	//Step-7-SAVE 
	d.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//Step-8-VALIDATE
	String orgName= d.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(orgName.contains("Biriyani71")) {
		System.out.println("PASS");
		System.out.println(orgName);
	}
	else System.out.println("Fail");
	//Step-9-LOG OUT OF THE APPLICATION 
	WebElement d4 = d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG"));
	Actions act = new Actions(d);
	act.moveToElement(d4).perform();
	d.findElement(By.xpath("//a[text()='Sign Out']")).click();	
	//Step-10-CLOSE THE BROWSER
	d.quit();
	}
}
