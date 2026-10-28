package Lesson15;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Lesson13.BaseWebTest;
import Lesson13.SauceLoginPage;

public class FailureShotTest extends BaseWebTest {

	@Test
	public void headingCheckThatFailsOnPurpose() {

		SauceLoginPage loginPage = new SauceLoginPage(driver);
		
		String username = ConfigReader.get("username");
		String password = ConfigReader.get("password");
		
		loginPage.login(username, password);
		
		String heading = driver.findElement(By.className("title")).getText();
		
		//Assert.assertEquals(heading, "Wrong Heading");
		Assert.assertTrue(heading.equalsIgnoreCase("Products"), "Heading was: " + heading);
	}
}
