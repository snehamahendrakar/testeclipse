package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.genericmethods;

public class HeaderPage {
	
private WebDriver driver;
private ExtentTest logger;

public HeaderPage(WebDriver driver,ExtentTest logger)
{
	this.driver = driver;
	this.logger = logger;
	PageFactory.initElements(driver, this);
}
	
@FindBy(linkText="Leads")
WebElement lead;

@FindBy(linkText="New Lead")
WebElement NewLead;

@FindBy(linkText="Logout")
WebElement logout;

@FindBy(linkText="My Account")
WebElement MyAccount;

@FindBy(xpath="//a[@class='currentTab' and text()='Home']")
WebElement HomeTab;
	
	
	
	public void verifyLogout()
	{
		
		genericmethods.CheckDisplay(driver, logout, logger);
	}
	
	public void clickLogout()
	{
		genericmethods.clickelement(driver, logout,logger);
	}
	
	public void verifyHomeTab()
	{
		genericmethods.CheckDisplay(driver, HomeTab,logger);
	}
	
	public void clickNewLead()
	{
		genericmethods.clickelement(driver, NewLead,logger);
	}
	public void clicklead()
	{
		genericmethods.clickelement(driver, lead,logger);
	}
	public void clickMyAccount()
	{
		genericmethods.clickelement(driver, MyAccount,logger);
	}

}
