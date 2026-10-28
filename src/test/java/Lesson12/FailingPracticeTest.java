package Lesson12;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FailingPracticeTest {

	@Test
	public void failingTest() {
		try {
			Assert.assertEquals("Home", "Home");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
