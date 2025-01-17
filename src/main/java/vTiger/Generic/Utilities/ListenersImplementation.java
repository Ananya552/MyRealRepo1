package vTiger.Generic.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
/*
 * THIS CLASS WILL PROVIDE IMPLEMENTATIONS TO ITestListener INTERFACE.
 */
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		System.out.println(methodName+"---Test script execution started.---");
		//CREATE A TEST IN EXTENT REPORT.
		test= report.createTest(methodName);
		}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName= result.getMethod().getMethodName();
		test.log(Status.PASS,methodName+"---PASS---");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriverUtility2 wUtil = new WebDriverUtility2();
		JavaUtility2 jUtil = new JavaUtility2();
		String methodName= result.getMethod().getMethodName();
		String screenShotName = methodName+jUtil.getSystemdate(); 
		test.log(Status.FAIL,methodName+"---FAIL---");
		test.log(Status.INFO,result.getThrowable());
		try {
		String path = wUtil.captureScreenshot(BaseClass.sdriver, screenShotName);
		test.addScreenCaptureFromBase64String(path);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		test.log(Status.SKIP,methodName+"---SKIP---");
		test.log(Status.INFO,result.getThrowable());
	}
	
//For the following two consecutive methods, no implementation ma'am has done yet.
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
    @Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("---Suite execution started.---");
//		USAGE OF EXTENTSPARKREPORTER CLASS.
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReports\\Report"+ new JavaUtility2().getSystemdate()+".html");
        htmlreport.config().setDocumentTitle("VTiger Execution Report");
        htmlreport.config().setReportName("Automation Execution Report");
        htmlreport.config().setTheme(Theme.DARK);
        
        //USAGE OF EXTENTREPORTS CLASS.
        report= new ExtentReports();
        report.attachReporter(htmlreport);
        report.setSystemInfo("Base platform","Windows");
        report.setSystemInfo("Base browser","Chrome");
        report.setSystemInfo("Base URL","https://localhost:8888");
        report.setSystemInfo("Base Environment", "Testing");
        report.setSystemInfo("Reporter name","Ananya");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("---Suite execution finished.---");
		//GENERATE THE REPORT AFTER EXECUTION.
		report.flush();
		}
	
}
