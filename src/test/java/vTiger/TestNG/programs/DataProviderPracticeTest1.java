package vTiger.TestNG.programs;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPracticeTest1 {
	@Test(dataProvider = "getData")
	public void addProductToCart1(String name, String model, int price) {
		System.out.println(name + "-" + model + "-" + price);
	}

	@Test(dataProvider = "getInfo")
	public void addProductToCart2(String name, String model) {
		System.out.println(name + "-" + model);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[4][3];// 4 SETS OF DATA WITH 3 DIFFERENT FIELDS.

		data[0][0] = "Samsung";
		data[0][1] = "S24";
		data[0][2] = 75000;

		data[1][0] = "Redmi";
		data[1][1] = "R10";
		data[1][2] = 65000;

		data[2][0] = "Honor";
		data[2][1] = "H14";
		data[2][2] = 55000;

		data[3][0] = "Iphone";
		data[3][1] = "I18";
		data[3][2] = 85000;

		return data;
	}

	@DataProvider
	public Object[][] getInfo() {
		Object[][] data = new Object[2][2];// 2 SETS OF DATA WITH 2 DIFFERENT FIELDS.

		data[0][0] = "Motorola";
		data[0][1] = "M24";

		data[1][0] = "LG";
		data[1][1] = "L20";

		return data;
	}
}
