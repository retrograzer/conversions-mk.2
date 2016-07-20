package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Location;
import com.cooksys.entity.User;
import com.cooksys.model.LocationReq;
import com.cooksys.service.LocationService;

@RestController
@RequestMapping("location")
public class LocationController {

	@Autowired
	private LocationService ser;

	@RequestMapping(value = "/LocCreate", method = RequestMethod.POST)
	public Location createLocation(@RequestBody LocationReq requestLocation) {
		return ser.addToLocation(requestLocation, (long) 1);
	}

	@RequestMapping(value = "all", method = RequestMethod.GET)
	public List<Location> getAllLocations() {
		return ser.getAllLocations();
	}

	@RequestMapping(value = "/{id}")
	public Location getLocation(@PathVariable Long id) {
		return ser.getLocationById(id);
	}

	@RequestMapping(value = "users/{id}")
	public List<User> getUsersByLocation(@PathVariable Long id) {
		return ser.getAllUsersByLocation(id);
	}

	@RequestMapping(value = "conversion/{id}")
	public String getLocationConversion(@PathVariable Long id) {
		return ser.getConversionRateByLocation(id);
	}
	
	@RequestMapping("week")
	public List<Location> getInLastWeek(){
		return ser.getInLastWeek();
	}
	
	@RequestMapping("month")
	public List<Location> getInLastMonth(){
		return ser.getInLastMonth();
	}
	
	@RequestMapping("year")
	public List<Location> getInLastYear(){
		return ser.getInLastYear();
	}
	
}
