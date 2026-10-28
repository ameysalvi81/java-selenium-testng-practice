package Lesson14;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxPracticeTest extends BrowserTest {
	
	private String URL = "https://the-internet.herokuapp.com/checkboxes";

	private void setCheck(WebElement box, boolean shouldBeChecked) {
		if(box.isSelected() != shouldBeChecked) {
			box.click();
		}
	}
	
	@Test
	public void Test1() {
		driver.get(URL);
		
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("#checkboxes input"));
		WebElement first = checkboxes.get(0);
		WebElement second = checkboxes.get(1);
		
		setCheck(first, true);
		setCheck(second, false);
		Assert.assertTrue(first.isSelected());
		Assert.assertFalse(second.isSelected());
		
		setCheck(first, true);
		setCheck(second, false);
		Assert.assertTrue(first.isSelected());
		Assert.assertFalse(second.isSelected());
		
	}
	
	
}
