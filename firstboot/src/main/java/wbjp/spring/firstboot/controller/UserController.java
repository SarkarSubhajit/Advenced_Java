package wbjp.spring.firstboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wbjp.spring.firstboot.dto.UserDTO;
import wbjp.spring.firstboot.service.UserService;

@RestController
@RequestMapping("/app")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/add")
	public boolean addUserController(@RequestBody UserDTO user) {
		return userService.addUser(user);
	}
	
	@GetMapping("/auth")
	public boolean authenticate(@RequestParam("username") String userName, @RequestParam("password") String password) {
		UserDTO dto = new UserDTO();
		dto.setUserName(userName);
		dto.setPassword(password);
		return userService.authenticate(dto);
	}
	
	@GetMapping("/show")
	public List<UserDTO> showAll() {
		return userService.getAll();
	}
	
}
