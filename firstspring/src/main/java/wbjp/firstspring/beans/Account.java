package wbjp.firstspring.beans;

public interface Account {

	public boolean authenticate();
	public boolean createAccount(String userName, String password, String name);
	
}
