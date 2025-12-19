package wbjp.webmvc.dao;

import java.util.List;

import wbjp.webmvc.entity.Category;

public interface CategoryDao {

	public Category findById(int catId);
	public List<Category> findAll();
	
}
