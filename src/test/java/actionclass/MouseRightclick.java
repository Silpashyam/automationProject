package actionclass;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class MouseRightclick {
	WebDriver drv;
	Util obj;
	@BeforeClass
	  public void beforeClass() throws InterruptedException {
		  obj = new Util();
			drv = obj.LaunchBrowser("chrome","https://swisnl.github.io/jQuery-contextMenu/demo.html");
			Thread.sleep(3000);
	  }

  @Test
  public void rightclick() throws InterruptedException {
	  WebElement button = drv.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));
	  Actions act = new Actions(drv);
	  act.contextClick(button).build().perform();
	  Thread.sleep(3000);
	  WebElement copy = drv.findElement(By.xpath("/html/body/ul/li[3]"));
	  copy.click();
	  Thread.sleep(3000);
	 String alerttext=  drv.switchTo().alert().getText();
	 System.out.println(alerttext);
	 Thread.sleep(3000);
	 drv.switchTo().alert().accept();
  }
  
  @AfterClass
  public void afterClass() {
	  drv.close();
  }

}
