package testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class CheckBox 
{
	 WebDriver drv;
	 Util obj;
	 By nothanks = By.linkText("No, thanks!");
	 By inputform = By.className("dropdown-toggle");
	 By checkbox = By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[2]/a");
	 By singlecheck = By.xpath("//*[@id=\"isAgeSelected\"]");
	 
  @BeforeClass
  public void beforeClass() throws InterruptedException 
  {
	    obj = new Util();
		drv = obj.LaunchBrowser("chrome","https://www.seleniumeasy.com/test/");
		Thread.sleep(3000);
		obj.click(nothanks);
		Thread.sleep(3000);
		obj.click(inputform);
		obj.click(checkbox);
		
		
		 
  }
  @Test
  public void singleCheckBox() throws InterruptedException 
  {
	  //obj.click(singlecheck);
	  WebElement singlecheck = drv.findElement(By.xpath("//*[@id=\"isAgeSelected\"]"));
	  System.out.println(singlecheck.isSelected()); 
	  singlecheck.click();
	  WebElement singlechecktexts = drv.findElement(By.id("txtAge"));
	  String singlechecktextfromapp = singlechecktexts.getText();
	  String singlechecktext = "Success - Check box is checked";
	  System.out.println(singlechecktextfromapp);
	  System.out.println(singlechecktext);
	  Thread.sleep(3000);
	  SoftAssert objassert = new SoftAssert();
	 objassert.assertEquals(singlechecktextfromapp, singlechecktext, "Single check box selected = pass");
	 objassert.assertAll();
	  singlecheck.isSelected();
	  singlecheck.click();
  }
  @Test
  public void multipleCheckBox() throws InterruptedException 
  {
	  
	  WebElement checkallbtn = drv.findElement(By.xpath("//*[@id='check1']"));
	  Actions actions = new Actions(drv);
	  actions.moveToElement(checkallbtn).build();
	  actions.perform();
	  Thread.sleep(5000);
	  checkallbtn.click();
	  Thread.sleep(3000);
	  WebElement uncheckallbtn = drv.findElement(By.xpath("//*[@id='check1']"));
	  String btnvalue= uncheckallbtn.getAttribute("value");
	  System.out.println(btnvalue);
	  
	  SoftAssert objassert = new SoftAssert();
	  objassert.assertEquals(btnvalue, "Uncheck All", "Multi check box selected = pass");
	  objassert.assertAll();
	  Thread.sleep(3000);
	  checkallbtn.click();
	  Thread.sleep(3000);
	  
	
	  String btnvalue1= checkallbtn.getAttribute("value");
	  System.out.println(btnvalue1);
	  SoftAssert objassert1 = new SoftAssert();
	  objassert1.assertEquals(btnvalue1, "Check All", "Multi check box unselected = pass");
	  objassert1.assertAll();
	  
	  
  }
  

  @AfterClass
  public void afterClass() 
  {
	 // drv.close();
  }

}
