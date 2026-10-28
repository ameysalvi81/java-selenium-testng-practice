package Lesson13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson13_FirstBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com");
		
		System.out.println("Title: " + driver.getTitle());
		System.out.println("URL: " + driver.getCurrentUrl());
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
