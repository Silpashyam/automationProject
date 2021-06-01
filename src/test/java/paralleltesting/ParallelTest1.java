package paralleltesting;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.Util;

public class ParallelTest1 {
	WebDriver drv;
	Util obj;
	By nothanks = By.linkText("No, thanks!");
	@BeforeClass
	  public void beforeClass() throws InterruptedException {
		  obj = new Util();
		  drv = obj.LaunchBrowser("chrome","https://www.seleniumeasy.com/test/");
		  Thread.sleep(3000);
	  }
  @Test(priority = 1,enabled=true) 
  public void urlVerification() throws InterruptedException, IOException
  { 
	  String url = "https://www.seleniumeasy.com/test/"; 
	  String urlfromapp =drv.getCurrentUrl(); 
	  SoftAssert objassert = new SoftAssert();
	  objassert.assertEquals(urlfromapp, url, "URL verification = pass");
	  objassert.assertAll();
	  Thread.sleep(5000);
  }
  @Test(priority = 2,enabled=true) 
  public void titleVerification() 
  { 
	  String title = "Selenium Easy - Best Demo website to practice Selenium Webdriver Online";
	  String titlefromapp = drv.getTitle();
	  SoftAssert objassert = new SoftAssert();
	  objassert.assertEquals(titlefromapp, title, "TITLE verification = pass");
	  objassert.assertAll();
  } 
  

 @AfterClass
  public void afterMethod() {
	  drv.close();
  }
}