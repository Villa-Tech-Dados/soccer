package com.betfair.api.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.betfair.api.model.Clube;

@Repository
public interface ClubeRepository extends JpaRepository<Clube, Long>, JpaSpecificationExecutor<Clube> {
			
	List<Clube> findAll(Specification<Clube> spec, Sort sort);

}
