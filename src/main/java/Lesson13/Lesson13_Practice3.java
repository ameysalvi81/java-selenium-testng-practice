package Lesson13;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson13_Practice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.saucedemo.com");
            
            //Assert.assertTrue(driver.getTitle().contains("Swag Labs"));
    		if (!driver.getTitle().contains("Swag Labs")) {
    		    throw new RuntimeException("Title check failed");
    		}
            
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            
    		String heading = driver.findElement(By.className("title")).getText();
    		//Assert.assertTrue(heading.equalsIgnoreCase("Products"), "Heading was: " + heading);
    		if (!heading.equalsIgnoreCase("Products")) {
    		    throw new RuntimeException("Heading was: " + heading);
    		}
    		
    		List<WebElement> products = driver.findElements(By.className("inventory_item"));
    		System.out.println("Product shown: " + products.size());
            
        } finally {
        	driver.quit();
        }
	}

}
