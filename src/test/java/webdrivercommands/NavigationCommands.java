package webdrivercommands;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class NavigationCommands {
	WebDriver drv;
	Util obj;
	@BeforeClass
	  public void beforeClass() throws InterruptedException {
		obj = new Util();
		drv = obj.LaunchBrowser("chrome","http://demo.guru99.com/test/newtours/");
		Thread.sleep(3000);
	  }
  @Test
  public void navigate() {
	  drv.navigate().to("https://www.gmail.com");
	  System.out.println(drv.getTitle());
	  drv.navigate().back();
	  System.out.println(drv.getTitle());
	  drv.navigate().forward();
	  System.out.println(drv.getTitle());
	  drv.navigate().refresh();
	  
  }
  

  @AfterClass
  public void afterClass() {
	  //drv.close();
  }

}
