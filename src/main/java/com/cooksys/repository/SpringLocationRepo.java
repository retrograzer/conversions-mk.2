package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.Location;

public interface SpringLocationRepo extends JpaRepository<Location,Long> {

//	Location findByName(String name);



}