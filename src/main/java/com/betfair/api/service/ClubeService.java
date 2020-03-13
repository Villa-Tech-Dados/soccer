package com.betfair.api.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.betfair.api.model.Clube;

public interface ClubeService {
	Clube getById(Long id);
    Clube save(Clube clube);
    void delete(Clube clube);
	List<Clube> findAll();
	List<Clube> findByPlaceContaining(String place);
	Clube findByPlace(String place);
}
