package Lesson13;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceInvalidLoginTest extends BaseWebTest {

	@DataProvider (name = "loginData")
	public Object[][] loginData(){
		return new Object[][] {
			{"standard_user", "wrong", "do not match"},
			{"locked_out_user", "secret_sauce", "locked out"},
			{"", "secret_sauce", "Username is required"},
			{"standard_user", "", "Password is required"}
		};
	}
	
	@Test (dataProvider = "loginData")
	public void loginWithExpectedMessage(String username, String password, String exepctedMessage) {
		
		SauceLoginPage loginPage = new SauceLoginPage(driver);
		loginPage.login(username, password);
		
		String error = loginPage.getErrorText();
		Assert.assertTrue(error.contains(exepctedMessage),"Error was: " + error);		
	}
}
