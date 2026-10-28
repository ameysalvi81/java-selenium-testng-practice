package Lesson12;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	@BeforeClass
	public void classSetup() {
		System.out.println("CLASS SETUP: ");
	}
	
	@BeforeMethod
	public void setup() {
		System.out.println("SETUP: Opening browser");
	}
	
	@AfterMethod
	public void teardown() {
		System.out.println("TEARDWON: Closing browser");
	}
	
	@AfterClass
	public void classTeardown() {
		System.out.println("CLASS TEARDOWN: ");
	}
}
