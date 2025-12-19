package wbjp;

import jakarta.servlet.ServletConfig;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wbjp.dao.CategoryDAOImpl;
import wbjp.entity.Category;
import wbjp.exception.CategoryException;
import wbjp.dao.CategoryDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

@WebServlet("/Category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CategoryDAO categoryDAO;
	PreparedStatement psCategory = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);

		Connection connection = (Connection) getServletContext().getAttribute("GLOBAL_CONNECTION");
		categoryDAO = new CategoryDAOImpl(connection);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();

		try {
			if (psCategory != null) {
				psCategory.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try (PrintWriter out = response.getWriter()) {

			HttpSession session = request.getSession(false);
			
			if (session == null) {
				response.sendRedirect("login.html");
				return;
			}
			
			Iterator<Category> iter = categoryDAO.findAll();
			String userName = (String) session.getAttribute("userName");

			out.println("<html>");
			out.println("<body>");
			out.println("Welcome <b>" + userName + "</b><br/>");
			out.println("<table border='1'>");

			out.println("<tr>");
			out.println("<th>Name</th>");
			out.println("<th>Description</th>");
			out.println("<th>Image</th>");
			out.println("</tr>");

			while (iter.hasNext()) {
				
				Category objCategory = iter.next();
				
				out.println("<tr>");
				out.println("<td><a href='Product?catId=" + objCategory.getCategoryId()
							+ "'>" + objCategory.getCategoryName() + "</a></td>");
				out.println("<td>" + objCategory.getCategoryDescription() + "</td>");
				out.println("<td><img src='Images/" + objCategory.getImagePath() + "' height='80px' width='80px' /></td>");
				out.println("</tr>");
			}

			out.println("</table>");
			out.println("</body>");
			out.println("</html>");

		} catch (CategoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
