package Lesson12;

public class LoginPage extends BasePage{

	String enteredUsername;
	String enteredPassword;
	
	public void enterUsername(String username) {
		enteredUsername = username;
		System.out.println("Typing username: " + username);
	}
	
	public void enterPassword(String password) {
		enteredPassword = password;
		System.out.println("Typing password: *****");
	}
	
	public void clickLogin() {
		System.out.println("Clicking Login button");
	}
	
	public boolean isLoginSuccessful() {
		return enteredUsername.equals("admin") && enteredPassword.equals("admin123");
	}
	
	public void login(User user) {
		enterUsername(user.username);
		enterPassword(user.password);
		clickLogin();
	}
	
	@Override
	public String getTitle() {
		return "Login Page";
	}
	
}
