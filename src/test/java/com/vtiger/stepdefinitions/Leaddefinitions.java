package com.vtiger.stepdefinitions;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Leaddefinitions extends BaseTest {
	
	public LeadPage ldp;
	public HomePage hp;
	

	@When("^user click on new lead link$")
	public void user_enters_valid_userid_and_password() throws Throwable {
		hp = new HomePage(driver,logger);
		hp.clickNewLead();			    
	}
	
	@Then("^create lead page will be opened$")
	public void login_page_should_be_appear() throws Throwable {	 
	   ldp = new LeadPage(driver,logger);
	   ldp.verifyCreateLeadPage();
		
	}
	
	@When("^user enters lastname and company name and click on save button$")
	public void create_lead() throws Throwable {
		ldp.createleadwithmandatoryfileld("Modi", "Bjp");		    
	}
	
	@Then("^lead should be created successfully$")
	public void lead_created_successfully() throws Throwable {	 
	  ldp.verifyEditLeadbutton();
		
	}

}
