package Lesson12;

import org.testng.annotations.Test;

public class ShoppingFlowTest {

	@Test (priority = 1)
	public void login() {
		System.out.println("1. Login");
	}
	
	@Test (priority = 2)
	public void addToCart() {
		System.out.println("2. Add to cart");
	}
	
	@Test (priority = 3)
	public void checkout() {
		System.out.println("3. Checkout");
	}
	
	@Test (enabled = false)
	public void oldFeature() {
		System.out.println("");
	}
}
