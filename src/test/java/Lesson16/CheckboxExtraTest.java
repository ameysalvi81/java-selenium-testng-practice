package Lesson16;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Lesson14.BrowserTest;

public class CheckboxExtraTest extends BrowserTest {

    @Test
    public void pageShouldHaveTwoCheckboxes() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        List<WebElement> boxes = driver.findElements(By.cssSelector("#checkboxes input"));

        Assert.assertEquals(boxes.size(), 2);
    }
}
