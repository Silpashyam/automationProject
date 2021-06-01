package webdrivercommands;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class SwitchingWindows {
	WebDriver drv;
	Util obj;
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {
		 obj = new Util();
			drv = obj.LaunchBrowser("chrome","http://demo.automationtesting.in/Windows.html");
			Thread.sleep(3000);
	  }
  @Test
  public void Switchwindow() {
	  
	 WebElement tabbedwindow = drv.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a"));
	 tabbedwindow.click();
	 WebElement clickbtn = drv.findElement(By.xpath("//*[@id='Tabbed']/a/button"));
	 clickbtn.click();
	 System.out.println(drv.getTitle());  // parent frame
	 // to switch to child window
	 Set <String> s = drv.getWindowHandles(); // return id/key value of a browser/window
     for(String i:s)
     {
    	// System.out.println(i);   // returns the id
    	 String t= drv.switchTo().window(i).getTitle();
    	 //System.out.println(t);
    	// if(t.contains("Frames & windows"))
    	  //drv.close();
    	 
    	 if(t.contains("SeleniumHQ Browser Automation"))
    	 drv.close();
    	 
     }
  }
 

  @AfterClass
  public void afterClass() {
  }

}
