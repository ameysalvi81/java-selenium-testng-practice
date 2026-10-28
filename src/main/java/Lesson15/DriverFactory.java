package Lesson15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

	public static WebDriver createDriver() {
		
		String browser = ConfigReader.get("browser").toLowerCase();
		boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));
		
		if (browser.equals("chrome")) {			
			ChromeOptions options = new ChromeOptions();
            if (headless) {
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
            }
			return new ChromeDriver(options);			
		} else if (browser.equals("firefox")) {			
			FirefoxOptions options = new FirefoxOptions();
			if (headless) {
				options.addArguments("-headless");
			}
			return new FirefoxDriver(options);
		} else if (browser.equals("edge")) {					
			EdgeOptions options = new EdgeOptions();
			if(headless) {
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
			}
			return new EdgeDriver(options);
		} else {
			throw new IllegalArgumentException("Unsupported browser in config.properties: " + browser);
		}
	}
}
