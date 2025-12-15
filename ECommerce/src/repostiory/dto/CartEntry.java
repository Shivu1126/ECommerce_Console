package repostiory.dto;

public class CartEntry {
	private Product product;
	private int quantity;
	private double sumPrice;
	private long addedTime;
	
	public CartEntry( Product product, int quantity, double sumPrice, long addedTime) {
		this.product = product;
		this.quantity = quantity;
		this.sumPrice = sumPrice;
		this.addedTime = addedTime;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}
	public long getAddedTime() {
		return addedTime;
	}
	public void setAddedTime(long addedTime) {
		this.addedTime = addedTime;
	}
	
}
