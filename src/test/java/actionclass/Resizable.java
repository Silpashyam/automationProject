package actionclass;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class Resizable {
	WebDriver drv;
	Util obj;
	@BeforeClass
	  public void beforeClass() throws InterruptedException 
	{
		obj = new Util();
		drv = obj.LaunchBrowser("chrome","https://jqueryui.com/resizable");
		Thread.sleep(3000);
	  }
  @Test
  public void Resize() throws InterruptedException 
  {
	  WebElement iframe = drv.findElement(By.xpath("//*[@id='content']/iframe"));
	  drv.switchTo().frame(iframe);
	  WebElement resize = drv.findElement(By.xpath("//*[@id='resizable']/div[3]"));
	  Actions act = new Actions(drv);
	  Thread.sleep(3000);
	  act.moveToElement(resize).dragAndDropBy(resize, 200, 250).build().perform();
	  Thread.sleep(3000);
	  
	  //act.clickAndHold(resize).moveByOffset(200,250).build().perform();
	  //act.moveToElement(resize).dragAndDropBy(resize, 200, 250).build().perform();
  }
  

  @AfterClass
  public void afterClass() {
	  //drv.close();
  }

}
