package vTiger.TestNG.programs;

import org.testng.Assert;
import org.testng.annotations.Test;


public class IRetryanalyserPr1 {
	@Test(retryAnalyzer = vTiger.Generic.Utilities.IRetryAnalyserImpl.class)
	public void meth1() {
		System.out.println("Hello");
		Assert.fail();
	}
}
