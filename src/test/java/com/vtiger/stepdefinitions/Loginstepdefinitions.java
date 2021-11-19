package com.vtiger.stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Loginstepdefinitions extends BaseTest {
	public LoginPage lp;
	public HomePage hp;
	
	@Given("^user navigate to url \"([^\"]*)\" on chrome$")
	public void user_navigate_to_url_on_chrome(String url) throws Throwable {
		launchApp();
		logger = extent.createTest("Login Feature");
		lp=new LoginPage(driver,logger);
		hp=new HomePage(driver,logger);
		
	}

	@Then("^Login page should be appear$")
	public void login_page_should_be_appear() throws Throwable {
	   lp.verifyloginpage();
	}

	@When("^user enters valid userid and password$")
	public void user_enters_valid_userid_and_password() throws Throwable {
	    lp.login("admin", "admin");
	}

	@When("^user enters invalid userid and password$")
	public void user_enters_invalid_userid_and_password() throws Throwable {
		 lp.login("admin123", "admin1214");
	}
	
	@When("^user enters invalid userid as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_enters_invalid_userid_as_and_password_as(String userid, String pwd) throws Throwable {
		lp.login(userid, pwd);
	}
	
	@When("^user enters valid userid as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_enters_valid_userid_as_and_password_as(String arg1, String arg2, DataTable dt) throws Throwable {
		List<List<String>> lst = dt.raw();		
	    lp.login(lst.get(0).get(0),lst.get(0).get(1));
	}

	
	@When("^click on Login button$")
	public void click_on_Login_button() throws Throwable {
		lp.clickLogin();
	}

	@Then("^user should be landed on homepage$")
	public void user_should_be_landed_on_homepage() throws Throwable {	   
	    hp.verifyHomeTab();
	}

	@Then("^Logout link should be appear$")
	public void logout_link_should_be_appear() throws Throwable {
	    driver.findElement(By.linkText("Logout")).click();
	    hp.clickLogout();
	}
	
	@Then("^error msg should be appear$")
	public void error_msg_should_be_appear() throws Throwable {	 
	    lp.verifyerrorMsg();
	} 
	
	@Then("^close the browser$")
	public void close_browser() throws Throwable {	
		extent.flush();
	   driver.quit();
	} 
	
	

}
