package Lesson14;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingPageTest extends BrowserTest {

	@Test
	public void Test1() {
		DynamicLoadingPage loadPage = new DynamicLoadingPage(driver);
		
		loadPage.Open();
		loadPage.clickStartButton();
		
		Assert.assertEquals(loadPage.getFinishText(), "Hello World!");
	}
	
}
