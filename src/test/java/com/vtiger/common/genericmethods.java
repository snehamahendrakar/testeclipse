package com.vtiger.common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class genericmethods {
	
	public static void entervalue(WebDriver driver, WebElement elm, String data,ExtentTest logger)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.clear();
			elm.sendKeys(data);
			if(elm.getAttribute("value").equals(data))
			{
				logger.pass(data+" entered successfully within textbox");
			}
			else
			{
				logger.fail(data+" did not enter within textbox   <span class='label end-time'><a href='"+getscreenshot(driver)+"'>Screenshot</a></span>");
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Error captured : "+e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot(driver)+"'>Screenshot</a></span>");
		}
	}
	
	public static void clickelement(WebDriver driver, WebElement elm,ExtentTest logger)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(elm));			
			elm.click();	
			logger.pass("Element clicked successfully");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Error captured : "+e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot(driver)+"'>Screenshot</a></span>");
		}
	}
	
	public static void selectbytext(WebDriver driver, WebElement elm, String data,ExtentTest logger)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeSelected(elm));
			Select s = new Select(elm);
			s.selectByVisibleText(data);			
			if(s.getFirstSelectedOption().getText().equals(data))
			{
				logger.pass(data+" selected successfully within dropdown");
			}
			else
			{
			logger.fail(data+" did not select within dropdown  <span class='label end-time'><a href='"+getscreenshot(driver)+"'>Screenshot</a></span>");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Error captured : "+e.getMessage() + "<span class='label end-time'><a href='"+getscreenshot(driver)+"'>Screenshot</a></span>");
		}
		
		
		
	}
	
	public static void CheckDisplay(WebDriver driver, WebElement elm,ExtentTest logger)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(elm));			
			elm.isDisplayed();
			logger.pass("Element displayed successfully");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Element not found : "+e.getMessage()+ " <span class='label end-time'><a href='"+getscreenshot(driver)+"'>Screenshot</a></span>");
		}
	}
	
	public static String getscreenshot(WebDriver driver) 
	{
		DateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
		Date d = new Date();
		String str = f.format(d);
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/screenshots/image"+str+".png";
		//Move image file to new destination
		File DestFile=new File(path);
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
		
	}

}
