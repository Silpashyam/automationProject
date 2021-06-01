package annotations;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class ParametersExample {
	WebDriver drv;
	Util obj;
	By nothanks = By.linkText("No, thanks!");
	@Parameters({"browser","url"})
	@BeforeClass
	  public void beforeClass(String browser,String url) throws InterruptedException {
		  obj = new Util();
			//drv = obj.LaunchBrowser("chrome","https://www.seleniumeasy.com/test/");
		  drv = obj.LaunchBrowser(browser,url);
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
  public void afterClass() {
	  drv.close();
  }

}
