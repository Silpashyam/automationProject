package testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.Util;

import org.testng.annotations.BeforeClass;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

@Test
public class WebTable {
	WebDriver drv;
	Util obj;
	By nothanks = By.linkText("No, thanks!");
	By table = By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[3]/a");
	By tablepagination = By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[3]/ul/li[1]/a");
	
	
	@BeforeClass
	public void beforeTest() throws InterruptedException 
	{
			obj = new Util();
			drv = obj.LaunchBrowser("chrome","https://www.seleniumeasy.com/test/");
			Thread.sleep(3000);
			obj.click(nothanks);
			Thread.sleep(3000);
			obj.click(table);
			Thread.sleep(3000);
	}
  @Test(enabled=true)
  public void webTable() 
  {
	  obj.click(tablepagination);
	// test cell value
		WebElement cellvalue =drv.findElement(By.xpath("//*[@id='myTable']//tr[1]//td[5]"));
		 String cellvaluefromapp = cellvalue.getText();
		 System.out.println("application value = " +cellvaluefromapp);
		 // single page table data print
	  java.util.List<WebElement> rows = drv.findElements(By.xpath("//*[@id='myTable']//tr"));
	  int rowcount = rows.size();
	  System.out.println(rowcount);
	  java.util.List<WebElement> columns = drv.findElements(By.xpath("//*[@class='table table-hover']//thead//tr//th"));
	  int columnscount = columns.size();
	  System.out.println(columnscount);
	  WebElement pagination = drv.findElement(By.xpath("//*[@id='myPager']/li[5]/a"));
	  int firstpage = 1;
	  do
	  {
		  if(firstpage==0)
			  pagination.click();
		  else
			  firstpage=0;
		  
		  for(int i=0;i<rowcount;i++)
		  {
			  java.util.List<WebElement> celldata = rows.get(i).findElements(By.tagName("td"));
			  for(int j=0;j<columnscount;j++)
			  {
				  String tabledata= celldata.get(j).getText();
				  System.out.print(tabledata+" ");
			  }
			  System.out.println();
		  }
	  }
	  while(pagination.isDisplayed());
	  
	  String value1 = "Table cell";
		 System.out.println("manual value = " +value1);
			
		SoftAssert objasert = new SoftAssert();
		objasert.assertEquals(cellvaluefromapp, value1, "Table cell value verification = pass");
		objasert.assertAll(); 	  
  }
 
  @AfterClass
  public void afterClass() 
  {
	 drv.close();
  }

}
