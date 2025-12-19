package wbjp.spring.firstboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wbjp.spring.firstboot.dao.UserDAO;
import wbjp.spring.firstboot.dto.UserDTO;
import wbjp.spring.firstboot.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	
	@Override
	public boolean addUser(UserDTO objUser) {
		
		User user = new User();
		BeanUtils.copyProperties(objUser, user);
		return userDAO.registerUser(user);
	}


	@Override
	public boolean authenticate(UserDTO objUser) {
		User user = new User();
		BeanUtils.copyProperties(objUser, user);
		return userDAO.authenticate(user);
	}


	@Override
	public List<UserDTO> getAll() {
		List<User> userList = userDAO.getAll();
		List<UserDTO> list = new ArrayList<>();
		
		for (User user : userList) {
			UserDTO dto = new UserDTO();
			BeanUtils.copyProperties(user, dto);
			list.add(dto);
		}
		
		return list;
	}

}
