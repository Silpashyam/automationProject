package paralleltesting;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.asserts.SoftAssert;
import utility.Util;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;


public class ParallelTest2 {
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
	
		 @Test(priority=1,enabled=true)
		 public void textVerification() throws InterruptedException, IOException 
		 {
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
		  Thread.sleep(3000);
		}
		  
		  @Test(priority =2,enabled=true) 
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
		  } 
		@AfterClass
	 public void afterTest() 
	    { 
	    	drv.close(); 
	    }
		 
	}
