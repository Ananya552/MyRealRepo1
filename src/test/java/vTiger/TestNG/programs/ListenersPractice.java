package vTiger.TestNG.programs;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(vTiger.Generic.Utilities.ListenersImplementation.class)
public class ListenersPractice {
	
	@Test
	public void demo1() {
		Assert.fail();
		System.out.println("demo");
	}
	
	@Test(dependsOnMethods="demo1")
	public void demo2() {
		System.out.println("demo");
	}
}
