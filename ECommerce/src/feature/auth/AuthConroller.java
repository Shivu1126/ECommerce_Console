package feature.auth;

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
	public void addUser(String name, String mobile, String email, String password, String address) {
		User user = new User(name, mobile, email, password, address);
		if(model.addUser(user))
			view.showMessage("User Register successfully..");
		else
			view.showMessage("Error on registeration..Please check your details..");
	}
	public void login(String email, String password) {
		int userId = model.login(email, password);
		if(userId==0)
			view.showMessage("User doesn't exist");
		else
			view.homeView(userId);
	}

}
