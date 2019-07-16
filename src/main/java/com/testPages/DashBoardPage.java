package com.testPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class DashBoardPage extends TestBase
{
	@FindBy(xpath="//a[text()='My Account']")
	@CacheLookup
	WebElement MyAccountLink;
	
	public DashBoardPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage ClickMyAccountLink()
	{
		MyAccountLink.click();
		
		return new LoginPage();
	}
	
}
