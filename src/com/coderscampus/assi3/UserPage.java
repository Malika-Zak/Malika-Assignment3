package com.coderscampus.assi3;

import java.util.Scanner;

public class UserPage {
	
	private Scanner scanner = new Scanner(System.in);

	public String Username() {
		System.out.print("Enter your Email: ");
		return scanner.nextLine();
	}

	public String Password() {
		System.out.print("Enter your Password: ");
		return scanner.nextLine();
	}

	public void correctCredentials(User user) {
		System.out.println("Welcome " + user.getName());
	}
	public void displayMessage(String message) {
		System.out.println(message);
	}
	public void welcomeMessage(User user) {
		System.out.println("Welcome " + user.getName());
	}

	
	

}