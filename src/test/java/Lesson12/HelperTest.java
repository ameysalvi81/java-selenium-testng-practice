package Lesson12;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HelperTest {

	@Test
	public void fourShouldBeEven() {
		Assert.assertTrue(Helper.isEven(4));
	}
	
	@Test
	public void sevenShouldBeEven() {
		Assert.assertFalse(Helper.isEven(7));
	}
	
	@Test
	public void generateEmailTest() {
		Assert.assertEquals(Helper.generateEmail("john", 101),"john101@test.com");
	}
}
