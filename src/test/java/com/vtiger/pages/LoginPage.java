package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.genericmethods;

public class LoginPage {
	
	private WebDriver driver;
	private ExtentTest logger;
	
	public LoginPage(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	WebElement userid;
	
	@FindBy(name="user_password")
	WebElement pwd;
	
	@FindBy(name="login_theme")
	WebElement theme;
	
	@FindBy(name="Login")
	WebElement Login;
	
	@FindBy(xpath="//img[@src='include/images/vtiger-crm.gif']")
	WebElement logo;
	
	@FindBy(xpath="//font[text()='Key Modules']")
	WebElement txtKeyModule;
	
	@FindBy(xpath="//td[contains(text(),'123 You must specify a valid username and password.')]")
	WebElement errmsg;
	
	@FindBy(xpath="//strong[text()='User Log-in']")
	WebElement loginView;
	
	
	
	
	
	
	public void login(String userdata, String pwddata)
	{
		genericmethods.entervalue(driver, userid, userdata,logger);
		genericmethods.entervalue(driver, pwd, pwddata,logger);
		//genericmethods.clickelement(driver, Login,logger);		
	}
	
	public void verifyInValidlogin(String userdata, String pwddata)
	{
		genericmethods.entervalue(driver, userid, userdata,logger);
		genericmethods.entervalue(driver, pwd, pwddata,logger);
		//genericmethods.clickelement(driver, Login,logger);		
		//genericmethods.CheckDisplay(driver, errmsg, logger);
		
	}
	
	
	
	public void loginwiththeme(String userdata, String pwddata,String themetxt)
	{
		genericmethods.entervalue(driver, userid, userdata,logger);
		genericmethods.entervalue(driver, pwd, pwddata,logger);
		genericmethods.selectbytext(driver, theme, themetxt,logger);
		//genericmethods.clickelement(driver, Login,logger);	
	}
	
	public void clickLogin()
	{
		genericmethods.clickelement(driver, Login, logger);
	}
	public void verifyLogo()
	{
		genericmethods.CheckDisplay(driver, logo, logger);
	}
	
	public void verifyKeyModule()
	{
		genericmethods.CheckDisplay(driver, txtKeyModule, logger);
	}
	
	public void verifyloginpage()
	{
		genericmethods.CheckDisplay(driver, loginView, logger);
	}
	
	public void verifyerrorMsg()
	{
		genericmethods.CheckDisplay(driver, errmsg, logger);
	}
	

}
