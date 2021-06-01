package actionclass;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class MultipleKeyboardAction {
	WebDriver drv;
	Util obj;
	@BeforeClass
	  public void beforeClass() throws InterruptedException {
		  obj = new Util();
			drv = obj.LaunchBrowser("chrome","http://text-compare.com/");
			Thread.sleep(3000);
	  }
  @Test
  public void MultipleAction() {
	  WebElement input1 = drv.findElement(By.xpath("//*[@id='inputText1']"));
	  WebElement input2 = drv.findElement(By.xpath("//*[@id='inputText2']"));
	  input1.sendKeys("Welcome to selenium");
	  Actions act = new Actions(drv);
	  
	  // CTRL + A
	/*  act.keyDown(Keys.CONTROL);
	  act.sendKeys("a");
	  act.keyUp(Keys.CONTROL);
	  act.build().perform();
	  
	  // CTRL + C
	  act.keyDown(Keys.CONTROL);
	  act.sendKeys("c");
	  act.keyUp(Keys.CONTROL);
	  act.build().perform(); */
	  
	  // CTRL +A and CTRL + C => 
	  
	  act.keyDown(Keys.CONTROL);
	  act.sendKeys("a");
	  act.sendKeys("c");
	  act.keyUp(Keys.CONTROL);
	  act.build().perform();
	  //TAB -> shift to input box 2 
	  
	  act.sendKeys(Keys.TAB);
	  act.build().perform();
	  
	// CTRL + V
	  act.keyDown(Keys.CONTROL);
	  act.sendKeys("v");
	  act.keyUp(Keys.CONTROL);
	  act.build().perform();
	  
	  // compare text
	  if(input1.getAttribute("value").equals(input2.getAttribute("value")))
	  {
		 System.out.println("Text copied"); 
	  }
	  else
	  {
		  System.out.println("Text not copied"); 
	  }
  }
  

  @AfterClass
  public void afterClass() {
	//drv.close();
  }

}
