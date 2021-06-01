
package webdrivercommands;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;

@Test
public class FluentWait {
	WebDriver drv;
	Util obj;
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  obj = new Util();
			drv = obj.LaunchBrowser("chrome","https://www.google.com/");
			Thread.sleep(3000);
	  }
  public void fluentWait() {
	  // fluent wait
	  // same as explicit wait with more flexibility in polling and exception handling
	  
	/*  Wait<WebDriver> wait = new FluentWait <WebDriver>(drv)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class); */
	  
	  
	  drv.findElement(By.name("q")).sendKeys("selenium");
	  drv.findElement(By.name("q")).sendKeys(Keys.ENTER);
	  
	  
	  
	  
	 
	  
  }
 

  @AfterClass
  public void afterClass() {
  }

}
