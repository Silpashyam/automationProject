package webdrivercommands;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class ConditionalCommands {
	WebDriver drv;
	Util obj;
	By nothanks = By.linkText("No, thanks!");
	 By inputform = By.className("dropdown-toggle");
	 By inputformsubmit = By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[5]/a");
	@BeforeClass
	  public void beforeClass() throws InterruptedException {
		  obj = new Util();
			drv = obj.LaunchBrowser("chrome","https://www.seleniumeasy.com/test/");
			Thread.sleep(3000);
			obj.click(nothanks);
			Thread.sleep(3000);
			obj.click(inputform);
			obj.click(inputformsubmit);
			Thread.sleep(3000);
	  }
  @Test
  public void conditional() throws InterruptedException {
	  WebElement firstname = drv.findElement(By.xpath("//*[@id='contact_form']/fieldset/div[1]/div/div/input"));
	  WebElement lastname = drv.findElement(By.xpath("//*[@id='contact_form']/fieldset/div[2]/div/div/input"));
	  Thread.sleep(3000);
	  if(firstname.isDisplayed() && firstname.isEnabled())
	  {
		  firstname.sendKeys("Silpa");
	  }
	  if(lastname.isDisplayed() && lastname.isEnabled())
	  {
		  lastname.sendKeys("Pootheri");
	  }
	  
	  // radio button ->do you have hosting
	  //false
	  System.out.println(drv.findElement(By.xpath("//*[@id='contact_form']/fieldset/div[10]/div/div[1]/label/input")).isSelected());
	  //false
	  System.out.println(drv.findElement(By.xpath("//*[@id='contact_form']/fieldset/div[10]/div/div[2]/label/input")).isSelected());
	  
	  // yes radio button selecting
	  if(drv.findElement(By.xpath("//*[@id='contact_form']/fieldset/div[10]/div/div[1]/label/input")).isSelected() == false)
	  {
		  drv.findElement(By.xpath("//*[@id='contact_form']/fieldset/div[10]/div/div[1]/label/input")).click(); 
	  }
  }
  

  @AfterClass
  public void afterClass() {
	  //drv.close();
  }

}
