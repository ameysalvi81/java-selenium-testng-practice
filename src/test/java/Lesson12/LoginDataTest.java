package Lesson12;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDataTest extends BaseTest {

	@DataProvider (name = "loginData")
	public Object[][] loginData(){
		return new Object[]	[] {
			{"admin","admin123",true},
            {"admin", "wrong", false},
            {"john", "pass", false}
		};
	}
	
	@Test (dataProvider = "loginData")
	public void loginShouldMatchExpectedResult(String username, String password, boolean expectedSuccess) {
		
		LoginPage loginPage = new LoginPage();
		loginPage.login(new User(username,password));
		
		Assert.assertEquals(loginPage.isLoginSuccessful(), expectedSuccess);
	}
}
