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
import br.com.correios.api.sara.atendimento.model.Caixa;
import br.com.correios.api.sara.atendimento.model.Usuario;
import br.com.correios.api.sara.atendimento.repository.AtendimentoRepository;
import br.com.correios.api.sara.atendimento.repository.AtendimentoSliceRepository;
import br.com.correios.api.sara.atendimento.specification.AtendimentoSpecification;

@Service
public class AtendimentoService {

	private Logger log = LoggerFactory.getLogger(AtendimentoService.class);

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	@Autowired
	private AtendimentoSliceRepository atendimentoSliceRepository;
	@Autowired
	private Environment environment;
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private UtilSortOrder utilSortOrder;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private CaixaService caixaService;
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<Atendimento> consultaObjetoAtendimento(Long nuObjetoAtendimento) {
		Optional<Atendimento> result = atendimentoRepository.findById(nuObjetoAtendimento);
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<Atendimento> consultaObjetoAtendimentoComRedis(Integer nuObjetoAtendimento) {
		Optional<Atendimento> result = null;
		result = atendimentoRepository.findById(nuObjetoAtendimento);
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void salva(Atendimento objetoAtendimento) {
		Optional<Atendimento> exists = atendimentoRepository.findById(objetoAtendimento.getId());
		if (exists.isPresent()) {
			throw new ApiNegocioRuntimeException(environment.getProperty("Atendimento.jaExistente"), exists.get().getId());
		}
		atendimentoRepository.save(objetoAtendimento);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void atualiza(Atendimento objetoAtendimento) {
		Optional<Atendimento> exists = this.atendimentoRepository.findById(objetoAtendimento.getId());
		if (exists.isPresent()) {
			atendimentoRepository.save(objetoAtendimento);
		} else {
			throw new ApiNegocioRuntimeException(environment.getProperty("Atendimento.naoEncontradoParaAtualizacao"));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(Integer nuObjetoAtendimento) {
		Optional<Atendimento> exists = this.atendimentoRepository.findById(nuObjetoAtendimento);
		if (exists.isPresent()) {
			atendimentoRepository.deleteById(nuObjetoAtendimento);
		} else {
			throw new ApiNegocioRuntimeException(environment.getProperty("Atendimento.naoEncontradoParaExclusao"));
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Atendimento> findAll(Long id, Long mcu, String[] sort) {
		Sort sort2 = utilSortOrder.sorting(sort);
		Specification<Atendimento> specs = new AtendimentoSpecification(id, mcu);
		List<Atendimento> result = atendimentoRepository.findAll(specs, sort2);
		try {
			log.info("ObjetoAtendimento: {}", mapper.writeValueAsString(result));
		} catch (Exception ignored) {
		}
		return result;
	}

	
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Atendimento> findAtendimentosVigentesPorMcu(Long mcu) {

		Optional<Usuario> usuario = usuarioService.findUsuarioCaptacaoAutomaticaPorMcu(mcu);
		Long numeroUsuario = usuario.get().getId();
		
		List<Caixa> caixaList = caixaService.findCaixasPorUsuario(numeroUsuario);
		if(caixaList == null || caixaList.isEmpty()) {
			return null;
		}
		List<Long> idCaixaList = new ArrayList<Long>();
		for(Caixa caixa: caixaList) idCaixaList.add(caixa.getId());
		
		Specification<Atendimento> specs = AtendimentoSpecification.whereIsVigente()
				.and(AtendimentoSpecification.whereCaixa(idCaixaList))
				;

		List<Atendimento> atendimentoList = atendimentoRepository.findAll(specs);
		
		try {
			log.info("ObjetoAtendimento: {}", mapper.writeValueAsString(atendimentoList));
		} catch (Exception ignored) {
		}
		return atendimentoList;
	} 
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Atendimento> findAtendimentosPendentesCaptacaoAutomaticaPorMcu(Long mcu) {

		Optional<Usuario> usuario = usuarioService.findUsuarioCaptacaoAutomaticaPorMcu(mcu);
		Long numeroUsuario = usuario.get().getId();
		
		Caixa caixaAberto = (caixaService.findCaixaAbertoPorUsuario(numeroUsuario)).orElse(null);
		if(caixaAberto == null) return null;
		
		Specification<Atendimento> specs = AtendimentoSpecification.whereIsVigente()
				.and(AtendimentoSpecification.whereCaixa(caixaAberto.getId()))
				.and(AtendimentoSpecification.whereIsPendente())
				;

		List<Atendimento> atendimentoList = atendimentoRepository.findAll(specs);
		
		try {
			log.info("ObjetoAtendimento: {}", mapper.writeValueAsString(atendimentoList));
		} catch (Exception ignored) {
		}
		return atendimentoList;
	} 
}
