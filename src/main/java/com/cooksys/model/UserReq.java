package com.cooksys.model;

public class UserReq {
	 String username;
	 String password;
	 long role;
	 long num;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public UserReq(String username, String password, long num) {
		super();
		this.username = username;
		this.password = password;
		this.num = num;
	}
	public UserReq() {
		super();
	}
	public long getRole() {
		return role;
	}
	public void setRole(long role) {
		this.role = role;
	}
	
	 
}