package Lesson12;

public class Helper {

	public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static String generateEmail(String firstName, int id) {
        return firstName + id + "@test.com";
    }
}