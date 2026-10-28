package Lesson12;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringTest {

	@Test
	public void titleShouldMatch() {
		String actualTitle = "Home Page";
		Assert.assertEquals(actualTitle, "Home Page");
	}
	
	@Test
	public void messageShouldContainName() {
		String greet = "Welcome, John!";
		Assert.assertTrue(greet.contains("John"));
	}
	
	@Test
	public void lengthShouldBeTen() {
		String page = "Login Page";
		Assert.assertEquals(page.length(),10);
	}
}
