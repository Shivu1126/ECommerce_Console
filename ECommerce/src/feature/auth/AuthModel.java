package feature.auth;

import java.util.Map;

import repostiory.db.CommerceDb;
import repostiory.dto.User;

public class AuthModel {

	private AuthConroller controller;
	public AuthModel(AuthConroller authConroller) {
		controller = authConroller;
	}
	public boolean checkEmailAlreadyExist(String email) {
		Map<Integer, User> users = CommerceDb.getInstance().getUsers();
		
		for (Map.Entry<Integer, User> entry : users.entrySet()) {
			User user = entry.getValue();
			if(user.getEmail().equals(email)) 
				return true;
		}
		return false;
	}
	public void addUser(User user) {
		CommerceDb.getInstance().addUser(user);
	}
	public User login(String email, String password) {
		Map<Integer, User> users = CommerceDb.getInstance().getUsers();
		for (Map.Entry<Integer, User> entry : users.entrySet()) {
			User user = entry.getValue();
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) 
				return user;
		}
		
		return null;
	}
	
}
