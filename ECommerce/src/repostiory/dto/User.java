package repostiory.dto;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int userId;
	private String password;
	private String userName;
	private String mobile;
	private String email;
	private List<String> addresses;
	private List<Cart> carts;
	private List<Order> orders;
	private List<Product> favorites;
	
	public User(int userId, String password, String userName, String mobile, String email, List<String> addresses) {
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.mobile = mobile;
		this.email = email;
		this.addresses = addresses;
		this.carts = new ArrayList<>();
		this.orders = new ArrayList<>();
		this.favorites = new ArrayList<>();
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}
	public List<Cart> getCarts() {
		return carts;
	}
	public void addCart(Cart cart) {
		this.carts.add(cart);
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public List<Product> getFavorites() {
		return favorites;
	}
	public void setFavorites(List<Product> favorites) {
		this.favorites = favorites;
	}
	
}
