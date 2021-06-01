package actionclass;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.Util;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class Tooltip {
	WebDriver drv;
	Util obj;
	@BeforeClass
	  public void beforeClass() throws InterruptedException {
		obj = new Util();
		drv = obj.LaunchBrowser("chrome","https://www.google.com/");
		Thread.sleep(3000);
	  }
  @Test
  public void tooltip() {
	  WebElement search = drv.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
	  String tootltiptext= search.getAttribute("title");
	  System.out.println(tootltiptext);
	  SoftAssert objassert1 = new SoftAssert();
	  objassert1.assertEquals(tootltiptext, "Search", "Tooltip = pass");
	  objassert1.assertAll();
  }
  

  @AfterClass
  public void afterClass() {
	  drv.close();
  }

}
