package repostiory.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import repostiory.dto.Order;
import repostiory.dto.Product;
import repostiory.dto.User;

public class CommerceDb {
	private static CommerceDb commerceDb;
	private static int userId = 1;
	private static int productId = 1;
	private Map<Integer, User> users;
	private Map<Integer, Product> products;
	private List<Order> orders;
	
	private CommerceDb() {
		users = new HashMap<>();
		products = new HashMap<>();
		orders = new ArrayList<>();
	}
	
	public static CommerceDb getInstance() {
		if(commerceDb == null)
			commerceDb = new CommerceDb();
		return commerceDb;
	}

	public Map<Integer, User> getUsers() {
		return users;
	}

	public void addUser( User user) {
		user.setUserId(userId);
		users.put(userId, user);
		userId++;
	}

	public Map<Integer, Product> getProducts() {
		return products;
	}

	public void addProducts(Product product) {
		product.setProId(productId);
		products.put(productId, product);
		productId++;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void addOrder(Order order) {
		this.orders.add(order);
	}
	
}
