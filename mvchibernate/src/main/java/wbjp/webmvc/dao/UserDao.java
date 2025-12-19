package wbjp.webmvc.dao;

import java.util.List;

import wbjp.webmvc.entity.User;

public interface UserDao {

	public boolean authenticateUser(User objUser);
	public boolean registerUser(User objUser);
	public List<User> allUsers();
	
}
