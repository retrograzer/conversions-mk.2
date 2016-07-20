package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cooksys.entity.Location;

public interface SpringLocationRepo extends JpaRepository<Location,Long> {

//	Location findByName(String name);

	@Query(value = "SELECT location.id, "
			+ "location.title, "
			+ "location.area, "
			+ "location.url, "
			+ "(SELECT url_hits(*) FROM urls WHERE "
			+ "hits.location_id = location.id AND "
			+ "hits.access_date > DATE_SUB(now(),INTERVAL 1 WEEK)) AS counter "
			+ "FROM location;", nativeQuery = true)
	
	List<Location> getHitsWeek();
	
	@Query(value = "SELECT location.id, "
			+ "location.title, "
			+ "location.area_number, "
			+ "location.url, "
			+ "(SELECT count(*) FROM hits WHERE "
			+ "hits.location_id = location.id AND "
			+ "hits.access_date > DATE_SUB(now(),INTERVAL 1 MONTH)) AS counter "
			+ "FROM location;", nativeQuery = true)
	
	List<Location> getHitsMonth();
	
	@Query(value = "SELECT location.id, "
			+ "location.title, "
			+ "location.area_number, "
			+ "location.url, "
			+ "(SELECT count(*) FROM hits WHERE "
			+ "hits.location_id = location.id AND "
			+ "hits.access_date > DATE_SUB(now(),INTERVAL 1 YEAR)) AS counter "
			+ "FROM location;", nativeQuery = true)
	
	List<Location> getHitsYear();

}