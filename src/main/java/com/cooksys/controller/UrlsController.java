package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Url;
import com.cooksys.model.UrlReq;
import com.cooksys.service.LocationService;
import com.cooksys.service.UrlService;
import com.cooksys.service.UserService;

@RestController
@RequestMapping("/urls")
public class UrlsController {
//	@Autowired
//	private UserRepository repo;
//	
	@Autowired
	private UrlService urlService;
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public Url createUrl(@RequestBody UrlReq requestUrl) {
		return urlService.createUrl(requestUrl);
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public List<Url> getAllUrls() {
		return urlService.getAllUsers();
	}

}
