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
import br.com.correios.api.sara.atendimento.model.OrgaoCorreios;
import br.com.correios.api.sara.atendimento.repository.OrgaoCorreiosRepository;
import br.com.correios.api.sara.atendimento.repository.OrgaoCorreiosSliceRepository;
import br.com.correios.api.sara.atendimento.specification.OrgaoCorreiosSpecification;

@Service
public class OrgaoCorreiosService {

	private Logger log = LoggerFactory.getLogger(OrgaoCorreiosService.class);

	@Autowired
	private OrgaoCorreiosRepository orgaoCorreiosRepository;
	@Autowired
	private OrgaoCorreiosSliceRepository orgaoCorreiosSliceRepository;
	@Autowired
	private Environment environment;
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private UtilSortOrder utilSortOrder;

	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<OrgaoCorreios> consultaObjetoOrgaoCorreios(Long nuObjetoOrgaoCorreios) {
		Optional<OrgaoCorreios> result = orgaoCorreiosRepository.findById(nuObjetoOrgaoCorreios);
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<OrgaoCorreios> consultaObjetoOrgaoCorreiosComRedis(Integer nuObjetoOrgaoCorreios) {
		Optional<OrgaoCorreios> result = null;
		result = orgaoCorreiosRepository.findById(nuObjetoOrgaoCorreios);
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void salva(OrgaoCorreios objetoOrgaoCorreios) {
		Optional<OrgaoCorreios> exists = orgaoCorreiosRepository.findById(objetoOrgaoCorreios.getId());
		if (exists.isPresent()) {
			throw new ApiNegocioRuntimeException(environment.getProperty("OrgaoCorreios.jaExistente"), exists.get().getId());
		}
		orgaoCorreiosRepository.save(objetoOrgaoCorreios);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void atualiza(OrgaoCorreios objetoOrgaoCorreios) {
		Optional<OrgaoCorreios> exists = this.orgaoCorreiosRepository.findById(objetoOrgaoCorreios.getId());
		if (exists.isPresent()) {
			orgaoCorreiosRepository.save(objetoOrgaoCorreios);
		} else {
			throw new ApiNegocioRuntimeException(environment.getProperty("OrgaoCorreios.naoEncontradoParaAtualizacao"));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(Integer nuObjetoOrgaoCorreios) {
		Optional<OrgaoCorreios> exists = this.orgaoCorreiosRepository.findById(nuObjetoOrgaoCorreios);
		if (exists.isPresent()) {
			orgaoCorreiosRepository.deleteById(nuObjetoOrgaoCorreios);
		} else {
			throw new ApiNegocioRuntimeException(environment.getProperty("OrgaoCorreios.naoEncontradoParaExclusao"));
		}
	}

//	@Transactional(propagation=Propagation.SUPPORTS)
//	public List<ObjetoOrgaoCorreios> findAll(Specification<ObjetoOrgaoCorreios> spec) {
//		List<ObjetoOrgaoCorreios> result = objetoOrgaoCorreiosRepository.findAll(spec);
//		try {
//			log.info("ObjetoOrgaoCorreioss: {}", mapper.writeValueAsString(result));
//		} catch (Exception ignored) {
//		}
//		return result;
//	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<OrgaoCorreios> findAll(Long id, String[] sort) {
		Sort sort2 = utilSortOrder.sorting(sort);
		Specification<OrgaoCorreios> specs = new OrgaoCorreiosSpecification(id);
		List<OrgaoCorreios> result = orgaoCorreiosRepository.findAll(specs, sort2);
		try {
			log.info("ObjetoOrgaoCorreios: {}", mapper.writeValueAsString(result));
		} catch (Exception ignored) {
		}
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Page<OrgaoCorreios> findAll(Long id, Integer page, Integer size, String[] sort) {
		Pageable pagination = utilSortOrder.pagination(page, size, sort);
		Specification<OrgaoCorreios> specs = new OrgaoCorreiosSpecification(id);
		Page<OrgaoCorreios> result = orgaoCorreiosRepository.findAll(specs, pagination);
		try {
			log.info("ObjetoOrgaoCorreios: {}", mapper.writeValueAsString(result));
		} catch (Exception ignored) {
		}
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Slice<OrgaoCorreios> findAllSlice(Long id, Integer page, Integer size, String[] sort) {
		Pageable pagination = utilSortOrder.pagination(page, size, sort);
		Specification<OrgaoCorreios> specs = new OrgaoCorreiosSpecification(id);
		Slice<OrgaoCorreios> result = orgaoCorreiosSliceRepository.findAll(specs, pagination);
		try {
			log.info("ObjetoOrgaoCorreios: {}", mapper.writeValueAsString(result));
		} catch (Exception ignored) {
		}
		return result;
	}

	
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<OrgaoCorreios> findOrgaoCorreiosCaptacaoAutomaticaAtivada() {
		String[] sort = new String[1];
		sort[0] = "nomeUnidade";
		Sort sort2 = utilSortOrder.sorting(sort);
//		Pageable pagination = utilSortOrder.pagination(0, 1, sort);

		Specification<OrgaoCorreios> specs = OrgaoCorreiosSpecification.whereIsCaptacaoAutomaticaAtivado(true);

		List<OrgaoCorreios> objetoOrgaoCorreiosList = orgaoCorreiosRepository.findAll(specs, sort2);
//		LocalDateTime dataAtual = LocalDateTime.now();
//		dataAtual = dataAtual.minusDays(350);
//		Date dataVigencia = Date.from(dataAtual.atZone(ZoneId.systemDefault()).toInstant());
//		
//		List<String> objetoOrgaoCorreiosList = objetoOrgaoCorreiosRepository.findAll(specs);
		try {
			log.info("ObjetoOrgaoCorreios: {}", mapper.writeValueAsString(objetoOrgaoCorreiosList));
		} catch (Exception ignored) {
		}
		return objetoOrgaoCorreiosList;
	} 
}
