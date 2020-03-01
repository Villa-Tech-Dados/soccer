package com.betfair.api.soccer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.betfair.api.soccer.model.Clube;

@Repository
public interface ClubeRepository extends JpaSpecificationExecutor<Clube>, JpaRepository<Clube, Integer>{
		
	public List<Clube> findAll(Specification<Clube> spec, Sort sort);

	public Optional<Clube> findById(Long id);
	
}
