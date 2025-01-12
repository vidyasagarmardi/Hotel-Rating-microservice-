package com.user.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.api.entity.User;
import com.user.api.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	Map<String, Object> createUser(@RequestBody User user){
		Map<String, Object> obj = new HashMap<>();
		try {
			obj.put("Status", "Success");
			obj.put("Data", userService.create(user));
		} catch (Exception e) {
			// TODO: handle exception
			obj.put("Status", "Fail");
			obj.put("Message", e.getMessage());
		}
		return obj;
	}
	
	@GetMapping("/getById/{id}")
	Map<String, Object> getUserById(@PathVariable Long id){
		Map<String, Object> obj = new HashMap<>();
		try {
			obj.put("Status", "Success");
			obj.put("Data", userService.getUserById(id));
		} catch (Exception e) {
			// TODO: handle exception
			obj.put("Status", "Fail");
			obj.put("Message", e.getMessage());
		}
		return obj;
	}
	
	@GetMapping("/getAll")
	Map<String, Object> getAllUsers(){
		Map<String, Object> obj = new HashMap<>();
		try {
			obj.put("Status", "Success");
			obj.put("Data", userService.getAllUsers());
		} catch (Exception e) {
			// TODO: handle exception
			obj.put("Status", "Fail");
			obj.put("Message", e.getMessage());
		}
		return obj;
	}

}
