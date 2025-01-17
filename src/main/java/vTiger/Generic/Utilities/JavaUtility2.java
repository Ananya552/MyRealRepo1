package vTiger.Generic.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * THIS CLASS CONSISTS OF REUSABLE METHODS RELATED TO JAVA.
 */
public class JavaUtility2 {
	/**
	 * THIS METHOD WILL RETURN A RANDOM NUMBER FOR EVERY EXECUTION.
	 * @return
	 */
public int getRandomNumber() {
	Random r = new Random();
	return r.nextInt(500,5000);
}
/**
 * THIS METHOD WILL GENERATE THE CURRENT SYSYTEM DATE IN THE SPECIFIED FORMAT.
 * @return
 */
public String getSystemdate() {
	Date d = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
    String data= formatter.format(d);
	return data;
}

}
