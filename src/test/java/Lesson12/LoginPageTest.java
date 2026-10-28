package Lesson12;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

	@Test
	public void validLoginShouldSucceed() {
		LoginPage loginPage = new LoginPage();
		loginPage.login(new User("admin", "admin123"));
		
		Assert.assertTrue(loginPage.isLoginSuccessful(),"Valid login should succeed");
	}
	
	@Test
	public void invalidLoginShouldBeRejected() {
		LoginPage loginPage = new LoginPage();
		loginPage.login(new User("admin", "wrong"));
		
		Assert.assertFalse(loginPage.isLoginSuccessful(),"Invalid login should be rejected");
	}
	
	@Test
	public void loginPageTitleShouldBeCorrect() {
		LoginPage loginPage = new LoginPage();
		
		Assert.assertEquals(loginPage.getTitle(), "Login Page");
	}
}
