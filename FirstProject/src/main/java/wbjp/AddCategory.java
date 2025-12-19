package wbjp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wbjp.dao.CategoryDAO;
import wbjp.dao.CategoryDAOImpl;
import wbjp.entity.Category;
import wbjp.exception.CategoryException;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/admin/AddCategory")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CategoryDAO categoryDAO;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		Connection connection = (Connection) getServletContext().getAttribute("GLOBAL_CONNECTION");
		categoryDAO = new CategoryDAOImpl(connection);
	}

	public void destroy() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("categoryName");
		String desc = request.getParameter("description");
		String image = request.getParameter("imageURL");

		try {

			Category objCategory = new Category(name, desc, image);
			categoryDAO.addCategory(objCategory);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome.html");
			dispatcher.include(request, response);

		} catch (CategoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
