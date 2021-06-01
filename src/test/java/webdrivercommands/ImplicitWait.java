package webdrivercommands;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class ImplicitWait {
	WebDriver drv;
	Util obj;
	@BeforeClass
	  public void beforeClass() throws InterruptedException {
		  obj = new Util();
			drv = obj.LaunchBrowser("chrome","https://www.google.com/");
			Thread.sleep(3000);
	  }
  @Test
  public void implicitWait() {
	  // Implicit wait
	  // simple to use. add only once and which is applicable for all the elements
	  
	  drv.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  drv.findElement(By.name("q")).sendKeys("selenium");
	  drv.findElement(By.name("q")).sendKeys(Keys.ENTER);
	  drv.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div[1]/a/h3")).click();
	  
  }
  

  @AfterClass
  public void afterClass() {
	  //drv.close();
  }

}
