package br.com.correios.api.sara.atendimento.service;

import java.util.ArrayList;
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
import br.com.correios.api.sara.atendimento.model.Atendimento;
import br.com.correios.api.sara.atendimento.model.ItemAtendimento;
import br.com.correios.api.sara.atendimento.repository.ItemAtendimentoRepository;
import br.com.correios.api.sara.atendimento.repository.ItemAtendimentoSliceRepository;
import br.com.correios.api.sara.atendimento.specification.ItemAtendimentoSpecification;

@Service
public class ItemAtendimentoService {

	private Logger log = LoggerFactory.getLogger(ItemAtendimentoService.class);

	@Autowired
	private ItemAtendimentoRepository itemAtendimentoRepository;
	@Autowired
	private ItemAtendimentoSliceRepository itemAtendimentoSliceRepository;
	@Autowired
	private Environment environment;
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private UtilSortOrder utilSortOrder;
	@Autowired
	private AtendimentoService atendimentoService;	
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<ItemAtendimento> consultaItemAtendimento(Long nuItemAtendimento) {
		Optional<ItemAtendimento> result = itemAtendimentoRepository.findById(nuItemAtendimento);
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<ItemAtendimento> consultaItemAtendimentoComRedis(Integer nuItemAtendimento) {
		Optional<ItemAtendimento> result = null;
		result = itemAtendimentoRepository.findById(nuItemAtendimento);
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void salva(ItemAtendimento itemAtendimento) {
		Optional<ItemAtendimento> exists = itemAtendimentoRepository.findById(itemAtendimento.getId());
		if (exists.isPresent()) {
			throw new ApiNegocioRuntimeException(environment.getProperty("ItemAtendimento.jaExistente"), exists.get().getId());
		}
		itemAtendimentoRepository.save(itemAtendimento);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void atualiza(ItemAtendimento itemAtendimento) {
		Optional<ItemAtendimento> exists = this.itemAtendimentoRepository.findById(itemAtendimento.getId());
		if (exists.isPresent()) {
			itemAtendimentoRepository.save(itemAtendimento);
		} else {
			throw new ApiNegocioRuntimeException(environment.getProperty("ItemAtendimento.naoEncontradoParaAtualizacao"));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(Integer nuItemAtendimento) {
		Optional<ItemAtendimento> exists = this.itemAtendimentoRepository.findById(nuItemAtendimento);
		if (exists.isPresent()) {
			itemAtendimentoRepository.deleteById(nuItemAtendimento);
		} else {
			throw new ApiNegocioRuntimeException(environment.getProperty("ItemAtendimento.naoEncontradoParaExclusao"));
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<ItemAtendimento> findAll(Long id, String[] sort) {
		Sort sort2 = utilSortOrder.sorting(sort);
		Specification<ItemAtendimento> specs = new ItemAtendimentoSpecification(id);
		List<ItemAtendimento> result = itemAtendimentoRepository.findAll(specs, sort2);
		try {
			log.info("ItemAtendimento: {}", mapper.writeValueAsString(result));
		} catch (Exception ignored) {
		}
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Page<ItemAtendimento> findAll(Long id, Integer page, Integer size, String[] sort) {
		Pageable pagination = utilSortOrder.pagination(page, size, sort);
		Specification<ItemAtendimento> specs = new ItemAtendimentoSpecification(id);
		Page<ItemAtendimento> result = itemAtendimentoRepository.findAll(specs, pagination);
		try {
			log.info("ItemAtendimento: {}", mapper.writeValueAsString(result));
		} catch (Exception ignored) {
		}
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Slice<ItemAtendimento> findAllSlice(Long id, Integer page, Integer size, String[] sort) {
		Pageable pagination = utilSortOrder.pagination(page, size, sort);
		Specification<ItemAtendimento> specs = new ItemAtendimentoSpecification(id);
		Slice<ItemAtendimento> result = itemAtendimentoSliceRepository.findAll(specs, pagination);
		try {
			log.info("ItemAtendimento: {}", mapper.writeValueAsString(result));
		} catch (Exception ignored) {
		}
		return result;
	}

	
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<ItemAtendimento> findItemAtendimentosPorMcu(Long idOrgaoCorreios) {

		Specification<ItemAtendimento> specs = ItemAtendimentoSpecification.whereMCU(idOrgaoCorreios)
												.and(ItemAtendimentoSpecification.whereIsVigente());

		List<ItemAtendimento> itemAtendimentoList = itemAtendimentoRepository.findAll(specs);
		
		try {
			log.info("ItemAtendimento: {}", mapper.writeValueAsString(itemAtendimentoList));
		} catch (Exception ignored) {
		}
		return itemAtendimentoList;
	} 
	
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<ItemAtendimento> findItemAtendimentosVigentesPorMcu(Long idOrgaoCorreios) {

		
		List<Atendimento> atendimentoList = atendimentoService.findAtendimentosVigentesPorMcu(idOrgaoCorreios);
		if(atendimentoList == null || atendimentoList.isEmpty()) {
			return null;
		}
		List<Long> idAtendimentoList = new ArrayList<Long>();
		for(Atendimento atendimento: atendimentoList) idAtendimentoList.add(atendimento.getId());
		
		Specification<ItemAtendimento> specs = ItemAtendimentoSpecification.whereAtendimento(idAtendimentoList)
					.and(ItemAtendimentoSpecification.whereIsVigente())
				;

		List<ItemAtendimento> itemAtendimentoList = itemAtendimentoRepository.findAll(specs);
		
		try {
			log.info("ItemAtendimento: {}", mapper.writeValueAsString(itemAtendimentoList));
		} catch (Exception ignored) {
		}
		return itemAtendimentoList;
	}
}
