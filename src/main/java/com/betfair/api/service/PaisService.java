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

import com.betfair.api.model.Pais;
import com.betfair.api.repository.PaisRepository;
import com.betfair.api.specification.PaisSpecification;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PaisService {


	private Logger log = LoggerFactory.getLogger(PaisService.class);

	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private Environment environment;
	@Autowired
	private ObjectMapper mapper;

	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<Pais> consultaPais(Long id) {
		Optional<Pais> result = paisRepository.findById(id);
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void salva(Pais pais) {
		paisRepository.save(pais);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void atualiza(Pais pais) {
		Optional<Pais> exists = this.paisRepository.findById(pais.getId());
		if (exists.isPresent()) {
			paisRepository.save(pais);
		} else {
			throw new RuntimeException(environment.getProperty("Pais.naoEncontradoParaAtualizacao"));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(Long id) {
		Optional<Pais> exists = this.paisRepository.findById(id);
		if (exists.isPresent()) {
			paisRepository.deleteById(id);
		} else {
			throw new RuntimeException(environment.getProperty("Pais.naoEncontradoParaExclusao"));
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Pais> findAll(Long id, String nome) {
//		Sort sort2 = utilSortOrder.sorting(sort);
		Specification<Pais> specs = new PaisSpecification(id, nome);
		List<Pais> result = paisRepository.findAll(specs);
		try {
			log.info("Pais: {}", mapper.writeValueAsString(result));
		} catch (Exception ignored) {
		}
		return result;
	}
	
}
