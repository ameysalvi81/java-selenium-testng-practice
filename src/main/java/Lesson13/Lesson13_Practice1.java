package Lesson13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson13_Practice1 {
	
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.saucedemo.com");
            
            String title = driver.getTitle();
            String url = driver.getCurrentUrl();
            
            System.out.println("Title is " + title);
            System.out.println("URL is " + url);
           
        } finally {
        	driver.quit();
        }
        

        
    }
    
}
