package com.codingdojo.notchtop.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginAdmin {
	
	 @NotEmpty(message="Username is required!")
	 private String userName;
	    
	 @NotEmpty(message="Password is required!")
	 @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
	 private String password;
	    
	 public LoginAdmin() {}

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

	public LoginAdmin(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	    
	    
	    

}
