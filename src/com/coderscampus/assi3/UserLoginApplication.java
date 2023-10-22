package com.coderscampus.assi3;

public class UserLoginApplication {

	private static UserService userService = new UserService();
	private static UserPage userPage = new UserPage();
		
	public static void main(String[] args) {
		int attempts = 0;
		
		while (attempts < 5) {
			String username = userPage.Username();
			String password = userPage.Password();
			attempts+=1;
			
			if (userService.isUserValid(username, password)) {
				welcome(username);
				break;
			} else {
				if (attempts == 5) {
					userPage.displayMessage("Too many failed login attempts, you are now locked out.");
					System.exit(0);
				}
				userPage.displayMessage("Invalid login, please try again.");
			}
		}
	}

	private static void welcome(String username) {
		User user;
		try {
			user = userService.getUser(username);
			userPage.welcomeMessage(user);
		} catch (Exception e) {
			userPage.displayMessage(e.getMessage());
		}
	}
	
}