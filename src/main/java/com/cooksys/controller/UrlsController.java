package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Url;
import com.cooksys.model.UrlReq;
import com.cooksys.service.UrlService;

@RestController
@RequestMapping("/urls")
public class UrlsController {

	@Autowired
	private UrlService urlService;
	
	@RequestMapping("get")
	public List<Url> getAllUrls() {
		System.out.println("Getting urls");
		return urlService.getAllUrls();
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public Url createUrl(@RequestBody UrlReq requestUrl) {
		System.out.println("Creating url");
		return urlService.createUrl(requestUrl);
	}

}
