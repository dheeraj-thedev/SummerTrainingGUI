package com.trainingbasket.beans;

public class User {
	String ussername;
	String password;
	String privilage;

	@Override
	public String toString() {
		return "User Name" + this.ussername + "\nPassword" + this.password + "\nPrivilage" + this.privilage;
	}

	public String getUssername() {
		return ussername;
	}

	public void setUssername(String ussername) {
		this.ussername = ussername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrivilage() {
		return privilage;
	}

	public void setPrivilage(String privilage) {
		this.privilage = privilage;
	}
}
