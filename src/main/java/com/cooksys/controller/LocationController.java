package com.cooksys.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Hits;
import com.cooksys.entity.Location;
import com.cooksys.entity.User;
import com.cooksys.model.LocationReq;
import com.cooksys.service.HitsService;
import com.cooksys.service.LocationService;

@RestController
@RequestMapping("location")
public class LocationController {

	@Autowired
	private LocationService ser;
	@Autowired
	private HitsService hitsSer;

	@RequestMapping(value = "/LocCreate", method = RequestMethod.POST)
	public Location createLocation(@RequestBody LocationReq requestLocation) {
		return ser.addToLocation(requestLocation, (long) 1);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public List<Hits> getAllHits() {
		return hitsSer.getAllHits();
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping("week")
	public List<Hits> getInLastWeek(){
		List<Hits> allHits = hitsSer.getAllHits();
		Calendar cal = Calendar.getInstance();
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		int monthOfYear = cal.get(Calendar.MONTH);
		int yearNum = cal.get(Calendar.YEAR);
		Date targetDate = new Date(yearNum, monthOfYear, dayOfMonth - 7);
		List<Hits> weekHits = new ArrayList<Hits>();
		for (Hits h : allHits) {
			if (h.getTimestamp().after(targetDate)){
				weekHits.add(h);
			}
		}
		return weekHits;
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
