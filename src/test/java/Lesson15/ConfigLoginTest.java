package Lesson15;

import org.testng.Assert;
import org.testng.annotations.Test;

import Lesson13.BaseWebTest;
import Lesson13.SauceLoginPage;

public class ConfigLoginTest extends BaseWebTest {

	@Test
	public void loginWithConfigCredentialsShouldWork() {
		
		SauceLoginPage loginPage = new SauceLoginPage(driver);
		
		String username = ConfigReader.get("username");
		String password = ConfigReader.get("password");
		
		loginPage.login(username, password);
		
		boolean assertUrl = driver.getCurrentUrl().endsWith("inventory.html");
		
		Assert.assertTrue(assertUrl);
	}
}
