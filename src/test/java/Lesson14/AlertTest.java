package Lesson14;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BrowserTest {

	private static final String URL = "https://the-internet.herokuapp.com/javascript_alerts";
	
	private Alert waitForAlert() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	@Test (groups = {"regression"})
	public void simpleAlertShouldBeAccepted() {
		driver.get(URL);
		
		By jsAlertButtonElement = By.cssSelector("button[onclick='jsAlert()']");
		
		driver.findElement(jsAlertButtonElement).click();

		Alert alert = waitForAlert();
		Assert.assertTrue(alert.getText().contains("JS Alert"));
		alert.accept();
		
		By resultTextElement = By.id("result");
		
		String resultText = driver.findElement(resultTextElement).getText();
		
		Assert.assertEquals(resultText,"You successfully clicked an alert");
	}
	
	@Test (groups = {"regression"})
	public void confirmShouldBeDismissed() {
		driver.get(URL);
		
		By jsConfrimButtonElement = By.cssSelector("button[onclick='jsConfirm()']");
		
		driver.findElement(jsConfrimButtonElement).click();
		
		Alert alert = waitForAlert();
		alert.dismiss();
		
		String result = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(result, "You clicked: Cancel");
	}
	
	@Test (groups = {"regression"})
	public void promptShouldAcceptTypedText() {
		driver.get(URL);
		
		driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
		
		Alert alert = waitForAlert();
		alert.sendKeys("Hello");
		alert.accept();
		
		String result = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(result, "You entered: Hello");
		
		
	}
}
