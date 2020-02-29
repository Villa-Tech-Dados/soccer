package br.com.correios.api.sara.atendimento.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.correios.api.commons.exception.ApiNegocioRuntimeException;
import br.com.correios.api.commons.util.UtilSortOrder;
import br.com.correios.api.sara.atendimento.model.Caixa;
import br.com.correios.api.sara.atendimento.repository.CaixaRepository;
import br.com.correios.api.sara.atendimento.repository.CaixaSliceRepository;
import br.com.correios.api.sara.atendimento.specification.CaixaSpecification;

@Service
public class CaixaService {

	private Logger log = LoggerFactory.getLogger(CaixaService.class);

	@Autowired
	private CaixaRepository caixaRepository;
	@Autowired
	private CaixaSliceRepository caixaSliceRepository;
	@Autowired
	private Environment environment;
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private UtilSortOrder utilSortOrder;

	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<Caixa> consultaObjetoCaixa(Long nuObjetoCaixa) {
		Optional<Caixa> result = caixaRepository.findById(nuObjetoCaixa);
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<Caixa> consultaObjetoCaixaComRedis(Integer nuObjetoCaixa) {
		Optional<Caixa> result = null;
		result = caixaRepository.findById(nuObjetoCaixa);
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void salva(Caixa objetoCaixa) {
		Optional<Caixa> exists = caixaRepository.findById(objetoCaixa.getId());
		if (exists.isPresent()) {
			throw new ApiNegocioRuntimeException(environment.getProperty("Caixa.jaExistente"), exists.get().getId());
		}
		caixaRepository.save(objetoCaixa);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void atualiza(Caixa objetoCaixa) {
		Optional<Caixa> exists = this.caixaRepository.findById(objetoCaixa.getId());
		if (exists.isPresent()) {
			caixaRepository.save(objetoCaixa);
		} else {
			throw new ApiNegocioRuntimeException(environment.getProperty("Caixa.naoEncontradoParaAtualizacao"));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(Integer nuObjetoCaixa) {
		Optional<Caixa> exists = this.caixaRepository.findById(nuObjetoCaixa);
		if (exists.isPresent()) {
			caixaRepository.deleteById(nuObjetoCaixa);
		} else {
			throw new ApiNegocioRuntimeException(environment.getProperty("Caixa.naoEncontradoParaExclusao"));
		}
	}

//	@Transactional(propagation=Propagation.SUPPORTS)
//	public List<ObjetoCaixa> findAll(Specification<ObjetoCaixa> spec) {
//		List<ObjetoCaixa> result = objetoCaixaRepository.findAll(spec);
//		try {
//			log.info("ObjetoCaixas: {}", mapper.writeValueAsString(result));
//		} catch (Exception ignored) {
//		}
//		return result;
//	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Caixa> findAll(Long id, String[] sort) {
		Sort sort2 = utilSortOrder.sorting(sort);
		Specification<Caixa> specs = new CaixaSpecification(id);
		List<Caixa> result = caixaRepository.findAll(specs, sort2);
		try {
			log.info("ObjetoCaixa: {}", mapper.writeValueAsString(result));
		} catch (Exception ignored) {
		}
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Page<Caixa> findAll(Long id, Integer page, Integer size, String[] sort) {
		Pageable pagination = utilSortOrder.pagination(page, size, sort);
		Specification<Caixa> specs = new CaixaSpecification(id);
		Page<Caixa> result = caixaRepository.findAll(specs, pagination);
		try {
			log.info("ObjetoCaixa: {}", mapper.writeValueAsString(result));
		} catch (Exception ignored) {
		}
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Slice<Caixa> findAllSlice(Long id, Integer page, Integer size, String[] sort) {
		Pageable pagination = utilSortOrder.pagination(page, size, sort);
		Specification<Caixa> specs = new CaixaSpecification(id);
		Slice<Caixa> result = caixaSliceRepository.findAll(specs, pagination);
		try {
			log.info("ObjetoCaixa: {}", mapper.writeValueAsString(result));
		} catch (Exception ignored) {
		}
		return result;
	}

	
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Caixa> findCaixasPorUsuario(Long numeroUsuario) {

		Specification<Caixa> specs = CaixaSpecification.whereNumeroUsuario(numeroUsuario)
//									.and(CaixaSpecification.whereIsVigente())
									;
		
		List<Caixa> caixaList = caixaRepository.findAll(specs);
		try {
			log.info("ObjetoCaixa: {}", mapper.writeValueAsString(caixaList));
		} catch (Exception ignored) {
		}
		return caixaList;
	} 
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<Caixa> findCaixaAbertoPorUsuario(Long numeroUsuario) {

		Specification<Caixa> specs = CaixaSpecification.whereNumeroUsuario(numeroUsuario)
									.and(CaixaSpecification.whereCaixaIsAberto())
									;
		
		Optional<Caixa> caixaAberto = caixaRepository.findOne(specs);
		try {
			log.info("ObjetoCaixa: {}", mapper.writeValueAsString(caixaAberto));
		} catch (Exception ignored) {
		}
		return caixaAberto;
	}
}
