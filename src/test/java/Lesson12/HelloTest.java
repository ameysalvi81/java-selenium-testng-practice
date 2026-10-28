package Lesson12;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloTest {

	@Test
	public void helloTest() {
		System.out.println("Hello from TestNG");
		
		Assert.assertTrue(5>3);
	}
	
	
}
