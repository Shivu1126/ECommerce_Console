package feature;

import feature.auth.AuthView;
import repostiory.db.CommerceDb;
import repostiory.dto.Product;

public class Main {

	public static void main(String[] args) {
		CommerceDb.getInstance().addProducts(
				new Product(0, "Mobile", 13000, "Electronics", 193539319, 293539319, 10, 0)
				);
		CommerceDb.getInstance().addProducts(
				new Product(0, "Bat", 3000, "Sports", 193539319, 293539319, 5, 0)
				);
		CommerceDb.getInstance().addProducts(
				new Product(0, "Laptop", 13000, "Electronics", 193539319, 293539319, 3, 0)
				);
		CommerceDb.getInstance().addProducts(
				new Product(0, "MindSet", 13000, "Books", 193539319, 293539319, 8, 0)
				);
		CommerceDb.getInstance().addProducts(
				new Product(0, "Rice", 13000, "Grocery", 193539319, 293539319, 5, 0)
				);
		
		new AuthView().authView();
	}

}
