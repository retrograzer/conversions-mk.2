package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Hits;
import com.cooksys.service.HitsService;

@RestController
@RequestMapping("hits")
public class HitsController {

	@Autowired
	HitsService hitService;
	
	@RequestMapping("getAll")
	public List<Hits> getAllHits () {
		return hitService.getAllHits();
	}
	
}
