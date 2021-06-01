package actionclass;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class DoubleClick {
	WebDriver drv;
	Util obj;
	@BeforeClass
	  public void beforeClass() throws InterruptedException {
		obj = new Util();
		drv = obj.LaunchBrowser("chrome","http://omayo.blogspot.com");
		Thread.sleep(3000);
	  }
  @Test
  public void doubleClick() {
	  Actions act = new Actions(drv);
	WebElement doubleclicklink =  drv.findElement(By.id("testdoubleclick"));
	act.doubleClick(doubleclicklink).build().perform();  
	  
  }
  

  @AfterClass
  public void afterClass() {
	  //drv.close();
  }

}
