package com.listeners;

import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.reports.ReportGenerator;

public class TestSuitListener implements ISuiteListener
{

	Logger logger = Logger.getLogger(TestSuitListener.class);
	
	public void onStart(ISuite suite) 
	{
		System.out.println("================== Test Suit Started : "+ suite.getName()+ " ============================");
		
		logger.info("================== Test Suit Started : "+ suite.getName()+ " ============================");
		
		ReportGenerator.startTestSuite("./Reports/testReport.html", "Gaurav");
	}

	public void onFinish(ISuite suite) 
	{
		ReportGenerator.endTestSuite();
		
		System.out.println("================== Test Suit Ended : "+ suite.getName()+ " ============================");
		
		logger.info("================== Test Suit Ended : "+ suite.getName()+ " ============================");
	}

}
