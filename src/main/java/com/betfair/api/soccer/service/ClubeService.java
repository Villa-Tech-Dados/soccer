package com.betfair.api.soccer.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.betfair.api.soccer.model.Clube;
import com.betfair.api.soccer.repository.ClubeRepository;


@Service
public class ClubeService {

	private Logger log = LoggerFactory.getLogger(ClubeService.class);

	@Autowired
	private ClubeRepository clubeRepository;
	
	@Autowired
	private Environment environment;
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<Clube> consultaObjetoClube(Long nuObjetoClube) {
		Optional<Clube> result = clubeRepository.findById(nuObjetoClube);
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<Clube> consultaObjetoClubeComRedis(Integer nuObjetoClube) {
		Optional<Clube> result = null;
		result = clubeRepository.findById(nuObjetoClube);
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void salva(Clube objetoClube) {
		Optional<Clube> exists = clubeRepository.findById(objetoClube.getId());
		if (exists.isPresent()) {
			throw new RuntimeException(environment.getProperty("Clube.jaExistente"));
		}
		clubeRepository.save(objetoClube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void atualiza(Clube objetoClube) {
		Optional<Clube> exists = this.clubeRepository.findById(objetoClube.getId());
		if (exists.isPresent()) {
			clubeRepository.save(objetoClube);
		} else {
			throw new RuntimeException(environment.getProperty("Clube.naoEncontradoParaAtualizacao"));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(Integer nuObjetoClube) {
		Optional<Clube> exists = this.clubeRepository.findById(nuObjetoClube);
		if (exists.isPresent()) {
			clubeRepository.deleteById(nuObjetoClube);
		} else {
			throw new RuntimeException(environment.getProperty("Clube.naoEncontradoParaExclusao"));
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Clube> findAll(Long id, String[] sort) {
//		Specification<Clube> specs = new ClubeSpecification(id);
		return null;
	}

	
}
