package vTiger.TestNG.programs;

import org.testng.annotations.Test;

public class ReadDataFromCmdLineTest {
@Test
public void readDataTest() {
	
	String BROWSER=System.getProperty("browser");
	String URL=System.getProperty("url");
	
	System.out.println(BROWSER);
	System.out.println(URL);
}
}
