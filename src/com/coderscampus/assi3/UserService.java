package com.coderscampus.assi3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserService {
	
	public User getUser(String username) throws Exception {
		User[] users = getUsers();
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				return user;
			}
		}
		throw new Exception("User is not found.");
	}

	private User[] getUsers() {
		User[] users = new User[4];
		BufferedReader fileReader = null;
		BufferedReader bufferedReader;
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			bufferedReader = new BufferedReader(fileReader);
			String line;
			int i = 0;
			while ((line = bufferedReader.readLine()) != null) {
				users[i] = createUserFromString(line);
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return users;

	}

	private User createUserFromString(String line) {
		String[] user = line.split(",");
		String username = user[0];
		String password = user[1];
		String name = user[2];
		return new User(username, password, name);
	}
	
	public boolean isUserValid(String username, String password) {
		boolean isValid = false;
		User[] users = getUsers();
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username) && 
					user.getPassword().equals(password)) {
				isValid = true;
			}
		}
		return isValid;
	}

}