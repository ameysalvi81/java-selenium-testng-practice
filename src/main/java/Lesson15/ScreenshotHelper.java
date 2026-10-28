package Lesson15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotHelper {

	public static String capture(WebDriver driver,String testName) {
		try {
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			Path sourcePath = source.toPath();
			
			Path folder = Paths.get("screenshots");
			Files.createDirectories(folder);
			
			String fileName = testName + "_" + System.currentTimeMillis() + ".png";
			Path targetPath = folder.resolve(fileName);

			Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
			
			String target = targetPath.toString();
			return target;
			
		} catch (IOException e) {
			System.out.println("Could not save screenshot: " + e.getMessage());
			return null;
		}
	}
}
