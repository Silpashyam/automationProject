package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Util;

public class Test {
	public static void main(String[] args) throws InterruptedException 
	{
		System.out.println("inside test class");
		Util obj = new Util();
		WebDriver drv = obj.LaunchBrowser("chrome","https://www.seleniumeasy.com/test/");
		Thread.sleep(2000);
		
		//////    URL VERIFICATION   
		String url = "https://www.seleniumeasy.com/test/";
		String urlfromapp = drv.getCurrentUrl();
		if(urlfromapp.contains(url))
		{
			System.out.println("URL verification = pass");
		}
		else
		{
			System.out.println("URL verification = fail");
		}
		
		//////   TITLE VERIFICATION
		
		String title = "Selenium Easy - Best Demo website to practice Selenium Webdriver Online";
		String titlefromapp = drv.getTitle();
		if(titlefromapp.contains(title))
		{
			System.out.println("TITLE verification = pass");
		}
		else
		{
			System.out.println("TITLE verification = fail");
		} 
		////////////  text verification
		
		String value = "Silpa";
		WebElement nothanks = drv.findElement(By.linkText("No, thanks!"));
		nothanks.click();
		Thread.sleep(2000);
		//WebElement nothanks1 = drv.findElement(By.partialLinkText("No"));
		//nothanks1.click();
		
		WebElement inputform = drv.findElement(By.className("dropdown-toggle"));
		inputform.click();
		Thread.sleep(3000);
		
		WebElement simpleformdemo = drv.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[1]/a"));
		simpleformdemo.click();
		
		WebElement entermessage = drv.findElement(By.id("user-message"));
		entermessage.sendKeys(value);
		Thread.sleep(3000);
		
		WebElement showmessagebutton = drv.findElement(By.xpath("//*[@id='get-input']/button"));
		showmessagebutton.click();
		
		WebElement messagefromapp = drv.findElement(By.id("display"));
		String valuefromapp = messagefromapp.getText();
	
		if(valuefromapp.contains(value))
		{
			System.out.println("Message verification = pass");
		}
		else
		{
			System.out.println("Message verification = fail");
		}
		Thread.sleep(3000);
		
		//////////// TWO INPUT FIELD VERIFICATION
		
		int value1 = 10; 
		int value2 = 200;
		
		WebElement entervalue1 = drv.findElement(By.id("sum1"));
		entervalue1.sendKeys(String.valueOf(value1));
		
		WebElement entervalue2 = drv.findElement(By.id("sum2"));
		entervalue2.sendKeys(String.valueOf(value2));
		
		WebElement gettotal = drv.findElement(By.xpath("//*[@id='gettotal']/button"));
		gettotal.click();
		
		WebElement totalvaluefromapp = drv.findElement(By.id("displayvalue"));
		String totalfromapp = totalvaluefromapp.getText();
		int total = Test.sum(value1,value2);
		if(totalfromapp.equals(String.valueOf(total)))
		{
			System.out.println("Total verification = pass");
		}
		else
		{
			System.out.println("Total verification = fail");
		}
		
		drv.close(); 
	}
	
	public static int sum(int a , int b)
	{
		int c = a+b;
		return c;
	}
	
}
