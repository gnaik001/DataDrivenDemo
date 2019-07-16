package com.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase 
{
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static FileInputStream fileInputStream;
	public static Properties properties;
	
	public TestBase() 
	{
		try 
		{
			fileInputStream = new FileInputStream("src/test/resources/or.properties");
			
			properties = new Properties();
			
			properties.load(fileInputStream);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void init()
	{
		
		if(properties.getProperty("browserName").equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		else if(properties.getProperty("browserName").equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		wait = new  WebDriverWait(driver, 20);
		
		driver.manage().window().maximize();
		
		driver.get(properties.getProperty("url"));
		
	}
}
