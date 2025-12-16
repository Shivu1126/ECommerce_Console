package feature.auth;

import java.util.ArrayList;
import java.util.List;

import feature.base.BaseView;
import feature.home.HomeView;
import repostiory.dto.User;

public class AuthView extends BaseView{
	private AuthConroller controller;
	public AuthView() {
		controller = new AuthConroller(this);
	}
	public void authView() {
		
		while(true) {
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			try {
				int option = Integer.parseInt(getScanner().nextLine());
				switch(option) {
					case 1:
						login();
						break;
					case 2:
						register();
						break;
					case 3:
						System.out.println("Thank you");
						return;
					default:
						System.out.println("Enter 1 to 3 only");
				}
			}catch (Exception e) {
				System.out.println("Enter proper input");
			}
		}
	}
	private void register() {
		System.out.println("Enter your name");
		String name = getScanner().nextLine();
		System.out.println("Enter yout mobile number");
		String mobile = getScanner().nextLine();
		System.out.println("Enter email id");
		String email = getScanner().nextLine();
		while(controller.checkEmailAlreadyExist(email)) {
			System.out.println("Email id already exist");
			System.out.println("Re-Enter email id");
			email = getScanner().nextLine();
		}
		System.out.println("Create password");
		String password = getScanner().nextLine();
		System.out.println("Enter address");
		String address = getScanner().nextLine();
//		List<String> addresses = new ArrayList<>();
//		addresses.add(address);
		controller.addUser(name, mobile, email, password, address);
	}
	private void login() {
		System.out.println("Enter email id");
		String email = getScanner().nextLine();
		System.out.println("Enter password");
		String password = getScanner().nextLine();
		controller.login(email, password);
	}
	public void showMessage(String message) {
		System.out.println(message);
	}
	public void homeView(int userId) {
//		System.out.println("Log: "+userId);
		new HomeView(userId).homeView();
	}
}
