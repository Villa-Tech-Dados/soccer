package com.betfair.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.betfair.api.model.Clube;
import com.betfair.api.repository.ClubeRepository;

import static java.util.Objects.isNull;

import java.util.List;

@Service
public class ClubeServiceImpl implements ClubeService {

	@Autowired
	private ClubeRepository clubeRepository;
	
	@Override
	public Clube getById(Long id) {
		Clube clube = clubeRepository.findById(id).orElse(null);
        if(isNull(clube)) {
            throw new RuntimeException("clube not found!");
        }
        return clube;
	}

	@Override
	public Clube save(Clube clube) {
		//QUALQUER REGRA DE NEGÓCIO OU VALIDAÇÃO ANTES DE SALVAR
        return clubeRepository.save(clube);
	}
	
//	@Query("select id, nome from paises where paises.nome like :nome")
//	Optional<Clube> findByName(@Param("nome") String nome);
	
	public void delete(Clube clube) {
		clubeRepository.delete(clube);
	}
	

	@Override
	public List<Clube> findByPlaceContaining(String place) {
		return clubeRepository.findByPlaceContaining(place);
	}

	@Override
	public Clube findByPlace(String place) {
		try {
			return clubeRepository.findByPlace(place).get(0);
		}catch(Exception ex) {
			return null;
		}
		
	}

	@Override
	public List<Clube> findAll() {
		return clubeRepository.findAll();
	}
}
