package webdrivercommands;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class GetCommands {
	WebDriver drv;
	Util obj;
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  obj = new Util();
			drv = obj.LaunchBrowser("chrome","http://demo.guru99.com/test/newtours/");
			Thread.sleep(3000);
	  }
  @Test
  public void getcommand() {
	 // drv.get("http://newtours.demoaut.com/");  // opens the url
	 System.out.println(drv.getTitle()); // returns title of the page
	 System.out.println(drv.getCurrentUrl());  // returns url of the page
	 // returns text value of an element
	 String text = drv.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[1]/td/font/b")).getText();
	 System.out.println(text); 
  }
 

  @AfterClass
  public void afterClass() {
	 // drv.close(); 
  }

}
