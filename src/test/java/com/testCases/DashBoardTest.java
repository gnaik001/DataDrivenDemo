package com.testCases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.reports.ReportGenerator;
import com.testPages.DashBoardPage;
import com.testbase.TestBase;

public class DashBoardTest extends TestBase
{
	int StepCounter;
	DashBoardPage db;
	Logger logger = Logger.getLogger(DashBoardPage.class);
	
	@BeforeMethod
	public void setup()
	{
		init();
		db = new DashBoardPage();
	}
	
	@Test
	public void verifyClickMyAccountLink()
	{
		StepCounter++;
		
		db.ClickMyAccountLink();
		
		String CurrentUrl = driver.getCurrentUrl();
		
		System.out.println("CurrentUrl");
		
		if(CurrentUrl.equalsIgnoreCase(properties.getProperty("verifyMyAccountLink")))
		{
			System.out.println("My Account Link Verified..!!");
			
			logger.info("My Account Link Verified..!!");
			
			ReportGenerator.stepDetails("PASS","Step "+StepCounter+" : "+"Verify My Account Link" , "Expected Result : User should Verify my Account Link <br/> Actual result : My Account Link Verified.", com.utils.ScreenshotUtility.takeScreenshot("MyAccountLink"));
		}
		else
		{
			System.out.println("My Account Link Not Verified..!!");
			
			logger.info("My Account Link Not Verified..!!");
			
			ReportGenerator.stepDetails("PASS","Step "+StepCounter+" : "+"Verify My Account Link" , "Expected Result : User should Verify my Account Link <br/> Actual result : My Account Link Not Verified.", com.utils.ScreenshotUtility.takeScreenshot("MyAccountLinkFailed"));
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		driver.close();
	}
}
