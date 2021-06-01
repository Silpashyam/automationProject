package testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class RadioButton {
	 WebDriver drv;
	 Util obj;
	 By nothanks = By.linkText("No, thanks!");
	 By inputform = By.className("dropdown-toggle");
	 By radiobutton = By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[3]/a");
	 By maleradio = By.xpath("//*[@id='easycont']/div/div[2]/div[1]/div[2]/label[1]/input");
	 By checkedvaluebtn = By.id("buttoncheck");
	 By femaleradio = By.xpath("//*[@id='easycont']/div/div[2]/div[1]/div[2]/label[2]/input");
	 
	 @BeforeClass
	  public void beforeClass() throws InterruptedException 
	 {
		    obj = new Util();
			drv = obj.LaunchBrowser("chrome","https://www.seleniumeasy.com/test/");
			WebDriverWait wait = new WebDriverWait(drv,30);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(nothanks));
			obj.click(nothanks);
			Thread.sleep(3000);
			obj.click(inputform);
			obj.click(radiobutton);
	  }
  @Test
  public void radioButton() throws InterruptedException 
  {
	  // Male value verification
	  WebDriverWait wait = new WebDriverWait(drv,30);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(maleradio));
	  obj.click(maleradio);
	  Thread.sleep(3000);
	 
	  obj.click(checkedvaluebtn);
	  Thread.sleep(3000);
	  WebElement checkedtext = drv.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[1]/div[2]/p[3]"));
	  String radiobtnvaluefromapp = checkedtext.getText();
	  String radiobtnvalue = "Male";
	  Thread.sleep(3000);
	  
	  if(radiobtnvaluefromapp.contains(radiobtnvalue))
	  {
		  System.out.println("radio button Male is selected");
	  }
	  else
	  {
		  System.out.println("radio button selection failed");  
	  }
	  
	  // Female value verification
	  obj.click(femaleradio);
	  Thread.sleep(3000);
	  obj.click(checkedvaluebtn);
	  Thread.sleep(3000);
	  
	  String radiobtnvalfemalefromapp = checkedtext.getText();
	  String radiobtnval = "Female";
	  Thread.sleep(3000);
	  
	  if(radiobtnvalfemalefromapp.contains(radiobtnval))
	  {
		  System.out.println("radio button Female is selected");
	  }
	  else
	  {
		  System.out.println("radio button selection failed");  
	  }
  }
   @Test
   public void groupRadioButton()
   {
	   
   }

  @AfterClass
  public void afterClass() 
  {
	  //drv.close();
  }

}
