package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.genericmethods;

public class LeadPage extends HeaderPage {
	private WebDriver driver;
	private ExtentTest logger;

	public LeadPage(WebDriver driver,ExtentTest logger) {
		super(driver,logger);
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	//By salutationtype = By.name("salutationtype");
	@FindBy(name="salutationtype")
	WebElement salutationtype;
	
	@FindBy(name="firstname")
	WebElement fname;
	
	@FindBy(name="lastname")
	WebElement lname;
	
	@FindBy(name="company")
	WebElement company;
	
	@FindBy(name="button")
	WebElement savebtn;
	
	@FindBy(name="Edit")
	WebElement editbtn;
	
	
	public void createleadwithmandatoryfileld(String lastname, String comp)
	{		
		genericmethods.entervalue(driver, lname, lastname, logger);
		genericmethods.entervalue(driver, company, comp, logger);
		genericmethods.clickelement(driver, savebtn, logger);
		
	}
	
	public void verifyCreateLeadPage()
	{
		genericmethods.CheckDisplay(driver, lname, logger);
	}
	
	public void verifyEditLeadbutton()
	{
		genericmethods.CheckDisplay(driver, editbtn, logger);
	}
	
	
	
	

}
