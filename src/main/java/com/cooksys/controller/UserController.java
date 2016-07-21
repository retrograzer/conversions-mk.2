package com.cooksys.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.User;
import com.cooksys.model.HitsReq;
import com.cooksys.model.LocationReq;
import com.cooksys.model.UserReq;
import com.cooksys.service.HitsService;
import com.cooksys.service.LocationService;
import com.cooksys.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
//	@Autowired
//	private UserRepository repo;
//	
	@Autowired
	private UserService userService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private HitsService hitService;
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public User createUser(@RequestBody UserReq requestUser) {
		locationService.addToLocation(new LocationReq(null, requestUser.getNum()), (long)1);
		Date date = new Date();
		hitService.addHit(new HitsReq(requestUser.getNum(), date));
		return userService.createUser(requestUser);
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value="/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@RequestMapping(value="name/{name}")
	public User getUserByName(@PathVariable String name) {
		return userService.getUserByUsername(name);
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public User loginUser(@RequestBody UserReq requestUser) {
		locationService.addToLocation(new LocationReq(null, requestUser.getNum()), (long)-1);
		return userService.login(requestUser);
	}

}
