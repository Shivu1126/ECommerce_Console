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

	public boolean addUser( User user) {
		return new CommerceDao().addNewUser(user);
	}

	public List<Product> getProducts() {
		return new CommerceDao().getAllProducts();
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

	public boolean checkEmailAlreadyExist(String email) {
		return new CommerceDao().checkEmailAlreadyExist(email);
	}

	public int login(String email, String password) {
		return new CommerceDao().login(email, password);
	}

	public boolean isProductAvailable(int proId, int quantity) {
		return new CommerceDao().isProductAvailable(proId, quantity);
	}

	public Product getProductById(int proId) {
		
		return new CommerceDao().getProductById(proId);
	}

	public boolean placeTheOrder(int proId, int quantity, int paymentType, int userId) {
		return new CommerceDao().placeTheOrder(proId, quantity, paymentType, userId);
	}
	
}
