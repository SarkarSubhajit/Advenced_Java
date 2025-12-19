package wbjp.spring.firstboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@Column(name="username")
	String userName;
	
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
	
}
