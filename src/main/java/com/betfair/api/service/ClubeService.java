package com.betfair.api.service;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.betfair.api.model.Clube;
import com.betfair.api.repository.ClubeRepository;
import com.betfair.api.specification.ClubeSpecification;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ClubeService {


	private Logger log = LoggerFactory.getLogger(ClubeService.class);

	@Autowired
	private ClubeRepository clubeRepository;
	@Autowired
	private Environment environment;
	@Autowired
	private ObjectMapper mapper;

	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<Clube> consultaClube(Long id) {
		Optional<Clube> result = clubeRepository.findById(id);
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<Clube> consultaClubeComRedis(Long id) {
		Optional<Clube> result = null;
		result = clubeRepository.findById(id);
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void salva(Clube clube) {
		Optional<Clube> exists = clubeRepository.findById(clube.getId());
		if (exists.isPresent()) {
//			throw new RuntimeException(environment.getProperty("Clube.jaExistente"), exists.get().getId());
		}
		clubeRepository.save(clube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void atualiza(Clube clube) {
		Optional<Clube> exists = this.clubeRepository.findById(clube.getId());
		if (exists.isPresent()) {
			clubeRepository.save(clube);
		} else {
			throw new RuntimeException(environment.getProperty("Clube.naoEncontradoParaAtualizacao"));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(Long id) {
		Optional<Clube> exists = this.clubeRepository.findById(id);
		if (exists.isPresent()) {
			clubeRepository.deleteById(id);
		} else {
			throw new RuntimeException(environment.getProperty("Clube.naoEncontradoParaExclusao"));
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Clube> findAll(Long id, String nome, String[] sort) {
//		Sort sort2 = utilSortOrder.sorting(sort);
		Specification<Clube> specs = new ClubeSpecification(id, nome);
//		List<Clube> result = clubeRepository.findAll(specs, sort2);
//		try {
//			log.info("Clube: {}", mapper.writeValueAsString(result));
//		} catch (Exception ignored) {
//		}
//		return result;
		return null;
	}
	
}
