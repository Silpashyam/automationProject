package webdrivercommands;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.Set;	

public class WindowHandles {
	WebDriver drv;
	Util obj;
	 @BeforeTest
	  public void beforeTest() throws InterruptedException {
		  obj = new Util();
			drv = obj.LaunchBrowser("chrome","https://demoqa.com/browser-windows");
			Thread.sleep(3000);
	  }
  @Test
  public void windowHandles() {
	// Opening all the child window
	    drv.findElement(By.id("windowButton")).click();   // new window tab
	    drv.findElement(By.id("messageWindowButton")).click();   // new window message tab
	    
	    String MainWindow = drv.getWindowHandle();
	    System.out.println("Main window handle is " + MainWindow);

	    // To handle all new opened window
	    Set<String> s1 = drv.getWindowHandles();
	    System.out.println("Child window handle is" + s1);
	    Iterator<String> i1 = s1.iterator();

	    // Here we will check if child window has other child windows and when child window
	    //is the main window it will come out of loop.
	      while (i1.hasNext()) {
	          String ChildWindow = i1.next();
	          if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
	        	  System.out.println("Child window " + ChildWindow);
	        	  //if(driver.gettitle().contains("testdd"))
	              drv.switchTo().window(ChildWindow);
	              //drv.close();
	              //System.out.println("Child window closed");
	          }
	      }
  }
 

  @AfterTest
  public void afterTest() {
	  //drv.close();
  }

}

