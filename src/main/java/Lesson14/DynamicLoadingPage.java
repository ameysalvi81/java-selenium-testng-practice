package Lesson14;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage {

	private WebDriver driver;
	
	public DynamicLoadingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void Open() {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
	}
	
	public void clickStartButton() {
		By startButton = By.cssSelector("#start button");
		driver.findElement(startButton).click();
	}
	
	public String getFinishText() {
		By finishText = By.id("finish");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(finishText)));
		return driver.findElement(finishText).getText();
				
	}
}
