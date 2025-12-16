package repostiory.dto;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int userId;
	private String userName;
	private String mobile;
	private String email;
	private String password;
	private String address;	
	
	public User(String userName, String mobile, String email, String password, String address) {
		this.userName = userName;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
