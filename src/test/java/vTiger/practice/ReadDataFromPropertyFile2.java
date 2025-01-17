package vTiger.practice;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile2 {
	public static void main(String[] args) throws Throwable {
		// Open the document in Java readable format
		FileInputStream f = new FileInputStream(".\\src\\test\\resources\\CommonData3.properties");
		
		// Create an object of 'Properties' class
		Properties p = new Properties();
		
		// Load the document into 'Properties' class
		p.load(f);
		
		// Provide the key and read the value
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");

		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
	}
}
