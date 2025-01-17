package vTiger.TestNG.programs;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vTiger.Generic.Utilities.ExcelFileUtility2;

public class DataProviderPracticeTest2 {
	
	ExcelFileUtility2 eUtil = new ExcelFileUtility2();
	@Test(dataProvider = "getData")
	public void createMultiOrgTest(String Orgname, String IndustryName) {
		System.out.println(Orgname+ "-" + IndustryName);
	}
	
	@DataProvider
    public Object[][] getData() throws Throwable{
	Object data[][] = eUtil.readMultipleDataFromExcel("Sheet4");//4,2[3,1][1,0,1,1,2,0,2,1,3,0,3,1]
	return data;
    }
}
