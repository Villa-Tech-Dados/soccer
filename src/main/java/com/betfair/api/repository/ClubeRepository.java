package com.betfair.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.betfair.api.model.Clube;

import java.util.List;

@Repository
public interface ClubeRepository extends JpaRepository<Clube, Long> {
//	List<Clube> findById(Long clubeId).orElse(null);
	@Query("Select clube from Clube clube where clube.nome LIKE  %?1%")
	List<Clube> findByPlaceContaining(String place);
	
	@Query("Select clube from Clube clube where clube.nome = ?1")
	List<Clube> findByPlace(String place);
}
