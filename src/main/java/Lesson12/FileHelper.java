package Lesson12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class FileHelper {

	public static ArrayList<String> readlines(String path) {
		
		ArrayList<String> lines = new ArrayList<String>();
		
		try {
			Scanner scanner = new Scanner(new File(path));
			while (scanner.hasNextLine()) {
				lines.add(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + path);
		}
		
		return lines;

	}
}
