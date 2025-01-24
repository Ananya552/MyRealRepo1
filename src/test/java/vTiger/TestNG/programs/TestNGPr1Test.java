package vTiger.TestNG.programs;

import org.testng.annotations.Test;


public class TestNGPr1Test {
	@Test(priority=-2,invocationCount=2)
	public void createCust() {
		System.out.println("Create a customer.");
	}
	@Test(priority=-1)
	public void modifyCust() {
		System.out.println("Modify the customer.");
	}
	@Test
	public void deleteCust() {
		System.out.println("Delete the customer.");//PRIORITY'S DEFAULT VALUE IS ZERO.
	}
	@Test(enabled=true)
	public void aammy() {
		System.out.println("I am method aammy.");
	}
}

