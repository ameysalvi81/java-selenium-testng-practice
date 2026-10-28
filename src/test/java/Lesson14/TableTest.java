package Lesson14;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TableTest extends BrowserTest{

	private static final String URL = "https://the-internet.herokuapp.com/tables";
	
	@Test (groups = {"regression"})
	public void tableShouldHaveFourRowsAndSixColumns() {
		driver.get(URL);
		
		List<WebElement> headers = driver.findElements(By.cssSelector("#table1 thead th"));
		List<WebElement> rows = driver.findElements(By.cssSelector("#table1 tbody tr"));
				
		Assert.assertEquals(headers.size(), 6);
		Assert.assertEquals(rows.size(), 4);
	}
	
	@Test (groups = {"regression"})
	public void firstRowShouldBeSmithJohn() {
		driver.get(URL);
		
		List<WebElement> rows = driver.findElements(By.cssSelector("#table1 tbody tr"));
		List<WebElement> cells = rows.get(0).findElements(By.tagName("td"));
		
		Assert.assertEquals(cells.get(0).getText(), "Smith");
		Assert.assertEquals(cells.get(1).getText(), "John");	
		
	}
	
	
	@Test (groups = {"regression"})
	public void totalDueShouldBeCorrect() {
		driver.get(URL);
		
		List<WebElement> rows = driver.findElements(By.cssSelector("#table1 tbody tr"));
		
		double total = 0;
		
		for(WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			String dueText = cells.get(3).getText().replace("$", "");
			total = total + Double.parseDouble(dueText);
		}
		
		System.out.println("Totle due: " + total);
		Assert.assertEquals(total, 251.0,0.001);
	}
}
