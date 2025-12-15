package repostiory.dto;


public class Order {
	private int orderId;
	private int paymentId;
	private Cart cart;
	private long orderedDate;
	private long receivedDate;
	private Status status;
	private long lastUpdatedStatusDate;
	
	public Order(int orderId, Cart cart, long orderedDate, long receivedDate, Status status,
			long lastUpdatedStatusDate) {
		this.orderId = orderId;
		this.cart = cart;
		this.orderedDate = orderedDate;
		this.receivedDate = receivedDate;
		this.status = status;
		this.lastUpdatedStatusDate = lastUpdatedStatusDate;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public long getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(long orderedDate) {
		this.orderedDate = orderedDate;
	}
	public long getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(long receivedDate) {
		this.receivedDate = receivedDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public long getLastUpdatedStatusDate() {
		return lastUpdatedStatusDate;
	}
	public void setLastUpdatedStatusDate(long lastUpdatedStatusDate) {
		this.lastUpdatedStatusDate = lastUpdatedStatusDate;
	}
}
