package Lesson12;

public class User {
	
	String username;
	String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public void printDetails() {
		System.out.println("Username: " + username + " | Password lenght: " + password.length());
	}
	
	public boolean hasStrongPassword() {
		return password.length() >= 8;
	}

}
