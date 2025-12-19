package wbjp.secondspring.beans;

import java.util.Iterator;

import org.springframework.stereotype.Component;

import wbjp.secondspring.dao.CategoryDAO;
import wbjp.secondspring.entity.Category;
import wbjp.secondspring.exceptions.CategoryException;

@Component
public class CategoryDAOImpl implements CategoryDAO {

	@Override
	public void addCategory(Category objCategory) throws CategoryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCategory(int categoryId) throws CategoryException {
		// TODO Auto-generated method stub

	}

	@Override
	public Category findById(int categoryId) throws CategoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Category> findAll() throws CategoryException {
		// TODO Auto-generated method stub
		return null;
	}

}
