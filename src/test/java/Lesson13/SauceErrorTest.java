package Lesson13;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SauceErrorTest extends BaseWebTest {

	@Test (groups = {"regression"})
	public void emptyUsernameShouldShowError() {

        
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        
        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        //System.out.println(error);
        Assert.assertTrue(error.contains("Username is required"));
        
	}
	
	@Test (groups = {"regression"})
	public void emptyPasswordShouldShowError() {
        
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        
        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        //System.out.println(error);
        Assert.assertTrue(error.contains("Password is required"));
	}
}
