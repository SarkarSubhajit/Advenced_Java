package wbjp.spring.firstboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wbjp.spring.firstboot.entity.User;
import wbjp.spring.firstboot.repository.UserRepository;

@Component
public class UserDAOImpl implements UserDAO {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean authenticate(User objUser) {
		
		Optional<User> opUser = userRepository.findById(objUser.getUserName());
		if (opUser.isPresent()) {
			User user = opUser.get();
			if (user.getPassword().equals(objUser.getPassword()))
				return true;
		}
		
		return false;
	}

	@Override
	public boolean registerUser(User objUser) {

		if(userRepository.save(objUser) != null)
			return true;
		return false;
		
	}

	@Override
	public List<User> getAll() {
		List<User> list = userRepository.findAll();
		return list;
	}

}
