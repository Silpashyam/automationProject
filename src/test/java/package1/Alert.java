package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Util;

public class Alert {

	public static void main(String[] args) throws InterruptedException {
		Util obj = new Util();
		WebDriver drv = obj.LaunchBrowser("chrome","https://www.seleniumeasy.com/test/");
		Thread.sleep(3000);
		
		WebElement nothanks = drv.findElement(By.linkText("No, thanks!"));
		nothanks.click();
		Thread.sleep(3000);
		
		WebElement alertsmenu = drv.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[2]/a"));
		alertsmenu.click();
		Thread.sleep(3000);
		
		WebElement javascriptalert = drv.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[2]/ul/li[5]/a"));
		javascriptalert.click();
		Thread.sleep(3000);
		
		//////////////// Alert box 1
		
		WebElement clickme1 = drv.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[1]/div[2]/button"));
		clickme1.click();
		org.openqa.selenium.Alert obj1 = drv.switchTo().alert();
		String clickme1textfromapp = obj1.getText();
		String clickme1text = "I am an alert box!";
		if(clickme1textfromapp.contains(clickme1text))
		{
			obj1.accept();
			System.out.println("Alert1 verification = pass");
		}
		else
		{
			System.out.println("Alert1 verification = fail");
		}
		
		Thread.sleep(3000);
		
		////////////////Alert box 2
		
		WebElement clickme2 = drv.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/button"));
		clickme2.click();
		
		org.openqa.selenium.Alert obj2 = drv.switchTo().alert();
		String clickme2textfromapp = obj2.getText();
		String clickme2text = "Press a button!";
		if(clickme2textfromapp.contains(clickme2text))
		{
			obj2.accept();
			System.out.println("Alert2 verification = pass");
		}
		else
		{
			obj2.dismiss();
			System.out.println("Alert2 verification = fail");
		}
		Thread.sleep(3000);
		
		////////////////Alert box 3
		
		WebElement clickme3 = drv.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[3]/div[2]/button"));
		clickme3.click();
		String nameentered = "Silpa";
		org.openqa.selenium.Alert obj3 = drv.switchTo().alert();
		obj3.sendKeys(nameentered);
		obj3.accept();
		
		WebElement namedisplayed = drv.findElement(By.id("prompt-demo"));
		String namefromapp = namedisplayed.getText();
		
		if(namefromapp.contains("You have entered 'Silpa' !"))
		 {
			 System.out.println("Alert3 verification = pass"); 
		 } 
		 else 
		 {
			 System.out.println("Alert3 verification = fail");
		 }
		 
		
	}

}
