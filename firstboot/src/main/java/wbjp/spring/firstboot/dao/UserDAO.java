package wbjp.spring.firstboot.dao;

import java.util.List;

import wbjp.spring.firstboot.entity.User;

public interface UserDAO {

	public boolean authenticate(User objUser);
	public boolean registerUser(User objUser);
	public List<User> getAll();
	
}
