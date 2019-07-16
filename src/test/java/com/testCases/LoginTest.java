package com.testCases;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.reports.ReportGenerator;
import com.testPages.DashBoardPage;
import com.testPages.LoginPage;
import com.testbase.TestBase;
import com.utils.FetchExcelData;
import com.utils.ScreenshotUtility;

public class LoginTest extends TestBase
{
	LoginPage lp;
	Logger logger = Logger.getLogger(LoginTest.class);
	int StepCount;
	
	@BeforeMethod
	public void setup()
	{
		init();
		
		DashBoardPage db = new DashBoardPage();
		
		lp = db.ClickMyAccountLink();
		
		StepCount=0;
	}
	
	@Test(dataProvider="abc",dataProviderClass=FetchExcelData.class)
	public void VerifyLogin(String username, String password)
	{
		// userName 
		
		Boolean userName = lp.enteruserName(username);
		
		if(userName==true)
		{
			System.out.println("UserName entered : "+username);
			
			logger.info("UserName entered : "+username);
			
			StepCount++;
			
			ReportGenerator.stepDetails("PASS","Step "+ StepCount+ " : "+ " Enter UserName "+username , "Expected Result : User should enter username = "+username+" <br/> Actual Result : UserName entered = "+username, ScreenshotUtility.takeScreenshot("userName"));
		}
		else
		{
			System.out.println("UserName not entered : "+username);
			
			logger.error("UserName not entered : "+username);
			
			StepCount++;
			
			ReportGenerator.stepDetails("FAIL","Step "+ StepCount+ " : "+ " Enter UserName "+username , "Expected Result : User should enter username = "+username+" <br/> Actual Result : UserName was not entered = "+username, ScreenshotUtility.takeScreenshot("userNameFailed"));
		}
		
		// password 
		
		Boolean passWord = lp.enterPassword(password);
		
		if(passWord==true)
		{
			System.out.println("PassWord entered : "+password);
			
			logger.info("PassWord entered : "+password);
			
			StepCount++;
			
			ReportGenerator.stepDetails("PASS","Step "+ StepCount+ " : "+ " Enter PassWord "+password , "Expected Result : User should enter PassWord = "+password+" <br/> Actual Result : PassWord entered = "+password, ScreenshotUtility.takeScreenshot("passWord"));
		}
		else
		{
			System.out.println("PassWord not entered : "+password);
			
			logger.error("PassWord not entered : "+password);
			
			StepCount++;
			
			ReportGenerator.stepDetails("FAIL","Step "+ StepCount+ " : "+ " Enter PassWord "+password , "Expected Result : User should enter PassWord = "+password+" <br/> Actual Result : PassWord was not entered = "+password, ScreenshotUtility.takeScreenshot("PassWordFailed"));
		}
		
		// loginButton 
		
		lp.clickLoginButton();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		if(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Sign out']"))).isDisplayed())
		{
			System.out.println("Login Successfull..!!");
			
			logger.info("Login Successfull..!!");
			
			StepCount++;
			
			ReportGenerator.stepDetails("PASS", "Step "+ StepCount+ " : "+" Click On Login Button ", "Expected Result : User should click on Login Button <br/> Actual Result : User clicked on Login Button ", ScreenshotUtility.takeScreenshot("LoginButton"));
		}
		else
		{
			System.out.println("Unable To Click On Login Button..!!");
			
			logger.error("Unable To Click On Login Button..!!");
			
			StepCount++;
			
			ReportGenerator.stepDetails("FAIL", "Step "+ StepCount+ " : "+" Click On Login Button ", "Expected Result : User should click on Login Button <br/> Actual Result : Unable To Click On Login Button..!! ", ScreenshotUtility.takeScreenshot("LoginButtonFailed"));
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
