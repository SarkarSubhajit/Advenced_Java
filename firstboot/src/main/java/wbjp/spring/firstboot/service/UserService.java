package wbjp.spring.firstboot.service;

import java.util.List;

import wbjp.spring.firstboot.dto.UserDTO;

public interface UserService {

	public boolean authenticate(UserDTO objUser);
	public boolean addUser(UserDTO objUser);
	public List<UserDTO> getAll();
	
}
