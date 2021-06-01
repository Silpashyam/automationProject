package Scrolling;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class InfiniteScroll {
	WebDriver drv;
	Util obj;
	@BeforeClass
	  public void beforeClass() throws InterruptedException {
		 obj = new Util();
			drv = obj.LaunchBrowser("chrome","https://the-internet.herokuapp.com/infinite_scroll");
			Thread.sleep(3000);
	  }
  @Test
  public void Infinitescroll() throws InterruptedException 
  {
	  JavascriptExecutor js = (JavascriptExecutor)drv;
	 long initialHeight =  (long) js.executeScript("return document.body.scrollHeight");
	 while(true)
	 {
	  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	  Thread.sleep(3000);
	  long currentHeight =  (long) js.executeScript("return document.body.scrollHeight");
	  if(initialHeight==currentHeight)
	  {
		  break;
	  }
	  initialHeight=currentHeight;
	 }
  }
  

  @AfterClass
  public void afterClass() {
	 // drv.close();
  }

}
