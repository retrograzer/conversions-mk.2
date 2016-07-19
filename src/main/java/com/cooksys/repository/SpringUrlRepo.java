package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.Url;

public interface SpringUrlRepo extends JpaRepository<Url, Long>{

	Url findByLabel(String label);

}
