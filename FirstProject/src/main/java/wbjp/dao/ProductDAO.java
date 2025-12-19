package wbjp.dao;

import java.util.Iterator;

import wbjp.entity.Category;
import wbjp.entity.Product;
import wbjp.exception.ProductException;

public interface ProductDAO {
	
	public void addProduct(Category objCategory) throws ProductException;
	public void deleteProduct(int categoryId) throws ProductException;
	public Product findById(int categoryId) throws ProductException;
	public Iterator<Product> findAll() throws ProductException;
	
}
