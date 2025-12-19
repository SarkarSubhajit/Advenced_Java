package wbjp.webmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import wbjp.webmvc.dao.UserDao;
import wbjp.webmvc.entity.User;

@Controller
public class UserController {
	
	@Autowired
	UserDao userDao;

	@RequestMapping("/login")
	public void authenticate(Model data) {
		data.addAttribute("objUser", new User());
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST) 
	public String validateUser(@Valid @ModelAttribute("objUser") User user, BindingResult result){
		if (result.hasErrors())
			return "login";
		else
			return "forward:authenticate";
	}
	
	@RequestMapping("/authenticate")
	public String authenticate(@ModelAttribute("objUser") User user, Model data) {
		boolean status = userDao.authenticateUser(user);
		
		if (status) {
			List<User> userList = userDao.allUsers();
			for (User currentUser : userList) {
				if (currentUser.getUserName().equals(user.getUserName())) {
					System.out.println(currentUser.getName());
					System.out.println(user.getName());
					data.addAttribute("objUser", currentUser);
					break;
				}
			}
			
			return "forward:showcategories";
		}
		else
			return "login";
	}
	
	@RequestMapping("/showusers")
	public String showUsers(Model model) {
		List<User> list = userDao.allUsers();
		
		model.addAttribute("userList", list);
		
		return "user";
	}
	
}
