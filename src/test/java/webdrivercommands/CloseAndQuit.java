package webdrivercommands;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class CloseAndQuit {
	WebDriver drv;
	Util obj;
	@BeforeClass
	  public void beforeClass() throws InterruptedException {
		    obj = new Util();
			drv = obj.LaunchBrowser("chrome","http://demo.automationtesting.in/Windows.html");
			Thread.sleep(3000);
	  }

  @Test
  public void closequit() {
	  drv.findElement(By.xpath("//*[@id='Tabbed']/a/button")).click();
	  
  }
  
  @AfterClass
  public void afterClass() {
	  //drv.close();  // close only one window
	  drv.quit();  // close multiple windows
  }

}
