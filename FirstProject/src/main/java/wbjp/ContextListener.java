package wbjp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

	Connection connection = null;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext application = sce.getServletContext();
		
		final String DRIVERCLASS = application.getInitParameter("driverClass");
		final String URL = application.getInitParameter("dbURL");
		final String USERNAME = application.getInitParameter("dbUserName");
		final String PASSWORD = application.getInitParameter("dbPassword");
		
		try {
			Class.forName(DRIVERCLASS);
			connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
			application.setAttribute("GLOBAL_CONNECTION", connection);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
		ServletContext application = sce.getServletContext();
		connection = (Connection) application.getAttribute("GLOBAL_CONNECTION");
		
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
