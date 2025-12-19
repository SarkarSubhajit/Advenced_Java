package wbjp.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import wbjp.webmvc.model.User;

@Controller
public class UserController {

	@RequestMapping("/login")
	public void addUser(Model data) {
		data.addAttribute("objUser", new User("name", "password"));
	}
	
	@RequestMapping("/Authenticate")
	public ModelAndView authenticate(@ModelAttribute("objUser")User user) {
		if (user.getUserName().equals("test") && user.getPassword().equals("test@123"))
			return new ModelAndView("welcome", "message", "Welcome to the page");
		else
			return new ModelAndView("failure", "message", "Authentication failed");
	}
	
}
