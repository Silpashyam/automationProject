package actionclass;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class KeyboardAction {
	WebDriver drv;
	Util obj;
	@BeforeClass
	  public void beforeClass() throws InterruptedException {
		  obj = new Util();
			drv = obj.LaunchBrowser("chrome","http://the-internet.herokuapp.com/key_presses");
			Thread.sleep(3000);
	  }
  @Test
  public void Keyboard() throws InterruptedException {
	  Actions act=new Actions(drv);
	  act.sendKeys(Keys.ENTER).build().perform();
	  Thread.sleep(3000);
	  act.sendKeys(Keys.BACK_SPACE).build().perform();
	  Thread.sleep(3000);
	  act.sendKeys(Keys.SPACE).build().perform();
	  Thread.sleep(3000);
	  act.sendKeys(Keys.ESCAPE).build().perform();
  }
  

  @AfterClass
  public void afterClass() {
	  //drv.close();
  }

}
