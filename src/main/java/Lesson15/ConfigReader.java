package Lesson15;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties = new Properties(); 
	
	static {
		try (FileInputStream  input = new FileInputStream("config.properties")) {
			properties.load(input);
		} catch (IOException e) {
			throw new RuntimeException("Cound not read config.properties: " + e.getMessage());
		}
	}
	
	public static String get(String key) {

		String fromCommandLine = System.getProperty(key);
				
		if(fromCommandLine != null && !fromCommandLine.trim().isEmpty()){
			return fromCommandLine.trim();
		}
		
		String value = properties.getProperty(key);
		
		if (value == null)
		{
			throw new RuntimeException("Missing key in config.properties: " + key);
		}
		
		return value.trim();
	}
	
	public static int getInt(String key) {
		String value = get(key);
		
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new RuntimeException("Config value for " + key + " must be a whole number but was: " + value);
		}
	}
}