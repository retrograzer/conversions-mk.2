package com.cooksys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Location;
import com.cooksys.entity.User;
import com.cooksys.model.LocationReq;
import com.cooksys.repository.SpringLocationRepo;
import com.cooksys.repository.SpringUserRepo;
import com.cooksys.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	SpringLocationRepo locRepo;
	
	@Autowired
	SpringUserRepo userRepo;

	@Override
	public Location getLocationById(Long id) {
		return locRepo.findOne(id);
	}

	// @Override
	// public Location getLocationByName(String name) {
	// return locRepo.findByName(name);
	// }

	@Override
	public List<Location> getAllLocations() {
		return locRepo.findAll();
	}

	@Override
	public List<User> getAllUsersByLocation(Long num) {
		return userRepo.findByNum(num);
	}

	@Override
	public String getConversionRateByLocation(Long num) {
		Location loc = locRepo.findOne(num);
		if (loc == null)
			return null;

		return "User track: " + Long.toString(loc.getAnnoTrack()) + "/ Anonymous track: "
				+ Long.toString(loc.getAnnoTrack());
	}

	@Override
	public Location createLocation(LocationReq requestLocation) {
		Location location = checkExisting(requestLocation);
		if (location != null) {
			locRepo.save(location);
		}
		return location;
	}

	private Location checkExisting(LocationReq requestLocation) {
		Location existing = getLocationById(requestLocation.getNum());

		if (existing == null) {
			Location location = new Location();
			location.setTitle(requestLocation.getTitle());
			location.setAnnoTrack((long) 1);
			location.setTrack((long) 0);
			location.setId(requestLocation.getNum());
			return location;
		}

		return null;
	}

	@Override
	public Location addToLocation(LocationReq requestLocation, long n) {
		if (requestLocation.getTitle() != null) {
			return createLocation(requestLocation);
		}

		Location location = getLocationById(requestLocation.getNum());
		if (location != null) {
			if (n > 0) {
				location.setAnnoTrack(location.getAnnoTrack() + n);
			} else {
				location.setAnnoTrack(location.getAnnoTrack() + n);
				location.setTrack(location.getTrack() - n);
			}
			locRepo.save(location);
			return location;
		}
		return null;
	}

	@Override
	public List<Location> getInLastWeek() {
		return locRepo.getHitsWeek();
	}

	@Override
	public List<Location> getInLastMonth() {
		return locRepo.getHitsMonth();
	}

	@Override
	public List<Location> getInLastYear() {
		return locRepo.getHitsYear();
	}
	
}
