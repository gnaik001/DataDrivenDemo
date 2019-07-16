package com.reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class ReportGenerator {

	static ExtentReports extentReports;
	static ExtentTest test;
	
	public static void startTestSuite(String filePath,String userName)
	{
		extentReports = new ExtentReports(filePath, NetworkMode.OFFLINE);
		
		extentReports.addSystemInfo("OS", System.getProperty("os.name"))
					.addSystemInfo("Environment", "QA")
					.addSystemInfo("User", userName);
				
	}
	
	public static void endTestSuite()
	{
		extentReports.flush();
		extentReports.close();
	}
	
	public static void startTestCase(String testName,String description)
	{
		
		test = extentReports.startTest(testName,description);
	
	}
	
	public static void endTestCase()
	{
		extentReports.endTest(test);
	}
	
	public static void stepDetails(String status,String stepName,String stepDetails,String imagePath)
	{
		String details = stepDetails +"<br />"+ test.addScreenCapture(imagePath); 
		
		if(status.equalsIgnoreCase("PASS"))
		{
			test.log(LogStatus.PASS, stepName, details);
		}
		else if(status.equalsIgnoreCase("FAIL"))
		{
			test.log(LogStatus.FAIL, stepName, details);
		} 
		else if(status.equalsIgnoreCase("SKIP"))
		{
			test.log(LogStatus.SKIP, stepName, details);
		}
		else if(status.equalsIgnoreCase("ERROR"))
		{
			test.log(LogStatus.ERROR, stepName, details);
		}
		else if(status.equalsIgnoreCase("FATAL"))
		{
			test.log(LogStatus.FATAL, stepName, details);
		}
		else if(status.equalsIgnoreCase("WARNING"))
		{
			test.log(LogStatus.WARNING, stepName, details);
		}
		else if(status.equalsIgnoreCase("UNKNOWN"))
		{
			test.log(LogStatus.UNKNOWN, stepName, details);
		}
		else 
		{
			test.log(LogStatus.INFO, stepName, details);
		}
	}
	
	
}
