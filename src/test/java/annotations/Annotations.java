package annotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Annotations {
	 @BeforeClass
	  public void beforeClass() {
		 // this will execute only one time before starting the class
		 System.out.println("this will execute before the class");
	  }

	  @AfterClass
	  public void afterClass() {
		// this will execute only one time after completing the class
		  System.out.println("this will execute after completion of class");
	  } 
	@BeforeMethod
	  public void beforeMethod() {
		// before method will execute multiple times before every test methods
		  System.out.println("this will execute Before every test method");
	  }

	  @AfterMethod
	  public void afterMethod() {
		// after method will execute multiple times after completing every test methods
		  System.out.println("this will execute after every test method");
	  }

	  @Test
	  public void test1() {
	  System.out.println("test 1");
	  }
	  @Test
	  public void test2() {
	  System.out.println("test 2");
	  }
	  @BeforeTest 
	  public void beforeTest() {
		  System.out.println("this will execute Before the test");
		  
	  }
	  @AfterTest 
	  public void afterTest() { 
		  System.out.println("this will execute After the test");
	  }
	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("this will execute Before actual test is started");
		  
	  }
	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("this will execute after actual test is completed");
		  
	  }
		 

}
