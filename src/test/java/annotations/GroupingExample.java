package annotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class GroupingExample {
  @Test(groups = {"Sanity"})
  public void test1() {
	  System.out.println("This is test 1");
  }
  @Test(groups = {"Sanity"})
  public void test2() {
	  System.out.println("This is test 2");
  }
  @Test(groups = {"Regression"})
  public void test3() {
	  System.out.println("This is test 3");
  }
  @Test(groups = {"Regression"})
  public void test4() {
	  System.out.println("This is test 4");
  }
  @Test(groups = {"Sanity","Regression"})
  public void test5() {
	  System.out.println("This is test 5");
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
