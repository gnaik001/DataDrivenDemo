package com.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.reports.ReportGenerator;

public class TestCaseListener implements ITestListener 
{
	int ScenarioCounter;
	Logger logger = Logger.getLogger(TestCaseListener.class);
	
	public void onTestStart(ITestResult result) 
	{
		System.out.println("Test Case Started.. : "+result.getName());
	}

	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("Test Case Success..!! : "+result.getName());
	}

	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Test Case Failed..!! : "+result.getName());
	}

	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("Test Case Skipped..!! : "+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		System.out.println("Test Case Failed..!! : "+result.getName()+" With Success Percentage : "+ITestResult.SUCCESS_PERCENTAGE_FAILURE);
	}

	public void onStart(ITestContext context) 
	{
		ScenarioCounter++;
		
		System.out.println("=================== Test Scenario Started...!! ==========================");
		System.out.println("Test "+ScenarioCounter+" : "+ context.getName());
		
		logger.info("==================== Test Started...!! ==========================");
		logger.info("Test "+ScenarioCounter+" : "+ context.getName());
		
		ReportGenerator.startTestCase(context.getName(), "");
		
	}

	public void onFinish(ITestContext context) 
	{
		System.out.println("=================== Test Ended...!! ==========================");
		//System.out.println("Test "+testCaseCounter+" : "+ context.getName());
		
		logger.info("==================== Test Ended...!! ==========================");
		//logger.info("Test "+testCaseCounter+" : "+ context.getName());
		
		ReportGenerator.endTestCase();
	}

}
