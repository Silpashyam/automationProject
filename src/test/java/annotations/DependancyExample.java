package annotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DependancyExample {
  @Test
  public void startCar() {
	  System.out.println("Car started");
	  Assert.fail();
  }
  @Test(dependsOnMethods = {"startCar"} )
  public void driveCar() {
	  System.out.println("Car driving");
  }
  @Test(dependsOnMethods = {"driveCar"} )
  public void stopCar() {
	  System.out.println("Car stopped");
  }
  @Test(dependsOnMethods = {"driveCar","stopCar"},alwaysRun = true )
  public void parkCar() {
	  System.out.println("Car parked");
  }
  @BeforeTest
  public void beforeTest() {
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
