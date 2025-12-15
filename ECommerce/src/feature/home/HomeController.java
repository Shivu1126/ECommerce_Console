package feature.home;

import java.util.List;

import repostiory.dto.Cart;
import repostiory.dto.CartEntry;
import repostiory.dto.Product;
import repostiory.dto.User;

public class HomeController {
	private HomeView view;
	private HomeModel model;
	public HomeController(HomeView homeView, User user) {
		view = homeView;
		model = new HomeModel(this, user);
	}
	public void viewAllProduct() {
		view.showAllProduct(model.getAllProduct());
	}
	public void orderHistory() {
		// TODO Auto-generated method stub
		
	}
	public boolean checkProId(int proId, int quantity) {
		
		return model.checkProId(proId, quantity);
	}
	public Product getProductById(int proId) {
		return model.getProductById(proId);
	}
	public int addNewCart(List<CartEntry> carts) {
		int cartId = model.addNewCart(carts);
		view.showMessage("New Cart Created Successfully");
		return cartId;
	}
	public List<Cart> getCarts() {
		return model.getCarts();
	}
	public Cart checkCartId(int cartId) {
		return model.getCartById(cartId);
	}
	public void placeOrder(int cartId) {
		model.placeOrder(cartId);
		view.showMessage("Order succssfully placed");
	}

}
