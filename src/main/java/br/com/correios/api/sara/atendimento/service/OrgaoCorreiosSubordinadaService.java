package br.com.correios.api.sara.atendimento.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.correios.api.commons.exception.ApiNegocioRuntimeException;
import br.com.correios.api.commons.util.UtilSortOrder;
import br.com.correios.api.sara.atendimento.model.OrgaoCorreiosSubordinada;
import br.com.correios.api.sara.atendimento.repository.OrgaoCorreiosSubordinadaRepository;
import br.com.correios.api.sara.atendimento.repository.OrgaoCorreiosSubordinadaSliceRepository;
import br.com.correios.api.sara.atendimento.specification.OrgaoCorreiosSubordinadaSpecification;

@Service
public class OrgaoCorreiosSubordinadaService {

	private Logger log = LoggerFactory.getLogger(OrgaoCorreiosSubordinadaService.class);

	@Autowired
	private OrgaoCorreiosSubordinadaRepository OrgaoCorreiosSubordinadaRepository;
	@Autowired
	private OrgaoCorreiosSubordinadaSliceRepository OrgaoCorreiosSubordinadaSliceRepository;
	@Autowired
	private Environment environment;
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private UtilSortOrder utilSortOrder;

	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<OrgaoCorreiosSubordinada> consultaObjetoOrgaoCorreiosSubordinada(Long nuObjetoOrgaoCorreiosSubordinada) {
		Optional<OrgaoCorreiosSubordinada> result = OrgaoCorreiosSubordinadaRepository.findById(nuObjetoOrgaoCorreiosSubordinada);
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<OrgaoCorreiosSubordinada> consultaObjetoOrgaoCorreiosSubordinadaComRedis(Integer nuObjetoOrgaoCorreiosSubordinada) {
		Optional<OrgaoCorreiosSubordinada> result = null;
		result = OrgaoCorreiosSubordinadaRepository.findById(nuObjetoOrgaoCorreiosSubordinada);
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void salva(OrgaoCorreiosSubordinada objetoOrgaoCorreiosSubordinada) {
		Optional<OrgaoCorreiosSubordinada> exists = OrgaoCorreiosSubordinadaRepository.findById(objetoOrgaoCorreiosSubordinada.getId());
		if (exists.isPresent()) {
			throw new ApiNegocioRuntimeException(environment.getProperty("OrgaoCorreiosSuboirdinada.jaExistente"), exists.get().getId());
		}
		OrgaoCorreiosSubordinadaRepository.save(objetoOrgaoCorreiosSubordinada);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void atualiza(OrgaoCorreiosSubordinada objetoOrgaoCorreiosSubordinada) {
		Optional<OrgaoCorreiosSubordinada> exists = this.OrgaoCorreiosSubordinadaRepository.findById(objetoOrgaoCorreiosSubordinada.getId());
		if (exists.isPresent()) {
			OrgaoCorreiosSubordinadaRepository.save(objetoOrgaoCorreiosSubordinada);
		} else {
			throw new ApiNegocioRuntimeException(environment.getProperty("OrgaoCorreiosSuboirdinada.naoEncontradoParaAtualizacao"));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(Integer nuObjetoOrgaoCorreiosSubordinada) {
		Optional<OrgaoCorreiosSubordinada> exists = this.OrgaoCorreiosSubordinadaRepository.findById(nuObjetoOrgaoCorreiosSubordinada);
		if (exists.isPresent()) {
			OrgaoCorreiosSubordinadaRepository.deleteById(nuObjetoOrgaoCorreiosSubordinada);
		} else {
			throw new ApiNegocioRuntimeException(environment.getProperty("OrgaoCorreiosSuboirdinada.naoEncontradoParaExclusao"));
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<OrgaoCorreiosSubordinada> findAll(Long id, String[] sort) {
		Sort sort2 = utilSortOrder.sorting(sort);
		Specification<OrgaoCorreiosSubordinada> specs = new OrgaoCorreiosSubordinadaSpecification(id);
		List<OrgaoCorreiosSubordinada> result = OrgaoCorreiosSubordinadaRepository.findAll(specs, sort2);
		try {
			log.info("ObjetoOrgaoCorreiosSubordinada: {}", mapper.writeValueAsString(result));
		} catch (Exception ignored) {
		}
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Page<OrgaoCorreiosSubordinada> findAll(Long id, Integer page, Integer size, String[] sort) {
		Pageable pagination = utilSortOrder.pagination(page, size, sort);
		Specification<OrgaoCorreiosSubordinada> specs = new OrgaoCorreiosSubordinadaSpecification(id);
		Page<OrgaoCorreiosSubordinada> result = OrgaoCorreiosSubordinadaRepository.findAll(specs, pagination);
		try {
			log.info("ObjetoOrgaoCorreiosSubordinada: {}", mapper.writeValueAsString(result));
		} catch (Exception ignored) {
		}
		return result;
	}

//	@Transactional(propagation = Propagation.SUPPORTS)
//	public Slice<OrgaoCorreiosSubordinada> findAllSlice(Long id, Integer page, Integer size, String[] sort) {
//		Pageable pagination = utilSortOrder.pagination(page, size, sort);
//		Specification<OrgaoCorreiosSubordinada> specs = new OrgaoCorreiosSubordinadaSpecification(id);
//		Slice<OrgaoCorreiosSubordinada> result = OrgaoCorreiosSubordinadaSliceRepository.findAll(specs, pagination);
//		try {
//			log.info("ObjetoOrgaoCorreiosSubordinada: {}", mapper.writeValueAsString(result));
//		} catch (Exception ignored) {
//		}
//		return result;
//	}

	
	@Transactional(propagation = Propagation.SUPPORTS)
	public OrgaoCorreiosSubordinada findOrgaoCorreiosSubordinadora(Long idOrgaoCorreios) {
		
		Specification<OrgaoCorreiosSubordinada> specs = OrgaoCorreiosSubordinadaSpecification.whereIdSubordinada(idOrgaoCorreios);

		OrgaoCorreiosSubordinada objetoOrgaoCorreiosSubordinada = (OrgaoCorreiosSubordinadaRepository.findOne(specs)).orElse(null);
//		LocalDateTime dataAtual = LocalDateTime.now();
//		dataAtual = dataAtual.minusDays(350);
//		Date dataVigencia = Date.from(dataAtual.atZone(ZoneId.systemDefault()).toInstant());
//		
//		List<String> objetoOrgaoCorreiosSubordinadaList = objetoOrgaoCorreiosSubordinadaRepository.findAll(specs);
		try {
			log.info("ObjetoOrgaoCorreiosSubordinada: {}", mapper.writeValueAsString(objetoOrgaoCorreiosSubordinada));
		} catch (Exception ignored) {
		}
		return objetoOrgaoCorreiosSubordinada;
	} 
}
