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
		return CommerceDb.getInstance().checkEmailAlreadyExist(email);
	}
	public boolean addUser(User user) {
		return CommerceDb.getInstance().addUser(user);
	}
	public int login(String email, String password) {
		return CommerceDb.getInstance().login(email, password);
	}
	
}
