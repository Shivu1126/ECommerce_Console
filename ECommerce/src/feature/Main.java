package feature;

import feature.auth.AuthView;
import repostiory.db.CommerceDb;
import repostiory.dto.Product;

public class Main {

	public static void main(String[] args) {
		new AuthView().authView();
	}

}
