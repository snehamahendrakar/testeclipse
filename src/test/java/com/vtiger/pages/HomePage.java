package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.genericmethods;

public class HomePage extends HeaderPage {
	
	private WebDriver driver;
	private ExtentTest logger;
	
	public HomePage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//td[contains(text(),'My Tickets')]")
	WebElement MyTickets;
	
	public void verifyMyTicketDashboard()
	{
		genericmethods.CheckDisplay(driver, MyTickets, logger);
	}
	
	

}
