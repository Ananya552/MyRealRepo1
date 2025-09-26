package vTiger.TestNG.programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.Generic.Utilities.BaseClass;
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

//In groups,array of Strings can also be written.
public class BC_CreateContactWithOrgTest extends BaseClass {
	@Test(groups ="testngBatch")
	public void bc_createContactWithOrgTest() throws Throwable {

		String ORGNAME = eUtil.readDataFromExcelFile("Sheet1", 4, 2) + jUtil.getRandomNumber();// Cipla
		String INDUSTRYNAME = eUtil.readDataFromExcelFile("Sheet1", 4, 3);// Chemicals
		String LASTNAME = eUtil.readDataFromExcelFile("Sheet2", 1, 2);// Anmol

		HomePage hp = new HomePage(d);
		hp.clickOnOrganisations();
		OrganisationsPage op = new OrganisationsPage(d);
		op.clickOnOrgLookUpImg();
		CreateNewOrgPage cnop = new CreateNewOrgPage(d);
		cnop.createNewOrgWithInd(ORGNAME, INDUSTRYNAME);
		OrganisationInfoPage oip = new OrganisationInfoPage(d);
		String orgCreated = oip.orgHeaderText();
		Assert.assertTrue(orgCreated.contains(ORGNAME));
		System.out.println(ORGNAME);
		hp.clickOnContact();
		ContactsPage cp = new ContactsPage(d);
		cp.clickOnCreateContact();
		CreateNewContactPage cncp = new CreateNewContactPage(d);
		cncp.createNewContact(LASTNAME, ORGNAME, d);
		ContactInfoPage cip = new ContactInfoPage(d);
		String contactCreated = cip.ContactHeaderText();
		Assert.assertTrue(contactCreated.contains(LASTNAME));
		System.out.println(contactCreated);
	}
}
