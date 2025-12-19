package wbjp.webmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import wbjp.webmvc.dao.CategoryDao;
import wbjp.webmvc.entity.Category;
import wbjp.webmvc.entity.User;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryDao categoryDao;

	@RequestMapping("/showcategories")
	public String showCategory(Model data) {
		
		List<Category> list = (List<Category>) categoryDao.findAll();
		
		data.addAttribute("categoryList", list);
		
		return "category";
	}
	
}
