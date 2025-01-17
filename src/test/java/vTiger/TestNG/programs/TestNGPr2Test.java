package vTiger.TestNG.programs;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPr2Test {
	@Test
	public void createCust() {
		Assert.fail();
		System.out.println("Create a customer.");
	}
	@Test(dependsOnMethods = "createCust")
	public void modifyCust() {
		System.out.println("Modify the customer.");
	}
	@Test(dependsOnMethods = {"createCust","modifyCust"})
	public void deleteCust() {
		System.out.println("Delete the customer.");//PRIORITY'S DEFAULT VALUE IS ZERO.
	}
	@Test(enabled=true)
	public void aammy() {
		System.out.println("Method aammy.");
	}
}
