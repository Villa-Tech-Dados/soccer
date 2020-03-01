package com.betfair.api.soccer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.betfair.api.soccer.model.Clube;
import com.betfair.api.soccer.repository.ClubeRepository;
import com.betfair.api.soccer.specification.ClubeSpecification;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class ClubeService {

	private Logger log = LoggerFactory.getLogger(ClubeService.class);

	@Autowired
	private ClubeRepository atendimentoRepository;
	@Autowired
	private Environment environment;
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private CaixaService caixaService;
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<Clube> consultaObjetoClube(Long nuObjetoClube) {
		Optional<Clube> result = atendimentoRepository.findById(nuObjetoClube);
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<Clube> consultaObjetoClubeComRedis(Integer nuObjetoClube) {
		Optional<Clube> result = null;
		result = atendimentoRepository.findById(nuObjetoClube);
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void salva(Clube objetoClube) {
		Optional<Clube> exists = atendimentoRepository.findById(objetoClube.getId());
		if (exists.isPresent()) {
			throw new RuntimeException(environment.getProperty("Clube.jaExistente"));
		}
		atendimentoRepository.save(objetoClube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void atualiza(Clube objetoClube) {
		Optional<Clube> exists = this.atendimentoRepository.findById(objetoClube.getId());
		if (exists.isPresent()) {
			atendimentoRepository.save(objetoClube);
		} else {
			throw new RuntimeException(environment.getProperty("Clube.naoEncontradoParaAtualizacao"));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(Integer nuObjetoClube) {
		Optional<Clube> exists = this.atendimentoRepository.findById(nuObjetoClube);
		if (exists.isPresent()) {
			atendimentoRepository.deleteById(nuObjetoClube);
		} else {
			throw new RuntimeException(environment.getProperty("Clube.naoEncontradoParaExclusao"));
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Clube> findAll(Long id, Long mcu, String[] sort) {
		Specification<Clube> specs = new ClubeSpecification(id, mcu);
		List<Clube> result = atendimentoRepository.findAll(specs, sort);
		try {
			log.info("ObjetoClube: {}", mapper.writeValueAsString(result));
		} catch (Exception ignored) {
		}
		return result;
	}

	
}
