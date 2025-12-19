package wbjp.firstspring.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("facebook")
public class FacebookAccount implements Account {

	@Autowired
	@Qualifier("addUser")
	Users user;
	List<Users> list;
	
	@PostConstruct
	public void init() {
		System.out.println("FB init fired");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("FB destroy fired");
	}
	
	public FacebookAccount() {
		// TODO Auto-generated constructor stub
		System.out.println("Constructor of FacebookAccount fired");
	}
	
	@Override
	public boolean authenticate() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean createAccount(String userName, String password, String name) {
		return true;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Users> getList() {
		return list;
	}

	public void setList(List<Users> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "FacebookAccount [user=" + user + ", list=" + list + "]";
	}
	

}
