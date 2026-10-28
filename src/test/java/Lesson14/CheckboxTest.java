package Lesson14;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest extends BrowserTest{

	@Test (groups = {"regression"})
	public void checkboxesShouldToggle() {
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		
		By checkboxElement = By.cssSelector("#checkboxes input");
		List<WebElement> boxes = driver.findElements(checkboxElement);
		
		WebElement first = boxes.get(0);
		WebElement second = boxes.get(1);
		
        Assert.assertFalse(first.isSelected(), "Checkbox 1 should start unticked");
        Assert.assertTrue(second.isSelected(), "Checkbox 2 should start ticked");

        first.click();
        second.click();

        Assert.assertTrue(first.isSelected(), "Checkbox 1 should now be ticked");
        Assert.assertFalse(second.isSelected(), "Checkbox 2 should now be unticked");
	}
	
	@Test (groups = {"regression"})
	public void ensureBothTickedWithoutBlindClicking() {
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		
		By checkBoxElement = By.cssSelector("#checkboxes input");
		List<WebElement> boxes = driver.findElements(checkBoxElement);
		
		for (WebElement box : boxes) {
			if (!box.isSelected()) {
				box.click();
			}
		}
		
		for (WebElement box : boxes)	{
			Assert.assertTrue(box.isSelected());
		}
	}
	
}
