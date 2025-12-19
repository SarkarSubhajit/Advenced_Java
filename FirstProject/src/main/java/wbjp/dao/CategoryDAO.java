package wbjp.dao;

import java.util.Iterator;

import wbjp.entity.Category;
import wbjp.exception.CategoryException;

public interface CategoryDAO {
	
	public void addCategory(Category objCategory) throws CategoryException;
	public void deleteCategory(int categoryId) throws CategoryException;
	public Category findById(int categoryId) throws CategoryException;
	public Iterator<Category> findAll() throws CategoryException;
	
}
