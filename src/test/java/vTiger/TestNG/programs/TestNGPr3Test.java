package vTiger.TestNG.programs;

import org.testng.annotations.Test;

public class TestNGPr3Test {
	@Test
	public void createCust() {
		System.out.println("Create a customer.");
	}
	@Test
	public void modifyCust() {
		System.out.println("Modify the customer.");
	}
	@Test
	public void deleteCust() {
		System.out.println("Delete the customer.");//PRIORITY'S DEFAULT VALUE IS ZERO.
	}
	@Test
	public void daammy() {
		System.out.println("Method aammy.");
	}
}
