package Lesson14;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.TimeoutException;



public class WaitTest extends BrowserTest {

    @Test (groups = {"smoke", "regression"})
    public void helloWorldShouldAppearAfterLoading() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        
        String text = driver.findElement(By.id("finish")).getText();
        Assert.assertEquals(text, "Hello World!");
    }
    
    @Test (groups = {"regression"})
    public void elementAddedLaterShouldAlsoWork() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.cssSelector("#start button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement finish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

        Assert.assertEquals(finish.getText(), "Hello World!");
    }
    
    @Test (groups = {"regression"})
    public void missingElementShouldTimeOut() {
    	driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    	
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
    	
    	boolean timedOut = false;
    	
    	try {
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doesNotExist")));    		
    	} catch (TimeoutException e) {
    		timedOut = true;
    		System.out.println("Element never appeared");
    	}
    	
    	Assert.assertTrue(timedOut,"Expected the wait to time out");
    }

}
