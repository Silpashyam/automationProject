package annotations;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomDataProvider {
	@DataProvider(name="LoginDataProvider")
	public Object[][] getData()
	{
		Object[][] data= {{"abc@gmail.com","abc"},{"xyz@gmail.com","xyz"}};
		return data;
	}
 
}
