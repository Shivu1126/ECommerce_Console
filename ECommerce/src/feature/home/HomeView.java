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
	public HomeView(User user) {
		this.controller = new HomeController(this, user);
	}
	
	public void homeView() {
		while(true){
			System.out.println("1. View All products");
			System.out.println("2. Add To Cart");
			System.out.println("3. Place Order");
			System.out.println("4. History Order");
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
						break;
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
				System.out.println("ProductId\tProductName\tPrice\tType\tManfactureDate\tExpireyDate\tdiscount%\tsellingPrice");
				for(CartEntry cartEntry : cart.getCartEntries()) {
					Product pro = cartEntry.getProduct();
					System.out.println(pro.getProId()+"\t"+pro.getProductName()+"\t"+pro.getPrice()+"\t"+pro.getType()+
							""+pro.getManufDate()+"\t"+pro.getExpDate()+"\t"+pro.getDiscount());
				}	
				System.out.println("---------------------------------------------------------------------");
			}
		}
	}

	private void placeOrder() {
		System.out.println("1. New order");
		System.out.println("2. From Cart");
		int option = Integer.parseInt(getScanner().nextLine());
		if(option==1) {
			List<CartEntry> carts = new ArrayList<>();
			System.out.println("Enter product id");
			int proId = Integer.parseInt(getScanner().nextLine());
			System.out.println("Enter quantity");
			int quantity = Integer.parseInt(getScanner().nextLine());
			if(quantity<=0 && controller.checkProId(proId, quantity)) {
				System.out.println("Product doesnt exist");
			}
			else {
				Product product = controller.getProductById(proId);
				CartEntry cartEntry = new CartEntry(product, quantity, quantity*product.getPrice(), System.currentTimeMillis());
				carts.add(cartEntry);
				int cartId = controller.addNewCart(carts);
//				paymentMethod(cartId);
				controller.placeOrder(cartId);
			}
		}
		else if(option==2) {
			System.out.println("Enter Cart Id");
			int cartId = Integer.parseInt(getScanner().nextLine());
			if(controller.checkCartId(cartId)==null)
				System.out.println("Enter proper id");
			else
				controller.placeOrder(cartId);
		}
		else {
			System.out.println("Enter proper input...");
		}
	}

	private void paymentMethod(int cartId) {
		
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
			if(quantity<=0 && controller.checkProId(proId, quantity)) {
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
			if(quantity<=0 && controller.checkProId(proId, quantity)) {
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
			System.out.println("ProductId\tProductName\tPrice\tType\tManfactureDate\tExpireyDate\tdiscount%\tsellingPrice");
			System.out.println("-----------------------------------------------------------------------------");
			for(Product pro : allProduct) {
				System.out.println(pro.getProId()+"\t"+pro.getProductName()+"\t"+pro.getPrice()+"\t"+pro.getType()+
				""+pro.getManufDate()+"\t"+pro.getExpDate()+"\t"+pro.getDiscount());
//				+"\t"+(pro.getPrice()-(pro.getPrice()/pro.getDiscount())));
			}
			System.out.println("-----------------------------------------------------------------------------");
		}
	}
	public void showMessage(String message) {
		System.out.println(message);
	}
}
