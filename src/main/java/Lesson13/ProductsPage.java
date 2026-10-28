package Lesson13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
	
	private WebDriver driver;
	
	private By heading = By.cssSelector("[data-test='title']");
	private By productItems = By.className("inventory_item");
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getHeading() {
		return driver.findElement(heading).getText();
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public int getProductCount() {
		return driver.findElements(productItems).size();
	}
}
