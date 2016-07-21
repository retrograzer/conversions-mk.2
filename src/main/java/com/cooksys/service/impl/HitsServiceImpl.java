package com.cooksys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Hits;
import com.cooksys.model.HitsReq;
import com.cooksys.repository.SpringHitsRepo;
import com.cooksys.service.HitsService;

@Service
public class HitsServiceImpl implements HitsService {
	
	@Autowired
	SpringHitsRepo hitRepo;

	@Override
	public void addHit(HitsReq hitsReq) {
		Hits hit = new Hits(hitsReq.getHitRegion(), hitsReq.getTimestamp());
		hitRepo.save(hit);
	}

	@Override
	public List<Hits> getAllHits() {
		return hitRepo.findAll();
	}

}
