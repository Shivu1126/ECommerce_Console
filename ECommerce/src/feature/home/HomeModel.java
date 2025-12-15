package feature.home;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import repostiory.db.CommerceDb;
import repostiory.dto.Cart;
import repostiory.dto.CartEntry;
import repostiory.dto.Order;
import repostiory.dto.Product;
import repostiory.dto.Status;
import repostiory.dto.User;

public class HomeModel {
	private static int cartId = 1;
	private static int orderId = 1;
	private HomeController controller;
	private User user;
	public HomeModel(HomeController controller, User user) {
		this.controller = controller;
		this.user = user;
	}

	public List<Product> getAllProduct() {
		Map<Integer, Product> products = CommerceDb.getInstance().getProducts();
		List<Product> productList = new ArrayList<>();
		for (Map.Entry<Integer, Product> entry : products.entrySet()) {
			Product product = entry.getValue();
			if(product.getStockCount()>0)
				productList.add(product);
		}
		return productList;
	}

	public boolean checkProId(int proId, int quantity) {
		Map<Integer, Product> products = CommerceDb.getInstance().getProducts();
		return products.containsKey(proId) && products.get(proId).getStockCount()>=quantity;
	}

	public Product getProductById(int proId) {
		return CommerceDb.getInstance().getProducts().get(proId);
	}

	public int addNewCart(List<CartEntry> carts) {
		int currCartId = cartId;
		Cart cart = new Cart(cartId++,user.getUserId(), carts);
		user.addCart(cart);
		return currCartId;
	}

	public List<Cart> getCarts() {
		return user.getCarts();
	}

	public Cart getCartById(int id) {
		List<Cart> carts = user.getCarts();
		for(Cart cart : carts)
			if(cart.getCartId()==id)
				return cart;
		return null;
	}

	public void placeOrder(int orderedCartId) {
		Order order = new Order(
				orderId++, getCartById(orderedCartId), System.currentTimeMillis(),
				System.currentTimeMillis() + 3*(1800000000) , 
				Status.ORDERED, System.currentTimeMillis()
				);
		CommerceDb.getInstance().addOrder(order);
		user.getOrders().add(order);
		
	}

}
