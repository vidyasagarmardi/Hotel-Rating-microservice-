package com.user.api.service;

import java.util.List;

import com.user.api.entity.User;

public interface UserService {
	
	User create(User user);
	User getUserById(Long id);
	List<User> getAllUsers();

}
