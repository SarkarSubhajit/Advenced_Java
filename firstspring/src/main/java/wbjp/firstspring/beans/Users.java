package wbjp.firstspring.beans;

import org.springframework.stereotype.Component;

@Component("objUser")
public class Users {

	String userName;
	String password;
	
	public Users() {
		// TODO Auto-generated constructor stub
		System.out.println("Default constructor of Users fired");
	}
	
	public Users(String userName, String password) {
		super();
		System.out.println("Parameterised constructor of Users fired with values : " + userName + " - " + password);
		this.userName = userName;
		this.password = password;
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

//	@Override
//	public String toString() {
//		return "Users [userName=" + userName + ", password=" + password + "]";
//	}
	
	
	
	
}
