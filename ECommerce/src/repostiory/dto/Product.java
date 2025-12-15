package repostiory.dto;

public class Product {
	private int proId;
	private String productName;
	private double price;
	private String type;
	private long manufDate;
	private long expDate;
	private int stockCount;
	private int discount;
	
	
	public Product(int proId, String productName, double price, String type, long manufDate, long expDate,
			int stockCount, int discount) {
		this.proId = proId;
		this.productName = productName;
		this.price = price;
		this.type = type;
		this.manufDate = manufDate;
		this.expDate = expDate;
		this.stockCount = stockCount;
		this.discount = discount;
	}
	
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getManufDate() {
		return manufDate;
	}
	public void setManufDate(long manufDate) {
		this.manufDate = manufDate;
	}
	public long getExpDate() {
		return expDate;
	}
	public void setExpDate(long expDate) {
		this.expDate = expDate;
	}
	public int getStockCount() {
		return stockCount;
	}
	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
}
