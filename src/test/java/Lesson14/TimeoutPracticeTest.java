package Lesson14;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeoutPracticeTest extends BrowserTest {

	@Test
	public void Test1() {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		
		boolean timeOut = false;
		
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finish"))));
		} catch (TimeoutException e) {
			timeOut = true;
			System.out.println("Timed out exception");
		}
		
		Assert.assertTrue(timeOut);
		
		
	}
}
