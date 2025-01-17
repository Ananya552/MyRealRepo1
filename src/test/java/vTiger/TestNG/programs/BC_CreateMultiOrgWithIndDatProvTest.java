package vTiger.TestNG.programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

public class BC_CreateMultiOrgWithIndDatProvTest extends BaseClass {
	
	@Test(dataProvider = "getData")
	public void bc_createOrgWithIndDataProviderTest(String ORGNAME,String INDUSTRYNAME) throws Throwable {
		 String ORGNAMEFinal= ORGNAME+jUtil.getRandomNumber();
		HomePage hp = new HomePage(d);
		hp.clickOnOrganisations();
		OrganisationsPage op = new OrganisationsPage(d);
		op.clickOnOrgLookUpImg();
		CreateNewOrgPage cnop = new CreateNewOrgPage(d);
		cnop.createNewOrgWithInd(ORGNAMEFinal, INDUSTRYNAME);
		OrganisationInfoPage oip = new OrganisationInfoPage(d);
		String orgCreated = oip.orgHeaderText();
		Assert.assertTrue(orgCreated.contains(ORGNAMEFinal));
		System.out.println(ORGNAMEFinal);
		}
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		Object[][] data = eUtil.readMultipleDataFromExcel("Sheet4");
		return data;
	}
}
