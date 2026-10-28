package Lesson14;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TablePracticeTest extends BrowserTest {

	private static final String URL = "https://the-internet.herokuapp.com/tables";
	
	private List<WebElement> getRows() {
		return driver.findElements(By.cssSelector("#table1 tbody tr "));
	}
	
	
	@Test
	public void Test1() {
		driver.get(URL);
		
		List<WebElement> rows = getRows();
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			System.out.println(cells.get(0).getText() + "," + cells.get(1).getText() + "," + cells.get(3).getText());
		}
	}
	
	private String getEmailByLastName(String lastName) {
		List<WebElement> rows = getRows();
		
		for (WebElement row:rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
		
			if (cells.get(0).getText().equals(lastName)) {
				return cells.get(2).getText();
			}
			
		}
		
		return null;
	}
	
	@Test
	public void Test2() {
		driver.get(URL);
		
		Assert.assertEquals(getEmailByLastName("Conway"), "tconway@earthlink.net");
	}
	
	@Test
	public void Test3() {
		driver.get(URL);
		
		int count = 0;
		
		for (WebElement row : getRows()) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			double due = Double.parseDouble(cells.get(3).getText().replace("$",""));
			if ( due>50) {
				count++;
			}
		}
		
		Assert.assertEquals(count, 2);
	}
	
	
}
