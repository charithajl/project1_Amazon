package utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersLogic implements ITestListener{
	public static  WebDriver driver;
	//public static String format2;
	public String dateformat()
	{
		Date d1 = new Date();  // non parameterized constructor
 	 		
 		Date d2 = new Date(d1.getTime());// parameterized constructor
 		String format1 = d2.toString();
 		
 		String date = format1.substring(8, 10);
 		String month = format1.substring(4, 7);
 		String year = format1.substring(format1.length()-4);
 		String hour = format1.substring(11, 13);
 		String min = format1.substring(14, 16);
 		
 		String format2 = date.concat(month).concat(year)  .concat(hour) .concat(min); 
 		return format2;
	}
	
	public void screenshot(String dir)
	{
		String format2 = dateformat();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(dir+format2+".png");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		Reporter.log("Testcase is pass- Listeners logic is started");
		String path = "C:\\Users\\admin\\eclipse-workspace1\\project1_Amazon\\src\\test\\java\\screenshots\\pass\\TestCasePass";
		screenshot(path);
		Reporter.log("Screenshot is completed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		Reporter.log("Testcase is fail- Listeners logic is started");
		String path = "C:\\Users\\admin\\eclipse-workspace1\\project1_Amazon\\src\\test\\java\\screenshots\\fail\\TestCaseFail";
		screenshot(path);
		Reporter.log("Screenshot is completed");
	}
	
	

}
