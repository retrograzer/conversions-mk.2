package com.cooksys.service;

import java.util.List;

import com.cooksys.entity.Url;
import com.cooksys.model.UrlReq;

public interface UrlService {

	List<Url> getAllUsers();

	Url createUrl(UrlReq requestUrl);

}
