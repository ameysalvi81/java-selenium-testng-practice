package Lesson12;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LifecycleTest {

	@BeforeClass
	public void classSetup() {
		System.out.println("CLASS SETUP: once before all tests");
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("SETUP: open browser");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("TEARDOWN: close browser");
	}
	
	@AfterClass
	public void classTeardown() {
		System.out.println("CLASS TEARDOWN: once for all tests");
	}
	
	@Test
	public void testOne() {
		System.out.println("Running test one");
	}
	
	@Test
	public void testTwo() {
		System.out.println("Running test two");
	}
	
}
