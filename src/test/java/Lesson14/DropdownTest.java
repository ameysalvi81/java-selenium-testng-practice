package Lesson14;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BrowserTest {

	private static final String URL = "https://the-internet.herokuapp.com/dropdown";
	
	@Test (groups = {"regression"})
	public void defalutOptionShouldBePlaceholder() {
		driver.get(URL);
		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Please select an option");
	}
	
	@Test (groups = {"smoke", "regression"})
	public void selectingOptionTwoShouldWork() {
		driver.get(URL);
		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		
		dropdown.selectByVisibleText("Option 2");
		
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2" );
	}
	
	@Test (groups = {"regression"})
	public void dropdownShouldHaveThreeOptions() {
		driver.get(URL);
		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		
		List<WebElement> options = dropdown.getOptions();
		Assert.assertEquals(options.size(), 3);
		
		for (WebElement option : options) {
			System.out.println("Option: " + option.getText());
		}
	}
	
}
