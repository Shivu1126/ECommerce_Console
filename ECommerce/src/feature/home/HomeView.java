package feature.home;

import java.util.ArrayList;
import java.util.List;

import feature.base.BaseView;
import repostiory.dto.Cart;
import repostiory.dto.CartEntry;
import repostiory.dto.Product;
import repostiory.dto.User;

public class HomeView extends BaseView{
	private HomeController controller;
	public HomeView(int userId) {
		this.controller = new HomeController(this, userId);
	}
	
	public void homeView() {
		while(true){
			System.out.println("1. View All products");
			System.out.println("2. Add To Cart");
			System.out.println("3. Place Order");
			System.out.println("4. Order History");
			System.out.println("5. Show Carts");
			System.out.println("6. Logout");
			try {
				int option = Integer.parseInt(getScanner().nextLine());
				switch(option) {
					case 1:
						controller.viewAllProduct();
						break;
					case 2:
						addToCart();
						break;
					case 3:
						placeOrder();
						break;
					case 4:
						controller.orderHistory();
						break;
					case 5:
						showCarts();
						break;
					case 6:
						System.out.println("Logout successfully");
						return;
					default:
						System.out.println("Enter proper input");
				}
			}catch (Exception e) {
				System.out.println("Enter proper input...");
			}
		}
	}

	private void showCarts() {
		List<Cart> cartList = controller.getCarts();
		if(cartList.isEmpty()) {
			System.out.println("No Carts Yet....");
		}
		else {
			for(Cart cart : cartList) {
				System.out.println("----------------------------------");
				System.out.println("Cart id: "+cart.getCartId() +"\t"+ "Ordered : "+ (cart.isOrdered()?"Yes":"No"));
				System.out.println("----------------------------------");
				System.out.println("ProductId\tProductName\tPrice\tCategory\tDescription\tStock");
				for(CartEntry cartEntry : cart.getCartEntries()) {
					Product pro = cartEntry.getProduct();
					System.out.println(pro.getProId()+"\t"+pro.getProductName()+"\t"+pro.getPrice()+"\t"+pro.getCategory()+
							"\t"+pro.getDescription()+"\t"+pro.getStockCount());
				}	
				System.out.println("---------------------------------------------------------------------");
			}
		}
	}

	private void placeOrder() {
		while(true) {
			System.out.println("1. New order");
			System.out.println("2. From Cart");
			System.out.println("3. Back");
			int option = Integer.parseInt(getScanner().nextLine());
			switch(option) {
				case 1:
					newOrder();
					break;
				case 2:
					break;
				case 3:
					return;
				default:
					System.out.println("Enter proper input");
			}
		}
	}

	private void newOrder() {
		System.out.println("Enter product id");
		int proId = Integer.parseInt(getScanner().nextLine());
		System.out.println("Enter quantity");
		int quantity = Integer.parseInt(getScanner().nextLine());
		boolean isProductNotAvailable = controller.isProductAvailable(proId, quantity);
		if(quantity<=0) {
			System.out.println("Enter proper quantity");
		}
		else if(!isProductNotAvailable) {
			System.out.println("Product doesnt exist");
		}
		else {
			System.out.println(proId+" "+quantity);
			boolean isValid = controller.getProductDetail(proId, quantity);
			if(!isValid) {
				return;
			}
			while(true) {
				System.out.println("Select the payment method");
				System.out.println("1. Cash On Delivary");
				System.out.println("2. Online payment");
				System.out.println("3. Cancel");
				int option = Integer.parseInt(getScanner().nextLine());
				if(option==3) {
					System.out.println("Thank you..");
					return;
				}
				else if(option == 1 || option == 2){
					controller.placeTheOrder(proId, quantity, option);
					break;
				}
				else {
					System.out.println("Enter proper input");
				}
			}
		}
	}

	private void addToCart() {
		while(true) {
			System.out.println("1. New Cart");
			System.out.println("2. Existing Cart");
			System.out.println("3. Back");
			try {
				int option = Integer.parseInt(getScanner().nextLine());
				switch(option) {
					case 1:
						newCart();
						break;
					case 2:
						existingCart();
						break;
					case 3:
						return;
					default:
						System.out.println("Enter proper input");
				}
			}
			catch (Exception e) {
				System.out.println("Enter proper input");
			}
		}
	}

	private void existingCart() {
		System.out.println("Enter cart id");
		int cartId = Integer.parseInt(getScanner().nextLine());
		Cart cart = controller.checkCartId(cartId);
		if(cart==null) {
			System.out.println("Enter proper cart id");
		}
		else {
			System.out.println("Enter product id");
			int proId = Integer.parseInt(getScanner().nextLine());
			System.out.println("Enter quantity");
			int quantity = Integer.parseInt(getScanner().nextLine());
			if(quantity<=0 && controller.isProductAvailable(proId, quantity)) {
				System.out.println("Product doesnt exist");
			}
			else {
				Product product = controller.getProductById(proId);
				CartEntry cartEntry = new CartEntry(product, quantity, quantity*product.getPrice(), System.currentTimeMillis());
				cart.getCartEntries().add(cartEntry);
			}
		}
	}

	private void newCart() {
		List<CartEntry> carts = new ArrayList<>();
		boolean isEnough = false;
		while(!isEnough) {
			System.out.println("Enter product id");
			int proId = Integer.parseInt(getScanner().nextLine());
			System.out.println("Enter quantity");
			int quantity = Integer.parseInt(getScanner().nextLine());
			if(quantity<=0 && controller.isProductAvailable(proId, quantity)) {
				System.out.println("Product doesnt exist");
				continue;
			}
			Product product = controller.getProductById(proId);
			CartEntry cartEntry = new CartEntry(product, quantity, quantity*product.getPrice(), System.currentTimeMillis());
			carts.add(cartEntry);
			System.out.println("If it is enough press 1..otherwise press 2");
			int cont = Integer.parseInt(getScanner().nextLine());
			isEnough = cont==1;
		}
		controller.addNewCart(carts);
	}

	public void showAllProduct(List<Product> allProduct) {
		if(allProduct.isEmpty())
			System.out.println("No product added yet...");
		else {
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println("ProductId\tProductName\tPrice\tCategory\tDescription\tStock");
			System.out.println("-----------------------------------------------------------------------------");
			for(Product pro : allProduct) {
				System.out.println(pro.getProId()+"\t"+pro.getProductName()+"\t"+pro.getPrice()+"\t"+pro.getCategory()+
						"\t"+pro.getDescription()+"\t"+pro.getStockCount());
			}
			System.out.println("-----------------------------------------------------------------------------");
		}
	}
	public void showMessage(String message) {
		System.out.println(message);
	}

	public void showPurchasingProductDetail(Product product, int quantity) {
		if(product==null) {
			System.out.println("Invalid product id..!!");
		}
		else {
			double totalPrice = quantity * product.getPrice();
			System.out.println("--------------------------");
			System.out.println("Order Details");
			System.out.println("--------------------------");
			System.out.println("ProductId : "+product.getProId()+"\tProductName : "+product.getProductName()+
					"\nPrice : "+product.getPrice()+"\tCategory : "+product.getCategory()
					+"\nDescription : "+product.getDescription()+"");
			System.out.println("--------------------------");
			System.out.println("TOTAL PRICE : "+totalPrice);
			System.out.println("--------------------------");
		}
	}
}
