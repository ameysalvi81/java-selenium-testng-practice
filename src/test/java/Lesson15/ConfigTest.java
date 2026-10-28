package Lesson15;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigTest {

	@Test
	public void baseUrlShouldBeLoaded() {
		Assert.assertEquals(ConfigReader.get("baseUrl"), "https://www.saucedemo.com");
	}
	
	@Test
    public void missingKeyShouldThrowClearError() {
        try {
            ConfigReader.get("doesNotExist");
            Assert.fail("Expected an exception for a missing key");
        } catch (RuntimeException e) {
            Assert.assertTrue(e.getMessage().contains("Missing key"));
        }
    }

}
