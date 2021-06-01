package Scrolling;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class Scroll {
	WebDriver drv;
	Util obj;
	@BeforeClass
	  public void beforeClass() throws InterruptedException {
		  obj = new Util();
			drv = obj.LaunchBrowser("chrome","https://www.countries-ofthe-world.com/flags-of-the-world.html");
			Thread.sleep(3000);
	  }
  @Test
  public void Scrollupanddown() throws InterruptedException {
	  JavascriptExecutor js = (JavascriptExecutor)drv;
	  
	  // 1. Scrolling by using pixel by down
	  //js.executeScript("window.scrollBy(0,2000)");
	   //or 
	  //js.executeScript("window.scrollTo(0,2000)");
	  
	
	  //2. Scrolling page till we find element
	 //WebElement india = drv.findElement(By.xpath("//*[@id='content']/div[2]/div[2]/table[1]/tbody/tr[86]/td[1]/img"));
	  //js.executeScript("arguments[0].scrollIntoView();", india);
	  //or
	  //js.executeScript("arguments[0].scrollIntoView(true);", india);
	  
	  // 3. Scroll page till bottom
	 long initialHeight =  (long) js.executeScript("return document.body.scrollHeight");
	 System.out.println(initialHeight);
	 js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	 Thread.sleep(3000);
	 //js.executeScript("window.scrollTo(6670,3000)");  //  to up scrolling -fixed position
	 js.executeScript("window.scrollTo(6670,0)");  // to up scrolling
  }
  

  @AfterClass
  public void afterClass() {
	  //drv.close();
  }
  

}
