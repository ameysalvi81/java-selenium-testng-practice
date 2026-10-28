package Lesson14;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownPracticeTest extends BrowserTest{

	private String url = "https://the-internet.herokuapp.com/dropdown";
	
	@Test
	public void test1() {
		driver.get(url);
		
		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		dropdown.selectByIndex(1);
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Option 1");
		
	}
	
	@Test
	public void test2() {
		driver.get(url);
		
		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		dropdown.selectByIndex(2);
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Option 2");
		
	}
	
	@Test
	public void test3() {
		driver.get(url);
		
		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		
		Assert.assertEquals(dropdown.getOptions().get(0).getText(),"Please select an option");
		
	}
}
