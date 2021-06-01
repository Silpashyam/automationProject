package actionclass;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

import utility.Util;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class MouseOver {
	
	WebDriver drv;
	Util obj;
	By nothanks = By.linkText("No, thanks!");
	By inputform = By.className("dropdown-toggle");
	By simpleformdemo = By.xpath( "//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[1]/a");
	By gettotal = By.xpath("//*[@id='gettotal']/button");
	By totalvaluefromapp = By.id("displayvalue");
	
	@BeforeClass
	
	public void beforeTest() throws InterruptedException {
		obj = new Util();
		drv = obj.LaunchBrowser("chrome","https://www.seleniumeasy.com/test/");
		Thread.sleep(3000);
		obj.click(nothanks);
		  Thread.sleep(2000); 
		  
		  obj.click(inputform);
		  Thread.sleep(3000);
		  
		  obj.click(simpleformdemo);
	}
	
	  @Test(priority = 1,enabled=true) 
	  public void additionVerification() throws InterruptedException, IOException 
	  { 
		  int value1 = 10; int value2 = 200;
		  WebElement entervalue1 = drv.findElement(By.id("sum1"));
		  WebElement entervalue2 = drv.findElement(By.id("sum2"));
		  WebElement gettotal = drv.findElement(By.xpath("//*[@id='gettotal']/button"));
		  WebElement totalvaluefromapp = drv.findElement(By.id("displayvalue"));
		  Actions act = new Actions(drv);
		  act.moveToElement(entervalue1).click().
		  sendKeys(entervalue1,String.valueOf(value1))
		  .moveToElement(entervalue2).click().
		  sendKeys(entervalue2,String.valueOf(value2)).moveToElement(gettotal).click().
		  build().perform();
		  
		 
	     
	  } 
	  
	
	  @AfterClass
   
    public void afterTest() 
    { 
    	//drv.close(); 
    }
	 
}
