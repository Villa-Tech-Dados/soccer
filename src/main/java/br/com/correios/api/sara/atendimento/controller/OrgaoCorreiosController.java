package br.com.correios.api.sara.atendimento.controller;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Slice;
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
import br.com.correios.api.commons.page.PageSlice;
import br.com.correios.api.sara.atendimento.model.OrgaoCorreios;
import br.com.correios.api.sara.atendimento.service.OrgaoCorreiosService;
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
@RequestMapping(value="/v1/orgaocorreios", produces=MediaType.APPLICATION_JSON_VALUE )
public class OrgaoCorreiosController {
	
	@Autowired
	private Environment env;
	
	private OrgaoCorreiosService orgaoCorreiosService;	
    private HttpServletResponse response;
    
    @Autowired
    private PagedResourcesAssembler<OrgaoCorreios> assembler;

	public OrgaoCorreiosController(OrgaoCorreiosService objetoOrgaoCorreiosService, HttpServletResponse response) {
        this.orgaoCorreiosService = objetoOrgaoCorreiosService;
        this.response = response;
    }

    @ApiOperation(value = "Lista Orgao Correios de forma paginada, (NÃO ocorre count() em cada requisição). Retorna um booleano indicando se há uma próxima página.", notes="Retorna uma Lista de ObjetoOrgaoCorreios")
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public PageSlice<OrgaoCorreios> listaObjetoOrgaoCorreiosSlice(@ApiParam(value="Id da objetoOrgaoCorreios") @RequestParam(name="id", required=false) Long id,
                                                 @ApiParam(value="Número da página") @RequestParam(name="page", required=false, defaultValue="0") Integer page,
                                                 @ApiParam(value="Tamanho da página") @RequestParam(name="size", required=false, defaultValue="50") Integer size,
                                                 @ApiParam(value="Ordenação") @RequestParam(name="sort", required=false) String[] sort ) {        
        Slice<OrgaoCorreios> list = this.orgaoCorreiosService.findAllSlice(id, page, size, sort);  
        PageSlice<OrgaoCorreios> result = new PageSlice<OrgaoCorreios>(list);
        return result;
    }

    @ApiOperation(value = "Lista Orgao Correios sem paginação.", notes="Retorna uma Lista de ObjetoOrgaoCorreios")
    @GetMapping("/sempaginacao")
    @ResponseStatus(value = HttpStatus.OK)
    public List<OrgaoCorreios> listaObjetoOrgaoCorreios(@ApiParam(value="Id da objetoOrgaoCorreios") @RequestParam(name="id", required=false) Long id, 
    		@ApiParam(value="Ordenação") @RequestParam(name="sort", required=false) String[] sort) {    
        List<OrgaoCorreios> result = this.orgaoCorreiosService.findAll(id, sort);   
        return result;
    }

    @ApiOperation(value = "Consulta Orgao Correios pelo seu identificador")
    @GetMapping(value="/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public OrgaoCorreios consultaObjetoOrgaoCorreios(@ApiParam(value="Número do objetoOrgaoCorreios") @PathVariable("id") Long id) {
        OrgaoCorreios result = null;
        Optional<OrgaoCorreios> objetoOrgaoCorreios = this.orgaoCorreiosService.consultaObjetoOrgaoCorreios(id);
        if(objetoOrgaoCorreios.isPresent()){
            result = objetoOrgaoCorreios.get();
        } else {
           throw new ApiNegocioRuntimeException(env.getProperty("OrgaoCorreios.naoEncontrado"), HttpStatus.NOT_FOUND);
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
    @GetMapping("/captacaoautomatica")
    @ResponseStatus(value = HttpStatus.OK)
    public List<OrgaoCorreios> findOrgaoCorreiosCaptacaoAutomaticaAtivada() {   
    	return this.orgaoCorreiosService.findOrgaoCorreiosCaptacaoAutomaticaAtivada();
    }
    
    
}
