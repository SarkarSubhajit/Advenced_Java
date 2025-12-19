package wbjp;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection = null;
	PreparedStatement psAuthenticate = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);

		try {

			connection = (Connection) getServletContext().getAttribute("GLOBAL_CONNECTION");
			psAuthenticate = connection.prepareStatement("SELECT * FROM `user` WHERE USERNAME=? and PASSWORD=?");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException("Authentication Error", e);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();

		try {
			if (psAuthenticate != null) {
				psAuthenticate.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		ResultSet resultAuthenticate = null;
		
		try(PrintWriter out = response.getWriter()) {

			psAuthenticate.setString(1, userName);
			psAuthenticate.setString(2, password);

			resultAuthenticate = psAuthenticate.executeQuery();
			String role = "";
			
			if (resultAuthenticate.next()) {
				role = resultAuthenticate.getString("Role");
				
				HttpSession session = request.getSession();
				session.setAttribute("userName", userName);
				
			} else {
				out.println("Authentication Failed");
				return;
			}
			
			if (role.equals("Admin")) {
				response.sendRedirect("welcome.html");
			} else {
				response.sendRedirect("Category");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				if (resultAuthenticate != null)
					resultAuthenticate.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
