package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.Util;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		Util obj = new Util();
		WebDriver drv =obj.LaunchBrowser("chrome","https://www.seleniumeasy.com/test/");
		Thread.sleep(3000);
		WebElement nothanks = drv.findElement(By.linkText("No, thanks!"));
		nothanks.click();
		Thread.sleep(3000);
		
		WebElement inputform = drv.findElement(By.className("dropdown-toggle"));
		inputform.click();
		Thread.sleep(3000);
		
		WebElement selectdropdrownlist = drv.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[4]/a"));
		selectdropdrownlist.click();
		
		////////////  Single select
		WebElement selectdropdown = drv.findElement(By.id("select-demo"));
		Select obj1 = new Select(selectdropdown);
		obj1.selectByValue("Sunday");
		Thread.sleep(4000);
		
		obj1.selectByIndex(3);
		Thread.sleep(4000);
		
		obj1.selectByVisibleText("Friday");
		Thread.sleep(4000);
		//obj.isMultiple();
		// write condition
		
		/////////////  Multi select
		WebElement multidropdown = drv.findElement(By.id("multi-select"));
		Select obj2 = new Select(multidropdown);
		obj2.selectByValue("California");
		obj2.selectByValue("Florida");
		
	}

}
