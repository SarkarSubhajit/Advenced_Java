package wbjp.webmvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {

	@Id
	@Column(name="username")
	@NotEmpty(message = "Username cannot be empty")
	@Size(min=3, max=20)
	String userName;
	
	@NotEmpty(message = "Password cannot be empty")
	@Size(min=3, max=20)
	@Column(name="password")
	String password;
	
	@Column(name="name")
	String name;
	
	@Column(name="email")
	String email;
	
	@Column(name="city")
	String city;
	
	@Column(name="role")
	String role;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String userName, String password, String name, String email, String city, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
		this.city = city;
		this.role = role;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", city=" + city + ", role=" + role + "]";
	}
	
}
