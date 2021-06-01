package testng;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class DropDown {
	Util obj;
	WebDriver drv;
	By nothanks = By.linkText("No, thanks!");
	By inputform = By.className("dropdown-toggle");
	By selectdropdrownlist = By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[4]/a");
	By selectdropdown =By.id("select-demo");
	By multidropdown =By.id("multi-select");
	By getallselected = By.id("printAll");
  @Test(priority=1,enabled=true)
  public void singleSelect() throws InterruptedException 
  {
	    String valuetext = "Sunday";
	    obj.selectByValue(selectdropdown,valuetext);
		Thread.sleep(4000);
		
		int indexvalue = 3;
		obj.selectByIndex(selectdropdown, indexvalue);
		Thread.sleep(4000);
		
		String visibletext = "Friday";
		obj.selectByVisibleText(selectdropdown, visibletext);
		Thread.sleep(4000);
  }
  @Test(priority=2)
  public void multiSelect() throws InterruptedException
  {
	    String text1 = "California";
	    String text2 = "Florida";
	  	obj.multiselect(multidropdown, text1, text2);
		Thread.sleep(4000);
		obj.click(getallselected);
		Thread.sleep(4000);
  }
  @BeforeClass
  public void beforeClass() throws InterruptedException
  {
	  obj = new Util();
	  drv = obj.LaunchBrowser("chrome","https://www.seleniumeasy.com/test/");
	  Thread.sleep(3000);
	  obj.click(nothanks);
	  obj.click(inputform);
	  Thread.sleep(3000);
	  obj.click(selectdropdrownlist);
		
  }

  @AfterClass
  public void afterClass()
  {
		drv.close();
  }

}
