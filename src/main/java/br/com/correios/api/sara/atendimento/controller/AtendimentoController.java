package br.com.correios.api.sara.atendimento.controller;

import java.util.List;
import java.util.Map;
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

import br.com.correios.api.commons.exception.ApiNegocioRuntimeException;
import br.com.correios.api.commons.exception.MessageResponse;
import br.com.correios.api.sara.atendimento.model.Atendimento;
import br.com.correios.api.sara.atendimento.service.AtendimentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = { "Atendimentos" }, description = "Atendimentos do SARA")

@ApiResponses(value = {
		@ApiResponse(code = 400, message = "Caso ocorra alguma validação necessário por parte do requisitante.", response = MessageResponse.class),
		@ApiResponse(code = 500, message = "Caso ocorra algum erro no servidor.", response = MessageResponse.class) })

@RestController
@RequestMapping(value = "/v1/atendimento", produces = MediaType.APPLICATION_JSON_VALUE)
public class AtendimentoController {

	@Autowired
	private Environment env;

	private AtendimentoService atendimentoService;
	private HttpServletResponse response;

	@Autowired
	private PagedResourcesAssembler<Atendimento> assembler;

	public AtendimentoController(AtendimentoService atendimentoService, HttpServletResponse response) {
		this.atendimentoService = atendimentoService;
		this.response = response;
	}

	@ApiOperation(value = "Lista atendimentos sem paginação.", notes = "Retorna uma Lista de ObjetoAtendimento")
	@GetMapping 
	@ResponseStatus(value = HttpStatus.OK)
	public List<Atendimento> listaObjetoAtendimento(
			@ApiParam(value = "Id da atendimento") @RequestParam(name = "id", required = false) Long id,
			@ApiParam(value = "MCU da Unidade") @RequestParam(name = "mcu", required = false) Long mcu,
			@ApiParam(value = "Ordenação") @RequestParam(name = "sort", required = false, defaultValue = "id") String[] sort) {
		
		List<Atendimento> result = this.atendimentoService.findAll(id, mcu, sort);
		return result;
	}

	@ApiOperation(value = "Consulta um atendimento pelo seu identificador")
	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Atendimento consultaObjetoAtendimento(
			@ApiParam(value = "Número do atendimento") @PathVariable("id") Long id) {
		Atendimento result = null;
		Optional<Atendimento> atendimento = this.atendimentoService.consultaObjetoAtendimento(id);
		if (atendimento.isPresent()) {
			result = atendimento.get();
		} else {
			throw new ApiNegocioRuntimeException(env.getProperty("Atendimento.naoEncontrado"), HttpStatus.NOT_FOUND);
		}
		return result;
	}

	@ApiOperation(value = "Exemplificação de ocorrencia de timeout, quando utilizado um gateway.")
	@GetMapping(value = "/timeout")
	@ResponseStatus(value = HttpStatus.OK)
	public void timeout() {
		try {
			Thread.sleep(360000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ApiOperation(value = "Obtem os Atendimentos Vigentes de Captação Automatica.", notes = "")
	@GetMapping("/{mcu}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Atendimento> findAtendimentosVigentesPorMcu(@RequestParam Map<String, String> customQuery) {
		Long mcu = 0L;
		if (customQuery.containsKey("mcu"))
			mcu = Long.valueOf(customQuery.get("mcu"));
		return this.atendimentoService.findAtendimentosVigentesPorMcu(mcu);
	}
	
	//TODO Alterar para que seja uma consulta de dominio de List<Atendimento> listaObjetoAtendimento
    @ApiOperation(value = "Obtem os Atendimentos Vigentes de Captação Automatica.", notes="")
    @GetMapping("/vigentes/{mcu}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Atendimento> findAtendimentosVigentesPorMcu(@ApiParam(value="mcu")  @PathVariable("mcu") Long mcu) {   
    	return this.atendimentoService.findAtendimentosVigentesPorMcu(mcu);
    }
}
