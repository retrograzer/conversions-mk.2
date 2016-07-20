package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.Url;

public interface SpringUrlRepo extends JpaRepository<Url, Long>{

	Url findByLabel(String label);
	
	List<Url> findAll();

}
