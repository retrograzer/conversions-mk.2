package com.cooksys.service;

import java.util.List;

import com.cooksys.entity.Location;
import com.cooksys.entity.User;
import com.cooksys.model.LocationReq;

public interface LocationService {

	List<User> getAllUsersByLocation(Long id);

	Location addToLocation(LocationReq requestLocation, long n);

	List<Location> getAllLocations();

	Location getLocationById(Long id);

	String getConversionRateByLocation(Long id);

	Location createLocation(LocationReq requestLocation);

}
