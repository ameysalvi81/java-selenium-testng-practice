package Lesson12;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FailingDemo {

	@Test
	public void wrongTitle() {
		String actualTitle = "Home Page";
		Assert.assertEquals(actualTitle, "Login Page");
	}
	
	@Test
	public void stopAtFirstFailure() {
		System.out.println("Step 1");
		Assert.assertEquals(2+2, 5);
		System.out.println("Step 2");
	}
	
	@Test
	public void thisOneStillRuns() {
		System.out.println("This test is independent and still runs");
		Assert.assertTrue(true);
	}
}
