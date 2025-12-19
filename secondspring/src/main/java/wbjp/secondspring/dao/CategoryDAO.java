package wbjp.secondspring.dao;

import java.util.Iterator;

import wbjp.secondspring.entity.Category;
import wbjp.secondspring.exceptions.CategoryException;

public interface CategoryDAO {
	
	public void addCategory(Category objCategory) throws CategoryException;
	public void deleteCategory(int categoryId) throws CategoryException;
	public Category findById(int categoryId) throws CategoryException;
	public Iterator<Category> findAll() throws CategoryException;
	
}
