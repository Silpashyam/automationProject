package testng;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class IFrame {
	WebDriver drv;
	Util obj;
	@BeforeClass
	public void beforeTest() throws InterruptedException 
	{
			obj = new Util();
			drv = obj.LaunchBrowser("chrome","https://www.w3schools.com/html/html_iframe.asp");
			Thread.sleep(3000);
	}
  @Test
  public void iframe() throws InterruptedException 
  {
	  WebElement iframe= drv.findElement(By.xpath("//*[@id='main']/div[3]/iframe"));
	  drv.switchTo().frame(iframe);
	  WebElement html = drv.findElement(By.xpath("//*[@id='topnav']/div/div/a[3]"));
	  html.click();
	  Thread.sleep(3000);
	  WebElement css = drv.findElement(By.xpath("//*[@id='topnav']/div/div/a[4]"));
	  css.click();
	  Thread.sleep(3000);
	  // return to parent frame
	  drv.switchTo().parentFrame();
	  WebElement home = drv.findElement(By.xpath("//*[@id='topnav']/div/div/a[2]"));
	  home.click();
	  Thread.sleep(3000);
  }
  

  @AfterClass
  public void afterTest() 
  { 
  	//drv.close(); 
  }
}
