package vTiger.Generic.Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * THIS CLASS PROVIDES IMPLEMENTATION TO IRetryAnalyzer INTERFACE of TestNG.
 * @author Ananya
 */
public class IRetryAnalyserImpl implements IRetryAnalyzer {
	int count = 1;
	int retryCount = 2;

	@Override
	public boolean retry(ITestResult result) {
		while (count <= retryCount) 
		{
			count++;
			System.out.println("All is well.");
			return true;
		}
		System.out.println("Outside while");
		return false;
	}

}
