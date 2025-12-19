package wbjp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import wbjp.entity.Category;
import wbjp.exception.CategoryException;

public class CategoryDAOImpl implements CategoryDAO {

	Connection connection;
	PreparedStatement psAddCategory;
	PreparedStatement psDeleteCategory;
	PreparedStatement psFindById;
	PreparedStatement psFindAll;

	public CategoryDAOImpl(Connection connection) {
		super();
		try {
			this.connection = connection;
			this.psAddCategory = connection
					.prepareStatement("INSERT INTO category(categoryName, description, imageURL) VALUES(?,?,?)");
			this.psDeleteCategory = connection.prepareStatement("DELETE FROM category WHERE categoryId=?");
			this.psFindById = connection.prepareStatement("SELECT * FROM category WHERE categoryId=?");
			this.psFindAll = connection.prepareStatement("SELECT * FROM category");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addCategory(Category objCategory) throws CategoryException {
		// TODO Auto-generated method stub
		try {
			psAddCategory.setString(1, objCategory.getCategoryName());
			psAddCategory.setString(2, objCategory.getCategoryDescription());
			psAddCategory.setString(3, objCategory.getImagePath());

			psAddCategory.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CategoryException("Error in Adding Category", e);
		}

	}

	@Override
	public void deleteCategory(int categoryId) throws CategoryException {
		// TODO Auto-generated method stub

		try {
			psDeleteCategory.setInt(1, categoryId);
			psDeleteCategory.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CategoryException("Error in Deleting Category", e);
		}

	}

	@Override
	public Category findById(int categoryId) throws CategoryException {
		// TODO Auto-generated method stub

		Category objCategory = null;
		ResultSet result = null;
		try {
			psFindById.setInt(1, categoryId);

			result = psFindById.executeQuery();

			if (result.next()) {
				objCategory = new Category(result.getInt("categoryId"), result.getString("categoryName"),
						result.getString("description"), result.getString("imageURL"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CategoryException("Error in Finding Category", e);
		} finally {
			try {
				if (result != null)
					result.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new CategoryException("Error in Closing statement", e);
			}
		}

		return objCategory;

	}

	@Override
	public Iterator<Category> findAll() throws CategoryException {

		ArrayList<Category> list = new ArrayList<>();
		try (ResultSet result = psFindAll.executeQuery()) {

			while (result.next()) {
				Category objCategory = new Category(result.getInt("categoryId"), result.getString("categoryName"),
						result.getString("description"), result.getString("imageURL"));
				list.add(objCategory);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CategoryException("Error in Finding All Category", e);
		}

		return list.iterator();
	}

}
