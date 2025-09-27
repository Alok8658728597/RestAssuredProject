package Session31DataDriven;

import org.testng.annotations.DataProvider;

public class DataProviderClass{
	@DataProvider(name="userData")
	public Object[][] getLoginData() {
		return new Object[][] {{"kminchelle","kilimanjaro"}};
	}
	}