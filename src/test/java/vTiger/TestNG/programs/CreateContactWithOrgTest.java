package vTiger.TestNG.programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.Generic.Utilities.ExcelFileUtility2;
import vTiger.Generic.Utilities.JavaUtility2;
import vTiger.Generic.Utilities.PropFileUtility2;
import vTiger.Generic.Utilities.WebDriverUtility2;
import vTiger.POM.classes.ContactInfoPage;
import vTiger.POM.classes.ContactsPage;
import vTiger.POM.classes.CreateNewContactPage;
import vTiger.POM.classes.CreateNewOrgPage;
import vTiger.POM.classes.HomePage;
import vTiger.POM.classes.LoginPage;
import vTiger.POM.classes.OrganisationInfoPage;
import vTiger.POM.classes.OrganisationsPage;

@Test
public class CreateContactWithOrgTest {
	@Test
	public void createContactWithOrgTest() throws Throwable {
		WebDriver d = null;
		ExcelFileUtility2 eUtil = new ExcelFileUtility2();
		JavaUtility2 jUtil = new JavaUtility2();
		PropFileUtility2 pUtil = new PropFileUtility2();
		WebDriverUtility2 wUtil= new WebDriverUtility2();
		
	    String BROWSER = pUtil.readDataFromPropFile("browser");
		String URL = pUtil.readDataFromPropFile("url");
		String USERNAME = pUtil.readDataFromPropFile("username");
		String PASSWORD = pUtil.readDataFromPropFile("password");
		String ORGNAME = eUtil.readDataFromExcelFile("Sheet1", 4, 2) + jUtil.getRandomNumber();// Cipla
		String INDUSTRYNAME = eUtil.readDataFromExcelFile("Sheet1", 4, 3);// Chemicals
		String LASTNAME = eUtil.readDataFromExcelFile("Sheet2", 1, 2);//Anmol
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			d = new ChromeDriver();
		} else
			System.out.println("Invalid browser name.");
		d.get(URL);
		wUtil.maximizeWindow(d);
		wUtil.waitForPageLoading(d);
		LoginPage lp = new LoginPage(d);
		lp.loginToApp(USERNAME, PASSWORD);
		HomePage hp = new HomePage(d);
		hp.clickOnOrganisations();
		OrganisationsPage op = new OrganisationsPage(d);
		op.clickOnOrgLookUpImg();
		CreateNewOrgPage cnop = new CreateNewOrgPage(d);
		cnop.createNewOrgWithInd(ORGNAME, INDUSTRYNAME);
		OrganisationInfoPage oip = new OrganisationInfoPage(d);
		String orgCreated = oip.orgHeaderText();
		if (orgCreated.contains(ORGNAME)) {
			System.out.println("PASS");
			System.out.println(ORGNAME);
		} else
			System.out.println("Fail");

		hp.clickOnContact();
		ContactsPage cp = new ContactsPage(d);
		cp.clickOnCreateContact();
		CreateNewContactPage cncp = new CreateNewContactPage(d);
		cncp.createNewContact(LASTNAME, ORGNAME, d);
		ContactInfoPage cip = new ContactInfoPage(d);
		String contactCreated = cip.ContactHeaderText();	
		if(contactCreated.contains(LASTNAME)) {
			System.out.println("PASS");
			System.out.println(contactCreated);
		}
		else System.out.println("FAIL");
		hp.logOut(d);
		d.close();
		
	}
}
