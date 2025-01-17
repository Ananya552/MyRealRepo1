package vTiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test
public class HardAssertPr1 {
@Test
public void test1() {
System.out.println("First line");	
Assert.assertEquals('b','a');
System.out.println("Second line");
}
//SoftAssert implementation.
@Test
public void test2() {
	SoftAssert sa = new SoftAssert();
	System.out.println("Step1");
	sa.assertEquals(true,false);
	System.out.println("Step2");
	System.out.println("Step3");
	sa.assertAll();
	System.out.println("Step4");
	Assert.fail();
}
}
