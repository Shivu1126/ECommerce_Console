package feature.auth;

import java.util.List;

import repostiory.dto.User;

public class AuthConroller {

	private AuthView view;
	private AuthModel model;
	public AuthConroller(AuthView authView) {
		view = authView;
		model = new AuthModel(this);
	}
	public boolean checkEmailAlreadyExist(String email) {
		// TODO Auto-generated method stub
		return model.checkEmailAlreadyExist(email);
	}
	public void addUser(String name, String mobile, String email, String password, List<String> addresses) {
		User user = new User(0, password, name, mobile, email, addresses);
		model.addUser(user);
		view.showMessage("User Register successfully..");
	}
	public void login(String email, String password) {
		User user = model.login(email, password);
		if(user==null)
			view.showMessage("User doesn't exist");
		else
			view.homeView(user);
	}

}
