package repostiory.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import repostiory.dto.Product;
import repostiory.dto.User;

class CommerceDao {
	
	public List<Product> getAllProducts(){
		List<Product> productlist = new ArrayList<>();
		try {
			Connection con = DbConnection.getConnection();
			String sqlQuery = "select * from product where stock > 0";
			PreparedStatement statement = con.prepareStatement(sqlQuery);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String category = getCategory(rs.getInt("categoryId"));
				Product product = new Product(
						rs.getInt("id"), 
						rs.getString("proName"), 
						rs.getDouble("price"),
						rs.getInt("categoryId"),
						rs.getString("description") ,
						rs.getInt("stock"),
						category
						);
				productlist.add(product);
			}
			return productlist;
		}
		catch (Exception e) {
			return productlist;
		}
	}
	
	private String getCategory(int id) {
		try {
			Connection con = DbConnection.getConnection();
			String sqlQuery = "select * from categories where id = ?";
			PreparedStatement statement = con.prepareStatement(sqlQuery);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next())
				return rs.getString("name");
			return "No";
		}catch (Exception e) {
			return "No";
		}
	}

	public boolean checkEmailAlreadyExist(String email) {
		try{
			Connection con = DbConnection.getConnection();
			String sqlQuery = "select * from user where email = ?";
			PreparedStatement statement = con.prepareStatement(sqlQuery);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			boolean itHasRow = rs.next();
			statement.close();
//			con.close();
			return itHasRow;
		}
		catch (Exception e) {
		
//			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean addNewUser(User user) {
		try{
			Connection con = DbConnection.getConnection();
			String sqlQuery = "insert into user (name, mobile, email, password, address) "
					+ "values( ?, ?, ?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(sqlQuery);
			statement.setString(1,user.getUserName());
			statement.setString(2,user.getMobile());
			statement.setString(3,user.getEmail());
			statement.setString(4,user.getPassword());
			statement.setString(5,user.getAddress());
			int row = statement.executeUpdate();
			statement.close();
//			con.close();
			return row > 0;
		}
		catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
			return false;
		}
	}

	public int login(String email, String password) {
		try{
			Connection con = DbConnection.getConnection();
			String sqlQuery = "select * from user where email = ? and password = ?";
			PreparedStatement statement = con.prepareStatement(sqlQuery);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			int userId = 0;
			if(rs.next()) {
				userId = rs.getInt("id");
			}
			statement.close();
			return userId;
		}
		catch (Exception e) {
		
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public boolean isProductAvailable(int proId, int quantity) {
		try{
			Connection con = DbConnection.getConnection();
			String sqlQuery = "select * from product where id = ? and stock >= ?";
			PreparedStatement statement = con.prepareStatement(sqlQuery);
			statement.setInt(1, proId);
			statement.setInt(2, quantity);
			ResultSet rs = statement.executeQuery();
			boolean itHasRow = rs.next();
			statement.close();
			return itHasRow;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Product getProductById(int proId) {
		try{
			Connection con = DbConnection.getConnection();
			String sqlQuery = "select * from product where id = ?";
			PreparedStatement statement = con.prepareStatement(sqlQuery);
			statement.setInt(1, proId);
			ResultSet rs = statement.executeQuery();
//			System.out.println(rs);
			if(rs.next()) {
				String category = getCategory(rs.getInt("categoryId"));
				Product product = new Product(
						rs.getInt("id"), 
						rs.getString("proName"), 
						rs.getDouble("price"),
						rs.getInt("categoryId"),
						rs.getString("description") ,
						rs.getInt("stock"),
						category
						);

				statement.close();
				return product;
			}

			statement.close();
			return null;
		}
		catch (Exception e) {
			e.printStackTrace();
//			System.out.println(e.getMessage());
			return null;
		}
	}

	public boolean placeTheOrder(int proId, int quantity, int paymentType, int userId) {
		try {
			Product product = getProductById(proId);
			double totalPrice = quantity * product.getPrice();
			long orderedDate = System.currentTimeMillis();
			long receiveDate = orderedDate + (3 * 60*60*24*1000); //3600*24 =   14400
			Connection con = DbConnection.getConnection();	//			        7200	= 86400
			String sqlQuery = "insert into orders (userId, total_price, orderedDate, receiveDate) "
					+ "values( ?, ?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(sqlQuery);
			statement.setInt(1,userId);
			statement.setDouble(2,totalPrice);
			statement.setLong(3,orderedDate);
			statement.setLong(4,receiveDate);
			int rowOrders = statement.executeUpdate();

			sqlQuery = "select * from orders";
			PreparedStatement statementOrder = con.prepareStatement(sqlQuery);
			ResultSet rs = statementOrder.executeQuery();
			int orderId = 0;
			while(rs.next()) {
				orderId = rs.getInt("id");
			}
			
			sqlQuery = "insert into order_items (orderId, productId, quantity, created_at, price) "
					+ "values( ?, ?, ?, ?, ?)";
			PreparedStatement statementOrderItems = con.prepareStatement(sqlQuery);
			statementOrderItems.setInt(1, orderId);
			statementOrderItems.setInt(2, proId);
			statementOrderItems.setInt(3, quantity);
			statementOrderItems.setLong(4, System.currentTimeMillis());
			statementOrderItems.setDouble(5, totalPrice);
			
			int rowOrderItems = statementOrderItems.executeUpdate();
			
			String paymentMethod;
			boolean isPaid = false;
			long paidTime;
			if(paymentType == 1) {
				paymentMethod = "Cash On Delivery";
				paidTime = 0;
			}
			else {
				paymentMethod = "Online payment";
				paidTime = System.currentTimeMillis();
				isPaid = true;
			}
			sqlQuery = "insert into payment (orderId, paymentMethod, paidTime, isPaid, amount)"
					+ "values( ?, ?, ?, ?, ?)";
			PreparedStatement statementPayment = con.prepareStatement(sqlQuery);
			statementPayment.setInt(1, orderId);
			statementPayment.setString(2, paymentMethod);
			statementPayment.setLong(3, paidTime);
			statementPayment.setBoolean(4, isPaid);
			statementPayment.setDouble(5, totalPrice);
			
			int rowPayment = statementPayment.executeUpdate();
			
			sqlQuery = "update product set stock = ? where id = ?";
			PreparedStatement statementUpdateStock = con.prepareStatement(sqlQuery);
			statementUpdateStock.setInt(1, product.getStockCount()-quantity);
			statementUpdateStock.setInt(2, product.getProId());
			int rowUpdateStock = statementUpdateStock.executeUpdate();
			
			statementPayment.close();
			statementOrderItems.close();
			statementOrder.close();
			statement.close();
			
			return rowOrders > 0 && rowOrderItems > 0 && rowPayment > 0 && rowUpdateStock > 0;
		}
		catch (Exception e) {
			return false;
		}
	}
}
