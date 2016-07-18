package com.cooksys.service;

import java.util.List;

import com.cooksys.entity.User;
import com.cooksys.model.UserReq;

public interface UserService {
	
	public User getUserById(Long id);

	public User getUserByUsername(String name);

	public List<User> getAllUsers();

	public User login(UserReq requestUser);

	public User createUser(UserReq requestUser);
	
}
