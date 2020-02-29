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
import br.com.correios.api.sara.atendimento.model.Usuario;
import br.com.correios.api.sara.atendimento.repository.UsuarioRepository;
import br.com.correios.api.sara.atendimento.repository.UsuarioSliceRepository;
import br.com.correios.api.sara.atendimento.specification.UsuarioSpecification;

@Service
public class UsuarioService {

	private Logger log = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private UsuarioSliceRepository usuarioSliceRepository;
	@Autowired
	private Environment environment;
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private UtilSortOrder utilSortOrder;

	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<Usuario> consultaUsuario(Long nuUsuario) {
		Optional<Usuario> result = usuarioRepository.findById(nuUsuario);
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<Usuario> consultaUsuarioComRedis(Integer nuUsuario) {
		Optional<Usuario> result = null;
		result = usuarioRepository.findById(nuUsuario);
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void salva(Usuario objetoUsuario) {
		Optional<Usuario> exists = usuarioRepository.findById(objetoUsuario.getId());
		if (exists.isPresent()) {
			throw new ApiNegocioRuntimeException(environment.getProperty("Usuario.jaExistente"), exists.get().getId());
		}
		usuarioRepository.save(objetoUsuario);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void atualiza(Usuario objetoUsuario) {
		Optional<Usuario> exists = this.usuarioRepository.findById(objetoUsuario.getId());
		if (exists.isPresent()) {
			usuarioRepository.save(objetoUsuario);
		} else {
			throw new ApiNegocioRuntimeException(environment.getProperty("Usuario.naoEncontradoParaAtualizacao"));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(Integer nuUsuario) {
		Optional<Usuario> exists = this.usuarioRepository.findById(nuUsuario);
		if (exists.isPresent()) {
			usuarioRepository.deleteById(nuUsuario);
		} else {
			throw new ApiNegocioRuntimeException(environment.getProperty("Usuario.naoEncontradoParaExclusao"));
		}
	}

//	@Transactional(propagation=Propagation.SUPPORTS)
//	public List<Usuario> findAll(Specification<Usuario> spec) {
//		List<Usuario> result = objetoUsuarioRepository.findAll(spec);
//		try {
//			log.info("Usuarios: {}", mapper.writeValueAsString(result));
//		} catch (Exception ignored) {
//		}
//		return result;
//	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Usuario> findAll(Long id, String[] sort) {
		Sort sort2 = utilSortOrder.sorting(sort);
		Specification<Usuario> specs = new UsuarioSpecification(id);
		List<Usuario> result = usuarioRepository.findAll(specs, sort2);
		try {
			log.info("Usuario: {}", mapper.writeValueAsString(result));
		} catch (Exception ignored) {
		}
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Page<Usuario> findAll(Long id, Integer page, Integer size, String[] sort) {
		Pageable pagination = utilSortOrder.pagination(page, size, sort);
		Specification<Usuario> specs = new UsuarioSpecification(id);
		Page<Usuario> result = usuarioRepository.findAll(specs, pagination);
		try {
			log.info("Usuario: {}", mapper.writeValueAsString(result));
		} catch (Exception ignored) {
		}
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Slice<Usuario> findAllSlice(Long id, Integer page, Integer size, String[] sort) {
		Pageable pagination = utilSortOrder.pagination(page, size, sort);
		Specification<Usuario> specs = new UsuarioSpecification(id);
		Slice<Usuario> result = usuarioSliceRepository.findAll(specs, pagination);
		try {
			log.info("Usuario: {}", mapper.writeValueAsString(result));
		} catch (Exception ignored) {
		}
		return result;
	}

	
	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<Usuario> findUsuarioCaptacaoAutomaticaPorMcu(Long idOrgaoCorreios) {
//		String[] sort = new String[1];
//		sort[0] = "id";
//		Sort sort2 = utilSortOrder.sorting(sort);
//		Pageable pagination = utilSortOrder.pagination(0, 1, sort);

		Specification<Usuario> specs = UsuarioSpecification.whereIsUsuarioVirtual(true)
				.and(UsuarioSpecification.whereMCU(idOrgaoCorreios));
		
		Optional<Usuario> usuario = usuarioRepository.findOne(specs);
//		LocalDateTime dataAtual = LocalDateTime.now();
//		dataAtual = dataAtual.minusDays(350);
//		Date dataVigencia = Date.from(dataAtual.atZone(ZoneId.systemDefault()).toInstant());
//		
//		List<String> objetoUsuarioList = objetoUsuarioRepository.findAll(specs);
		try {
			log.info("Usuario: {}", mapper.writeValueAsString(usuario));
		} catch (Exception ignored) {
		}
		return usuario;
	} 
	
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Usuario> findUsuariosCaptacaoAutomatica() {

		Specification<Usuario> specs = UsuarioSpecification.whereIsUsuarioVirtual(true);
		
		List<Usuario> objetoUsuarioList = usuarioRepository.findAll(specs);
		try {
			log.info("Usuario: {}", mapper.writeValueAsString(objetoUsuarioList));
		} catch (Exception ignored) {
		}
		return objetoUsuarioList;
	} 
}
