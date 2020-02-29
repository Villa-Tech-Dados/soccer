package br.com.correios.api.sara.atendimento.controller;


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

import br.com.correios.api.commons.exception.ApiNegocioRuntimeException;
import br.com.correios.api.commons.exception.MessageResponse;
import br.com.correios.api.sara.atendimento.model.OrgaoCorreiosSubordinada;
import br.com.correios.api.sara.atendimento.service.OrgaoCorreiosSubordinadaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags={ "Orgao Correios"}, description="Unidades dos Correios")

@ApiResponses(value= {
        @ApiResponse(code=400, message="Caso ocorra alguma validação necessário por parte do requisitante.", response=MessageResponse.class),
        @ApiResponse(code=500, message="Caso ocorra algum erro no servidor.", response=MessageResponse.class)
})


@RestController
@RequestMapping(value="/v1/orgaocorreiossubordinada", produces=MediaType.APPLICATION_JSON_VALUE )
public class OrgaoCorreiosSubordinadaController {
	
	@Autowired
	private Environment env;
	
	private OrgaoCorreiosSubordinadaService OrgaoCorreiosSubordinadaService;	
    private HttpServletResponse response;
    
    @Autowired
    private PagedResourcesAssembler<OrgaoCorreiosSubordinada> assembler;

	public OrgaoCorreiosSubordinadaController(OrgaoCorreiosSubordinadaService objetoOrgaoCorreiosSubordinadaService, HttpServletResponse response) {
        this.OrgaoCorreiosSubordinadaService = objetoOrgaoCorreiosSubordinadaService;
        this.response = response;
    }

    @ApiOperation(value = "Lista Orgao Correios sem paginação.", notes="Retorna uma Lista de ObjetoOrgaoCorreiosSubordinada")
    @GetMapping("/sempaginacao")
    @ResponseStatus(value = HttpStatus.OK)
    public List<OrgaoCorreiosSubordinada> listaObjetoOrgaoCorreiosSubordinada(@ApiParam(value="Id da objetoOrgaoCorreiosSubordinada") @RequestParam(name="id", required=false) Long id, 
    		@ApiParam(value="Ordenação") @RequestParam(name="sort", required=false) String[] sort) {    
        List<OrgaoCorreiosSubordinada> result = this.OrgaoCorreiosSubordinadaService.findAll(id, sort);   
        return result;
    }

    @ApiOperation(value = "Consulta Orgao Correios pelo seu identificador")
    @GetMapping(value="/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public OrgaoCorreiosSubordinada consultaObjetoOrgaoCorreiosSubordinada(@ApiParam(value="Número do objetoOrgaoCorreiosSubordinada") @PathVariable("id") Long id) {
        OrgaoCorreiosSubordinada result = null;
        Optional<OrgaoCorreiosSubordinada> objetoOrgaoCorreiosSubordinada = this.OrgaoCorreiosSubordinadaService.consultaObjetoOrgaoCorreiosSubordinada(id);
        if(objetoOrgaoCorreiosSubordinada.isPresent()){
            result = objetoOrgaoCorreiosSubordinada.get();
        } else {
           throw new ApiNegocioRuntimeException(env.getProperty("OrgaoCorreiosSuboirdinada.naoEncontrado"), HttpStatus.NOT_FOUND);
        }
        return result;
    }

    @ApiOperation(value = "Exemplificação de ocorrencia de timeout, quando utilizado um gateway.")
    @GetMapping(value="/timeout")
    @ResponseStatus(value = HttpStatus.OK)
    public void timeout() {
        try {
            Thread.sleep(360000);
         } catch (Exception e) {
            e.printStackTrace();
         }        
    }    

    
    @ApiOperation(value = "Obtem Orgao Correios.", notes="")
    @GetMapping("/subordinadora/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public OrgaoCorreiosSubordinada findOrgaoCorreiosSubordinadaCaptacaoAutomaticaAtivada(@ApiParam(value="Id do orgaoCorreios da Subordinada") @PathVariable("id") Long id) {   
    	return this.OrgaoCorreiosSubordinadaService.findOrgaoCorreiosSubordinadora(id);
    }
    
    
}
