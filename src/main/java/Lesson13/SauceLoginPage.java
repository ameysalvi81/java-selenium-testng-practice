package Lesson13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceLoginPage {

	private WebDriver driver;
	
	private By usernameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By loginButton	= By.id("login-button");
	private By errorMessage = By.cssSelector("[data-test='error']");
	
	public SauceLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
	
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}
	
	public String getErrorText() {
		return driver.findElement(errorMessage).getText();
	}	
}
