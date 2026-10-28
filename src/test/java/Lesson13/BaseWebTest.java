package Lesson13;

import java.time.Duration;

import org.testng.annotations.BeforeMethod;

import Lesson14.BrowserTest;
import Lesson15.ConfigReader;

public class BaseWebTest extends BrowserTest {

	@BeforeMethod
	public void openBaseUrl() {
		
		int seconds = ConfigReader.getInt("implicitWaitSeconds");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		driver.get(ConfigReader.get("baseUrl"));

	}
}
