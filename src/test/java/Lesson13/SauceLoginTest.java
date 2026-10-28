package Lesson13;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Lesson14.BrowserTest;

public class SauceLoginTest extends BrowserTest {

	@Test (groups = {"smoke","regression"})
	public void validLoginShouldOpenProdcutsPage() {
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		
		String heading = driver.findElement(By.className("title")).getText();
		Assert.assertTrue(heading.equalsIgnoreCase("Products"), "Heading was: " + heading);
	}
	
	@Test (groups = {"regression"})
	public void wrongPasswordShouldShowError() {
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("wrong_password");
		driver.findElement(By.id("login-button")).click();
		
        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertTrue(error.contains("do not match"), "Unexpected error text: " + error);
	}
	
    @Test (groups = {"regression"})
    public void lockedOutUserShouldSeeMessage() {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertTrue(error.contains("locked out"), "Unexpected error text: " + error);
    }

}
