package Lesson12;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

public class EvenDataTest {

	@DataProvider (name = "evenData")
	public Object[][] data() {
		return new Object [][] {
			{2, true},
			{3, true},
			{10, true}, 
			{0, true}
		};
	}
	
	@Test (dataProvider = "evenData")
	public void evenDataShouldResult(int number, boolean expected) {
		Assert.assertEquals(Helper.isEven(number), expected);
	}
}
