package repostiory.dto;

public class Product {
	private int proId;
	private String productName;
	private double price;
	private int categoryId;
	private String description;
	private int stockCount;
	private String category;
	
	
	public Product(int proId, String productName, double price, int categoryId, String description,
			int stockCount, String category) {
		this.proId = proId;
		this.productName = productName;
		this.price = price;
		this.categoryId = categoryId;
		this.description = description;
		this.stockCount = stockCount;
		this.category = category;
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
	public int getStockCount() {
		return stockCount;
	}
	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
