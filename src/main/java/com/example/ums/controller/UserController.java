package com.example.ums.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ums.entity.User;
import com.example.ums.service.UserService;



@Controller
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
@PostMapping("/add-user")
	public String addUser(User user) {
		userService.addUser(user);
		return "redirect:/index.jsp";
		
		
	}
@GetMapping("/display-users")
public String findAllUsers(Model model) {
	List<User>user=userService.findAllUsers();
	model.addAttribute("user",user);
	return"display-users.jsp";
	
}
@GetMapping("/delete-user")
public String deleteUser(int id) {
    userService.deleteUser(id);
    return "redirect:/display-users";
}

@GetMapping("/edit-user")
public String editUserRequest(int id, Model model) {
	User user = userService.findUser(id);
	model.addAttribute("user",user);
	return "edit-user.jsp";
}
@PostMapping("/edit-user")
public String updateUser(@ModelAttribute User user) {
	userService.editUser(user);
	return "redirect:/display-users";
	
}
	

}
