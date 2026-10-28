package Lesson14;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertPracticeTest extends BrowserTest{

	private static final String URL = "https://the-internet.herokuapp.com/javascript_alerts";
	
	private Alert waitForAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	@Test
	public void Test1() {
		driver.get(URL);
		
		driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
		
		waitForAlert().accept();
		
		Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Ok");
		
	}
	
	@Test
	public void Test2() {
		driver.get(URL);
		
		driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
		
		waitForAlert().dismiss();
		
		Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: null");
	}
	
}
