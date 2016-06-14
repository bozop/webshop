package com.comtrade.daoFacade;

public class Person {
	private String id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private boolean logedin;
	private boolean singup;	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean getLogedin() {
		return logedin;
	}
	public void setLogedin(boolean logedin) {
		this.logedin = logedin;
	}
	public boolean getSignup() {
		return singup;
	}
	public void setSignup(boolean singup) {
		this.singup = singup;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
