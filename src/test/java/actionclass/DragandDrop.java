package actionclass;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class DragandDrop {
	WebDriver drv;
	Util obj;
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {
		 obj = new Util();
			drv = obj.LaunchBrowser("chrome","http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
			Thread.sleep(3000);
	  }
  @Test
  public void dragdrop() 
  {
	  WebElement sourcewashington = drv.findElement(By.id("box3"));
	  WebElement targetus = drv.findElement(By.id("box103"));
	  Actions act = new Actions(drv);
	  //act.clickAndHold(sourcewashington).moveToElement(targetus).release().build().perform();
	   // or
	  act.dragAndDrop(sourcewashington, targetus).build().perform();
	  
	  
  }
 

  @AfterClass
  public void afterClass() {
	  //drv.close();
  }

}
