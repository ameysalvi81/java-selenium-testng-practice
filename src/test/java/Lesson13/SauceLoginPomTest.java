package Lesson13;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceLoginPomTest extends BaseWebTest {
	
	@Test
	public void validLoginShouldOpenProdcutsPage() throws InterruptedException {
		
		SauceLoginPage loginPage = new SauceLoginPage(driver);		
		loginPage.login("standard_user", "secret_sauce");
	
		ProductsPage productsPage = new ProductsPage(driver);
		Assert.assertTrue(productsPage.getHeading().equalsIgnoreCase("Products"));
		Assert.assertTrue(productsPage.getUrl().endsWith("inventory.html"));
	}
	
	@Test (groups = {"regression"})
	public void wrongPasswordShouldShowError() {
		
		SauceLoginPage loginPage = new SauceLoginPage(driver);
		loginPage.login("standard_user", "wrong_password");		
		
		Assert.assertTrue(loginPage.getErrorText().contains("do not match"));
	}
	
	@Test (groups = {"regression"})
	public void productsPageShouldShowSixItems() {
		
		SauceLoginPage loginPage = new SauceLoginPage(driver);		
		loginPage.login("standard_user", "secret_sauce");
		
		ProductsPage productPage = new ProductsPage(driver);
		Assert.assertEquals(productPage.getProductCount(), 6);
	}
}
