package Lesson13;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceCartTest extends BaseWebTest {

	@Test (groups = {"regression"})
	public void addProductToCart() {
		
	    driver.findElement(By.id("user-name")).sendKeys("standard_user");
	    driver.findElement(By.id("password")).sendKeys("secret_sauce");
	    driver.findElement(By.id("login-button")).click();
	    
		String heading = driver.findElement(By.className("title")).getText();
		Assert.assertTrue(heading.equalsIgnoreCase("Products"), "Heading was: " + heading);
		
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		String badge = driver.findElement(By.className("shopping_cart_badge")).getText();
		Assert.assertEquals(badge, "1", "Cart badge count is wrong");
		
	}

}
