package com.cooksys.service;

import java.util.List;

import com.cooksys.entity.Hits;
import com.cooksys.model.HitsReq;

public interface HitsService {

	void addHit(HitsReq hitsReq);

	List<Hits> getAllHits();

}
