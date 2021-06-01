package testng;

import org.testng.annotations.Test;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class Alert {
	WebDriver drv;
	Util obj ;
	By nothanks = By.linkText("No, thanks!");
	By alertsmenu = By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[2]/a");
	By javascriptalert = By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[2]/ul/li[5]/a");
	By clickme1 = By.xpath("//*[@id='easycont']/div/div[2]/div[1]/div[2]/button");
	By clickme2 = By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/button");
	By clickme3 = By.xpath("//*[@id='easycont']/div/div[2]/div[3]/div[2]/button");
	By namedisplayed = By.id("prompt-demo");
	
  @Test(priority=1)
  public void alertBox1() throws InterruptedException 
  {
	    obj.click(clickme1);
		obj.alertAccept();
		System.out.println("Alert1 verification = pass");
		Thread.sleep(3000);
  }
  @Test(priority=2)
  public void alertBox2() throws InterruptedException
  {
	    obj.click(clickme2);
		obj.alertDismiss();
		System.out.println("Alert1 verification = pass");
		Thread.sleep(3000);
  }
  @Test(priority=3)
  public void alertBox3()
  {
	  	obj.click(clickme3);
		String nameentered = "Silpa";
		obj.alertMessageAccept(nameentered);
		
		String namefromapp = obj.getText(namedisplayed);;
		
		if(namefromapp.contains("You have entered 'Silpa' !"))
		 {
			 System.out.println("Alert3 verification = pass"); 
		 } 
		 else 
		 {
			 System.out.println("Alert3 verification = fail");
		 }
  }
  @BeforeClass
  public void beforeClass() throws InterruptedException 
  {
	  obj = new Util();
	  drv = obj.LaunchBrowser("chrome","https://www.seleniumeasy.com/test/");
	  Thread.sleep(3000);  
	  obj.click(nothanks);
	  Thread.sleep(3000);
	  obj.click(alertsmenu);
	  Thread.sleep(3000);
	  obj.click(javascriptalert);
	  Thread.sleep(3000);
  }

  @AfterClass
  public void afterClass()
  {
	  drv.close();
  }

}
