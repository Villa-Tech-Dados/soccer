package com.betfair.api.soccer.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.betfair.api.soccer.model.Clube;
import com.betfair.api.soccer.service.ClubeService;



//@Api(tags = { "Clubes" }, description = "Clubes do SARA")

//@ApiResponses(value = {
//		@ApiResponse(code = 400, message = "Caso ocorra alguma validação necessário por parte do requisitante.", response = MessageResponse.class),
//		@ApiResponse(code = 500, message = "Caso ocorra algum erro no servidor.", response = MessageResponse.class) })

@RestController
@RequestMapping(value = "/v1/atendimento", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClubeController {

	@Autowired
	private Environment env;

	private ClubeService atendimentoService;
	private HttpServletResponse response;

	@Autowired
	private PagedResourcesAssembler<Clube> assembler;

	public ClubeController(ClubeService atendimentoService, HttpServletResponse response) {
		this.atendimentoService = atendimentoService;
		this.response = response;
	}

//	@ApiOperation(value = "Lista atendimentos sem paginação.", notes = "Retorna uma Lista de ObjetoClube")
	@GetMapping 
	@ResponseStatus(value = HttpStatus.OK)
	public List<Clube> listaObjetoClube(
			/*@ApiParam(value = "Id da atendimento")*/ @RequestParam(name = "id", required = false) Long id,
			/*@ApiParam(value = "MCU da Unidade")*/ @RequestParam(name = "mcu", required = false) Long mcu,
			/*@ApiParam(value = "Ordenação")*/ @RequestParam(name = "sort", required = false, defaultValue = "id") String[] sort) {
		
		List<Clube> result = this.atendimentoService.findAll(id, mcu, sort);
		return result;
	}

//	@ApiOperation(value = "Consulta um atendimento pelo seu identificador")
	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Clube consultaObjetoClube(
			/*@ApiParam(value = "Número do atendimento")*/ @PathVariable("id") Long id) {
		Clube result = null;
		Optional<Clube> atendimento = this.atendimentoService.consultaObjetoClube(id);
		if (atendimento.isPresent()) {
			result = atendimento.get();
		} else {
			throw new RuntimeException(env.getProperty("Clube.naoEncontrado"));
		}
		return result;
	}

//	@ApiOperation(value = "Exemplificação de ocorrencia de timeout, quando utilizado um gateway.")
	@GetMapping(value = "/timeout")
	@ResponseStatus(value = HttpStatus.OK)
	public void timeout() {
		try {
			Thread.sleep(360000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
