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
import br.com.correios.api.sara.atendimento.model.Caixa;
import br.com.correios.api.sara.atendimento.service.CaixaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags={ "Caixa"}, description="Caixas dos SARA")

@ApiResponses(value= {
        @ApiResponse(code=400, message="Caso ocorra alguma validação necessário por parte do requisitante.", response=MessageResponse.class),
        @ApiResponse(code=500, message="Caso ocorra algum erro no servidor.", response=MessageResponse.class)
})


@RestController
@RequestMapping(value="/v1/caixas", produces=MediaType.APPLICATION_JSON_VALUE )
public class CaixaController {
	
	@Autowired
	private Environment env;
	
	private CaixaService caixaService;	
    private HttpServletResponse response;
    
    @Autowired
    private PagedResourcesAssembler<Caixa> assembler;

	public CaixaController(CaixaService objetoCaixaService, HttpServletResponse response) {
        this.caixaService = objetoCaixaService;
        this.response = response;
    }

    @ApiOperation(value = "Lista Caixas de forma paginada, (NÃO ocorre count() em cada requisição). Retorna um booleano indicando se há uma próxima página.", notes="Retorna uma Lista de ObjetoCaixa")
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public PageSlice<Caixa> listaObjetoCaixaSlice(@ApiParam(value="Id da objetoCaixa") @RequestParam(name="id", required=false) Long id,
                                                 @ApiParam(value="Número da página") @RequestParam(name="page", required=false, defaultValue="0") Integer page,
                                                 @ApiParam(value="Tamanho da página") @RequestParam(name="size", required=false, defaultValue="50") Integer size,
                                                 @ApiParam(value="Ordenação") @RequestParam(name="sort", required=false) String[] sort ) {        
        Slice<Caixa> list = this.caixaService.findAllSlice(id, page, size, sort);  
        PageSlice<Caixa> result = new PageSlice<Caixa>(list);
        return result;
    }

    @ApiOperation(value = "Lista Caixas sem paginação.", notes="Retorna uma Lista de ObjetoCaixa")
    @GetMapping("/sempaginacao")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Caixa> listaObjetoCaixa(@ApiParam(value="Id da objetoCaixa") @RequestParam(name="id", required=false) Long id, 
    		@ApiParam(value="Ordenação") @RequestParam(name="sort", required=false) String[] sort) {    
        List<Caixa> result = this.caixaService.findAll(id, sort);   
        return result;
    }

    @ApiOperation(value = "Consulta Caixas pelo seu identificador")
    @GetMapping(value="/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Caixa consultaObjetoCaixa(@ApiParam(value="Id do Caixa") @PathVariable("id") Long id) {
        Caixa result = null;
        Optional<Caixa> objetoCaixa = this.caixaService.consultaObjetoCaixa(id);
        if(objetoCaixa.isPresent()){
            result = objetoCaixa.get();
        } else {
           throw new ApiNegocioRuntimeException(env.getProperty("Caixa.naoEncontrado"), HttpStatus.NOT_FOUND);
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
    
    @ApiOperation(value = "Obtem Caixas.", notes="")
    @GetMapping("/usuario/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Caixa> findCaixasPorUsuario(@ApiParam(value="Id Usuario") @PathVariable("id") Long numeroUsuario) {   
    	return this.caixaService.findCaixasPorUsuario(numeroUsuario);
    }
    
    @ApiOperation(value = "Obtem o Caixa aberto por um Usuario.", notes="")
    @GetMapping("/aberto/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<Caixa> findCaixaAbertoPorUsuario(@ApiParam(value="Id Usuario") @PathVariable("id") Long numeroUsuario) {   
    	return this.caixaService.findCaixaAbertoPorUsuario(numeroUsuario);
    }
    
}
