package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.Hits;

public interface SpringHitsRepo extends JpaRepository<Hits, Long> {

}
