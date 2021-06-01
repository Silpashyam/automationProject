package webdrivercommands;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class ExplicitWait {
	WebDriver drv;
	Util obj;
	By elementlocator = By.xpath("//*[@id='rso']/div[1]/div/div/div/div[1]/a/h3");
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  obj = new Util();
			drv = obj.LaunchBrowser("chrome","https://www.google.com/");
			Thread.sleep(3000);
	  }
  @Test
  public void explicitWait() {
	  // Explicit wait
	  // element specific wait - adv
	  // we need to write this for multiple elements -> disadv
	  WebDriverWait mywait = new WebDriverWait(drv,30);
	 

	  drv.findElement(By.name("q")).sendKeys("selenium");
	  drv.findElement(By.name("q")).sendKeys(Keys.ENTER);
	  
	WebElement element=  mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rso']/div[1]/div/div/div/div[1]/a/h3")));
	element.click();
  }
 @Test
 public void explicitwaitCommon()
 {
	 
	 drv.findElement(By.name("q")).sendKeys("selenium");
	 drv.findElement(By.name("q")).sendKeys(Keys.ENTER);
	 
	 Util.explicitwaitforelementpresent(drv,elementlocator,30).click();
	 
 }

  @AfterClass
  public void afterClass() {
	//  drv.close();
  }

}
