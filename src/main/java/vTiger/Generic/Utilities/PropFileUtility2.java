package vTiger.Generic.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
/**
 * @author Ananya
 * THIS CLASS CONSISTS OF REUSABLE METHODS RELATED TO PROPERTY FILE.
 */
public class PropFileUtility2 {
	/**
	 * THIS METHOD WILL READ DATA FROM A PROPERTY FILE.
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
	public String readDataFromPropFile(String key) throws Throwable{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData3.properties");
		Properties p = new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}
 
}
