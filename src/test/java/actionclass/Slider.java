package actionclass;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class Slider {
	WebDriver drv;
	Util obj;
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  obj = new Util();
			drv = obj.LaunchBrowser("chrome","https://jqueryui.com/slider");
			Thread.sleep(3000);
	  }
  @Test
  public void slider() 
  {
	  drv.switchTo().frame(0);
	  WebElement slider = drv.findElement(By.xpath("//*[@id=\"slider\"]/span"));
	  Actions act = new Actions(drv);
	  act.moveToElement(slider).dragAndDropBy(slider, 500, 0).build().perform();
  }


  @AfterClass
  public void afterClass() {
	  //drv.close();
  }

}
