package webdrivercommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	public static void main(String args[])
	{
		// Chrome browser
		System.setProperty("webdriver.chrome.driver", "D:\\Silpa\\Automation\\Drivers\\chromedriver.exe");
	  	WebDriver driver = new ChromeDriver();
	  	
	    // Firefox browser
	  	//System.setProperty("webdriver.gecko.driver", "D:\\Silpa\\Automation\\geckodriver.exe");
	  	//WebDriver driver = new FirefoxDriver();
		
		// Edge browser
		//System.setProperty("webdriver.edge.driver", "D:\\Silpa\\Automation\\Drivers\\msedgedriver.exe");
		//WebDriver driver = new EdgeDriver();
	  	
	  	
	  	 String actualUrl = "http://demo.guru99.com/test/newtours/";
	  	 driver.get(actualUrl);
	  	 driver.manage().window().maximize();
	  	 
	  	 

	     //driver.close();
	}

}
