package feature.home;

import java.util.List;

import repostiory.dto.Cart;
import repostiory.dto.CartEntry;
import repostiory.dto.Product;
import repostiory.dto.User;

public class HomeController {
	private HomeView view;
	private HomeModel model;
	public HomeController(HomeView homeView, int userId) {
		view = homeView;
		model = new HomeModel(this, userId);
	}
	public void viewAllProduct() {
		view.showAllProduct(model.getAllProduct());
	}
	public void orderHistory() {
		
	}
	public boolean isProductAvailable(int proId, int quantity) {
		return model.isProductAvailable(proId, quantity);
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
	public boolean getProductDetail(int proId, int quantity) {
		Product product = model.getProductById(proId);
		view.showPurchasingProductDetail(product, quantity);
		return product !=null;
	}
	public void placeTheOrder(int proId, int quantity, int paymentType) {
		if(model.placeTheOrder(proId, quantity, paymentType))
			view.showMessage("Your order placed successfully...");
		else
			view.showMessage("Something went wrong in your order");
	}

}
