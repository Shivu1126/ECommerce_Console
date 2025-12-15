package repostiory.dto;

import java.util.List;

public class Cart {
	private int cartId;
	private int userId;
	private List<CartEntry> cartEntries;
	private boolean isOrdered;
	public Cart(int cartId, int userId, List<CartEntry> cartEntries) {
		this.userId = userId;
		this.cartId = cartId;
		this.cartEntries = cartEntries;
	}
	public int getUserId() {
		return userId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	public List<CartEntry> getCartEntries() {
		return cartEntries;
	}

	public void setCartEntries(List<CartEntry> cartEntries) {
		this.cartEntries = cartEntries;
	}

	public boolean isOrdered() {
		return isOrdered;
	}
	public void setOrdered(boolean isOrdered) {
		this.isOrdered = isOrdered;
	}
	
}
