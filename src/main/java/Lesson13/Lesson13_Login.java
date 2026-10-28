package Lesson13;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson13_Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://www.saucedemo.com");
			
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.id("login-button")).click();
			
			System.out.println("URL after login: " + driver.getCurrentUrl());
			String heading = driver.findElement(By.className("title")).getText();			
			System.out.println("Page heading: " + heading);
		} finally {
			driver.quit();
		}
	}

}
