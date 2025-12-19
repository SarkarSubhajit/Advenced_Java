package wbjp.spring.firstboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	String userName;
	String password;
	String name;
	String email;
	String city;
	String role;
	
}
