package com.testPages;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class LoginPage extends TestBase 
{
	Boolean flag;
	
	@FindBy(xpath="//input[@id='username']")
	@CacheLookup
	WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	@CacheLookup
	WebElement passWord;
	
	@FindBy(xpath="//input[@name='login']")
	@CacheLookup
	WebElement LoginButton;
	
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean enteruserName(String username)
	{
		
		userName.clear();
		
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		userName.sendKeys(username);
		
		if(userName.getAttribute("value").equalsIgnoreCase(username))
		{
			flag = true;
		}
		else
		{
			flag = false;
		}
		
		return flag;
	}
	
	public boolean enterPassword(String password)
	{
		passWord.clear();
		
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		passWord.sendKeys(password);
		
		if(passWord.getAttribute("value").equalsIgnoreCase(password))
		{
			flag = true;
		}
		else
		{
			flag = false;
		}
		
		return flag;
	}
	
	public void clickLoginButton()
	{
		LoginButton.click();
		
	
	}
	
}
