package Lesson12;

import org.testng.annotations.Test;

public class PriorityTest {

	@Test (priority = 2, description = "Enter username and password")
	public void enterCredentials() {
		System.out.println("Step 2: enter credentials");
	}
	
	@Test (priority = 1, description = "Open the login page")
	public void openLoginPage() {
		System.out.println("Step 1: open login page");
	}
	
	@Test (priority = 3)
	public void submitForm() {
		System.out.println("Step 3: submit");
	}
	
	@Test (enabled = false)
	public void featureNotReady() {
		System.out.println("This never runs");
	}
}
