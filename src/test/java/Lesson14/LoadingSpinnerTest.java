package Lesson14;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoadingSpinnerTest extends BrowserTest {

	@Test
	public void test1() {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		driver.findElement(By.cssSelector("#start button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
		
		String text = driver.findElement(By.id("finish")).getText();
		Assert.assertEquals(text, "Hello World!");
	}
}
