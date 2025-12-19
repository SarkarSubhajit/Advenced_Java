package wbjp.webmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Query;
import wbjp.webmvc.entity.User;

public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory hibernateFactory;

	@Override
	public boolean authenticateUser(User objUser) {
		
		Session hibernateSession = hibernateFactory.openSession();
		User user = hibernateSession.find(User.class, objUser.getUserName());
		
		if (user != null) {
			if (user.getPassword().equals(objUser.getPassword()))
				return true;
		}
		return false;
		
	}

	@Override
	public boolean registerUser(User objUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> allUsers() {

		Session hibernateSession = hibernateFactory.openSession();
		Query query = hibernateSession.createQuery("select OBJECT(oUser) from User oUser", User.class);
		
		return query.getResultList();
	}

}
