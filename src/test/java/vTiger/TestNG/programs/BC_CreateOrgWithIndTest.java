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
import vTiger.POM.classes.CreateNewOrgPage;
import vTiger.POM.classes.HomePage;
import vTiger.POM.classes.LoginPage;
import vTiger.POM.classes.OrganisationInfoPage;
import vTiger.POM.classes.OrganisationsPage;

//@Test(groups={"SmokeSuite","RegressionSuite"})//In groups,array of Strings can also be written.
//@Test(alwaysRun = true)
public class BC_CreateOrgWithIndTest extends BaseClass{
	@Test
	public void bc_createOrgWithIndTest() throws Throwable {
		
        String ORGNAME = eUtil.readDataFromExcelFile("Sheet1", 4, 2) + jUtil.getRandomNumber();// Cipla
		String INDUSTRYNAME = eUtil.readDataFromExcelFile("Sheet1", 4, 3);// Chemicals
		
		HomePage hp = new HomePage(d);
		hp.clickOnOrganisations();
		OrganisationsPage op = new OrganisationsPage(d);
		op.clickOnOrgLookUpImg();
		CreateNewOrgPage cnop = new CreateNewOrgPage(d);
		cnop.createNewOrgWithInd(ORGNAME, INDUSTRYNAME);
		OrganisationInfoPage oip = new OrganisationInfoPage(d);
		String orgCreated = oip.orgHeaderText();
		Assert.assertTrue((orgCreated.contains(ORGNAME)));
		System.out.println(ORGNAME);
	}
//	@Test(alwaysRun = true)
//	public void demo() {
//		System.out.println("demo");
//	}
}
