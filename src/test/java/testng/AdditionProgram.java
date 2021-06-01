package testng;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class AdditionProgram {
	int filesequence = 0;
	WebDriver drv;
	Util obj;
	By nothanks = By.linkText("No, thanks!");
	By inputform = By.className("dropdown-toggle");
	By simpleformdemo = By.xpath( "//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[1]/a");
	By showmessagebutton = By.xpath("//*[@id='get-input']/button");
	By messagefromapp = By.id("display");
	By entermessage = By.id("user-message");
	By gettotal = By.xpath("//*[@id='gettotal']/button");
	By entervalue1 = By.id("sum1");
	By entervalue2 = By.id("sum2");
	By totalvaluefromapp = By.id("displayvalue");
	
	@BeforeClass
	
	public void beforeTest() throws InterruptedException {
		obj = new Util();
		drv = obj.LaunchBrowser("chrome","https://www.seleniumeasy.com/test/");
		Thread.sleep(3000);
	}
	
	  @Test(priority = 1,enabled=true) 
	  public void urlVerification() throws InterruptedException, IOException
	  { 
		  filesequence =(filesequence+1) ;
		  obj.screenshot(filesequence);
		  String url = "https://www.seleniumeasy.com/test/"; 
		  String urlfromapp =drv.getCurrentUrl(); 
		  /////////////     SOFT ASSERT
		  
		  SoftAssert objassert = new SoftAssert();
		  objassert.assertEquals(urlfromapp, url, "URL verification = pass");
		  objassert.assertAll();
		  
		  /////////////////  HARD ASSERT
		  
		 // Assert.assertEquals(urlfromapp, url);
			/*
			 * if (urlfromapp.contains(url)) {
			 * System.out.println("URL verification = pass"); } else {
			 * System.out.println("URL verification = fail"); }
			 */
		  
	  }
	  
	  @Test(priority = 2,enabled=true) 
	  public void titleVerification() 
	  { 
		  String title = "Selenium Easy - Best Demo website to practice Selenium Webdriver Online";
		  String titlefromapp = drv.getTitle();
		  SoftAssert objassert = new SoftAssert();
		  objassert.assertEquals(titlefromapp, title, "TITLE verification = pass");
		  objassert.assertAll();
		  /* if (titlefromapp.contains(title)) 
		  {
			  System.out.println("TITLE verification = pass"); 
		  } 
		  else
		  {
			  System.out.println("TITLE verification = fail"); 
		  } */
	  } 
	
	 @Test(priority=3,enabled=true)
	 public void textVerification() throws InterruptedException, IOException 
	 {
		 /////////////  EXPLICIT WAIT
		  
	 // WebDriverWait wait = new WebDriverWait(drv,30);
	 // wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(nothanks));
	 obj.click(nothanks);
	  Thread.sleep(2000); 
	  
	 
	  
	  String value = "Silpa";
	  obj.click(inputform);
	  Thread.sleep(3000);
	  
	  obj.click(simpleformdemo);
	  
	  obj.sendKeys(entermessage,value);
	  Thread.sleep(3000);
	  
	  obj.click(showmessagebutton);
	  
	  String  valuefromapp = obj.getText(messagefromapp);
	  SoftAssert objassert = new SoftAssert();
	  objassert.assertEquals(valuefromapp, value, "Message verification = pass");
	  objassert.assertAll();
	 /* if(valuefromapp.contains(value)) 
	  {
		  System.out.println("Message verification = pass"); 
	  } 
	  else 
	  {
		  System.out.println("Message verification = fail"); 
	  }  */
	  Thread.sleep(3000);
	  filesequence =(filesequence+1) ;
      obj.screenshot(filesequence);
	}
	  
	  @Test(priority = 4,enabled=true) 
	  public void additionVerification() throws InterruptedException, IOException 
	  { 
		  int value1 = 10; int value2 = 200;
		  obj.sendKeys(entervalue1,String.valueOf(value1)); 
		  Thread.sleep(3000);
		  obj.sendKeys(entervalue2,String.valueOf(value2)); 
		  Thread.sleep(3000);
		  obj.click(gettotal);
		  Thread.sleep(3000); 
		  
		  String totalfromapp = obj.getText(totalvaluefromapp);
	      int total = Util.sum(value1,value2);
	      SoftAssert objassert = new SoftAssert();
		  objassert.assertEquals(totalfromapp, total, "Total verification = pass");
		  objassert.assertAll();
	     /* if(totalfromapp.equals(String.valueOf(total))) 
	      {
	    	  System.out.println("Total verification = pass"); 
	      }
	      else 
	      {
	    	  System.out.println("Total verification = fail"); 
	      } */
	      filesequence =(filesequence+1) ;
	      obj.screenshot(filesequence);
	  } 
	  
	
	  @AfterClass
   
    public void afterTest() 
    { 
    	drv.close(); 
    }
	 
}
