package com.cooksys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cooksys.entity.Url;
import com.cooksys.model.UrlReq;
import com.cooksys.model.UserReq;
import com.cooksys.repository.SpringUrlRepo;
import com.cooksys.service.UrlService;

public class UrlServiceImpl implements UrlService {
	
	@Autowired
	private SpringUrlRepo urlRepo;

	@Override
	public List<Url> getAllUsers() {
		return urlRepo.findAll();
	}

	@Override
	public Url createUrl(UrlReq requestUrl) {
		Url url = checkExisting(requestUrl);
		if (url != null) {
			urlRepo.save(url);
		}
		return url;
	}
	
	private Url checkExisting(UrlReq requestUrl) {
		Url existing = getUrlByLabel(requestUrl.getLabel());
		
		if (existing == null) {
			Url url = new Url();
			url.setUrl(requestUrl.getUrl());
			url.setLabel(requestUrl.getLabel());
			url.setDescription(requestUrl.getDescription());
			return url;
		}
		{
			 throw new IllegalArgumentException("The 'name' already exists");
		}
	}

	private Url getUrlByLabel(String label) {
		return urlRepo.findByLabel(label);
	}

}
