package vTiger.TestNG.programs;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.Generic.Utilities.BaseClass;
import vTiger.POM.classes.CreateNewOrgPage;
import vTiger.POM.classes.HomePage;
import vTiger.POM.classes.OrganisationInfoPage;
import vTiger.POM.classes.OrganisationsPage;

@Listeners(vTiger.Generic.Utilities.ListenersImplementation.class)
public class ListenersCreateOrgWithIndTest extends BaseClass{
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
		//Assert.fail();
		OrganisationInfoPage oip = new OrganisationInfoPage(d);
		String orgCreated = oip.orgHeaderText();
		Assert.assertTrue((orgCreated.contains(ORGNAME)));
		//Assert.fail();
		System.out.println(ORGNAME);
	}
}
