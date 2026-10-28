package Lesson14;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Lesson15.ConfigReader;
import Lesson15.DriverFactory;
import Lesson15.ScreenshotHelper;

public class BrowserTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
    	
        driver = DriverFactory.createDriver();
        
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("baseUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser(ITestResult result) {
        if (driver != null) {
        	if (result.getStatus() == ITestResult.FAILURE) {
        		String screenshot = ScreenshotHelper.capture(driver, result.getName());
        		System.out.println("Screenshot saved: " + screenshot);
        	}
            driver.quit();
        }
    }
}
