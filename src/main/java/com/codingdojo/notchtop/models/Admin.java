package com.codingdojo.notchtop.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="admin")
public class Admin {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull(message="Required a name!")
    @Size(min=3, max=30, message="Name must be at least 3 characters long")
    private String userName;
	
	@NotNull(message="Required a Password!")
	@Size(min=8, max=128, message="Password must be at least 8 characters long")
	private String password;
	
	@Transient
    @NotNull(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
	

	@OneToMany(mappedBy="admin", fetch = FetchType.LAZY)
    private List<Post> post;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getConfirm() {
		return confirm;
	}


	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}


	public List<Post> getPost() {
		return post;
	}


	public void setPost(List<Post> post) {
		this.post = post;
	}
	
	public Admin() {}
	public Admin(Long id, String userName, String password, String confirm, List<Post> post) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.confirm = confirm;
		this.post = post;
	}
	

}
