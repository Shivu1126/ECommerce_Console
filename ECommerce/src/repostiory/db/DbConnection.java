package repostiory.db;

import java.sql.Connection;
import java.sql.DriverManager;

class DbConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/ecommerce?useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "0001";
	
	private static Connection jdbcConnection;
	
	public static Connection getConnection() {
		if(jdbcConnection==null)
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				jdbcConnection = DriverManager.getConnection(URL,USER,PASS);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return jdbcConnection;
	}
}
