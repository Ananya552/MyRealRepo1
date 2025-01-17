package vTiger.TestNG.programs;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionPr1 {
	@Test(invocationCount = 3)
public void methR() {
	System.out.println("Hello!");
	Assert.fail();
}
}
