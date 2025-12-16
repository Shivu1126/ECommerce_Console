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
	private int userId;
	public HomeModel(HomeController controller, int userId) {
		this.controller = controller;
		this.userId = userId;
	}

	public List<Product> getAllProduct() {
//		Map<Integer, Product> products = CommerceDb.getInstance().getProducts();
//		List<Product> productList = new ArrayList<>();
//		for (Map.Entry<Integer, Product> entry : products.entrySet()) {
//			Product product = entry.getValue();
//			if(product.getStockCount()>0)
//				productList.add(product);
//		}
		return CommerceDb.getInstance().getProducts();
	}

	public boolean isProductAvailable(int proId, int quantity) {
//		Map<Integer, Product> products = CommerceDb.getInstance().getProducts();
//		return products.containsKey(proId) && products.get(proId).getStockCount()>=quantity;
		return CommerceDb.getInstance().isProductAvailable(proId, quantity);
	}

	public Product getProductById(int proId) {
		return CommerceDb.getInstance().getProductById(proId);
	}

	public int addNewCart(List<CartEntry> carts) {
//		int currCartId = cartId;
//		Cart cart = new Cart(cartId++,user.getUserId(), carts);
//		user.addCart(cart);
		return 0;
	}

	public List<Cart> getCarts() {
//		return user.getCarts();
		return new ArrayList<>();
	}

	public Cart getCartById(int id) {
//		List<Cart> carts = user.getCarts();
//		for(Cart cart : carts)
//			if(cart.getCartId()==id)
//				return cart;
		return null;
	}

	public void placeOrder(int orderedCartId) {
//		Order order = new Order(
//				orderId++, getCartById(orderedCartId), System.currentTimeMillis(),
//				System.currentTimeMillis() + 3*(1800000000) , 
//				Status.ORDERED, System.currentTimeMillis()
//				);
//		CommerceDb.getInstance().addOrder(order);
//		user.getOrders().add(order);
		
	}

	public boolean placeTheOrder(int proId, int quantity, int paymentType) {
		return CommerceDb.getInstance().placeTheOrder(proId, quantity, paymentType, userId);
	}


}
