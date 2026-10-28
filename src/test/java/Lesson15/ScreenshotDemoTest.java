package Lesson15;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Lesson14.BrowserTest;

public class ScreenshotDemoTest extends BrowserTest {

	@Test
	public void ScreenshotDemoTest1() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("wrong_password");
        driver.findElement(By.id("login-button")).click();

        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();
		Assert.assertTrue(error.contains("do not match"), "Error was: " + error);
	}
}
