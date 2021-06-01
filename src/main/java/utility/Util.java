package utility;

import java.io.File;
import java.io.IOException;
//import java.security.Timestamp;
//import java.sql.Date;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.sql.Timestamp;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class Util {
	WebDriver driver;
	
	public WebDriver LaunchBrowser(String browsers,String url)
	{
		System.out.println(browsers);
		switch(browsers)
		{
		case "chrome" : System.setProperty("webdriver.chrome.driver", "D:\\Silpa\\Automation\\Drivers\\chromedriver.exe");
					  	driver = new ChromeDriver();
					  	driver.get(url);
					  	// IMPLICIT WAIT
					  	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					  	
					  	driver.manage().window().maximize();
					  	break;				  	
					  	
		case "firefox" : System.setProperty("webdriver.gecko.driver", "D:\\Silpa\\Automation\\geckodriver.exe");
						driver = new FirefoxDriver();
						driver.get(url);
						driver.manage().window().maximize();
						break;
						
		case "edge" : System.setProperty("webdriver.edge.driver", "D:\\Silpa\\Automation\\Drivers\\msedgedriver.exe");
						driver = new EdgeDriver();
						driver.get(url);
						driver.manage().window().maximize();
						break;
		default    : System.out.println("choose a browser");
		}
		return driver;
		
			
	}
	public void click(By value)
	{
		driver.findElement(value).click();
	}
	public void sendKeys(By value,String name)
	{
		driver.findElement(value).sendKeys(name);
	}
	public String getText(By value)
	{
		String text =driver.findElement(value).getText();
		return text;
	}
	public static int sum(int a , int b)
	{
		int c = a+b;
		return c;
	}
	public void alertAccept()
	{
		org.openqa.selenium.Alert obj1 = driver.switchTo().alert();
		obj1.accept();
	}
	public void alertDismiss()
	{
		org.openqa.selenium.Alert obj2 = driver.switchTo().alert();
		obj2.dismiss();
		
	}
	public void alertMessageAccept(String name)
	{
		org.openqa.selenium.Alert obj3 = driver.switchTo().alert();
		obj3.sendKeys(name);
		obj3.accept();
	}
	public void selectByValue(By value,String text)
	{
		Select obj = new Select(driver.findElement(value));
		obj.selectByValue(text);
	}
	public void selectByIndex(By value,int text)
	{
		Select obj = new Select(driver.findElement(value));
		obj.selectByIndex(text);
	}	
	public void selectByVisibleText(By value,String text)
	{
		Select obj = new Select(driver.findElement(value));
		obj.selectByVisibleText(text);
	}
	public void multiselect(By value,String text1,String text2)
	{
		Select obj = new Select(driver.findElement(value));
		obj.selectByValue(text1);
		obj.selectByValue(text2);
	}
	public void screenshot(int sequencenumber) throws IOException 
	  {
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		//Date date = new Date();
		  System.out.println(timestamp);
		  //1621137725095
		  TakesScreenshot scrShot = ((TakesScreenshot)driver);
	      File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	      File DestFile=new File("D:\\Silpa\\Automation\\Screenshots\\ElementScreenshot"+sequencenumber+".jpg");
	      Files.copy(SrcFile, DestFile);
	     
	  }
	public static WebElement explicitwaitforelementpresent(WebDriver driver, By locator, int timeout)
	{
		WebDriverWait mywait = new WebDriverWait(driver,timeout);
		mywait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);
	}
}
