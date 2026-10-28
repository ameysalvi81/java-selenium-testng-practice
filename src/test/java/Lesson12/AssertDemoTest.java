package Lesson12;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertDemoTest {

	@Test
	public void titleShouldMatch() {
		String actualTitle = "Login Page";
		Assert.assertEquals(actualTitle, "Login Page", "Title is wrong on login screen");
	}
	
	@Test
	public void totalShouldBeCorrect() {
		int price = 250;
		int quantity = 4;
		Assert.assertEquals(price*quantity,1000);
	}
	
	@Test
	public void messageShouldContainName() {
		String message = "Welcome, John!";
		Assert.assertTrue(message.contains("John"), "Greeting should contain the name");		
	}
	
	@Test
	public void errorShouldNotBeShown() {
		boolean errorVisible = false;
		Assert.assertFalse(errorVisible);
	}
}
