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
import br.com.correios.api.sara.atendimento.model.ItemAtendimento;
import br.com.correios.api.sara.atendimento.service.ItemAtendimentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags={ "Itens de Atendimento"}, description="Itens de Atendiemnto do SARA")

@ApiResponses(value= {
        @ApiResponse(code=400, message="Caso ocorra alguma validação necessário por parte do requisitante.", response=MessageResponse.class),
        @ApiResponse(code=500, message="Caso ocorra algum erro no servidor.", response=MessageResponse.class)
})


@RestController
@RequestMapping(value="/v1/itematendimento", produces=MediaType.APPLICATION_JSON_VALUE )
public class ItemAtendimentoController {
	
	@Autowired
	private Environment env;
	
	private ItemAtendimentoService itemAtendimentoService;	
    private HttpServletResponse response;
    
    @Autowired
    private PagedResourcesAssembler<ItemAtendimento> assembler;

	public ItemAtendimentoController(ItemAtendimentoService objetoItemAtendimentoService, HttpServletResponse response) {
        this.itemAtendimentoService = objetoItemAtendimentoService;
        this.response = response;
    }

    @ApiOperation(value = "Lista ItemAtendimentos de forma paginada, (NÃO ocorre count() em cada requisição). Retorna um booleano indicando se há uma próxima página.", notes="Retorna uma Lista de ObjetoItemAtendimento")
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public PageSlice<ItemAtendimento> listaObjetoItemAtendimentoSlice(@ApiParam(value="Id da objetoItemAtendimento") @RequestParam(name="id", required=false) Long id,
                                                 @ApiParam(value="Número da página") @RequestParam(name="page", required=false, defaultValue="0") Integer page,
                                                 @ApiParam(value="Tamanho da página") @RequestParam(name="size", required=false, defaultValue="50") Integer size,
                                                 @ApiParam(value="Ordenação") @RequestParam(name="sort", required=false) String[] sort ) {        
        Slice<ItemAtendimento> list = this.itemAtendimentoService.findAllSlice(id, page, size, sort);  
        PageSlice<ItemAtendimento> result = new PageSlice<ItemAtendimento>(list);
        return result;
    }

    @ApiOperation(value = "Lista ItemAtendimentos sem paginação.", notes="Retorna uma Lista de ObjetoItemAtendimento")
    @GetMapping("/sempaginacao")
    @ResponseStatus(value = HttpStatus.OK)
    public List<ItemAtendimento> listaObjetoItemAtendimento(@ApiParam(value="Id da objetoItemAtendimento") @RequestParam(name="id", required=false) Long id, 
    		@ApiParam(value="Ordenação") @RequestParam(name="sort", required=false) String[] sort) {    
        List<ItemAtendimento> result = this.itemAtendimentoService.findAll(id, sort);   
        return result;
    }

    @ApiOperation(value = "Consulta ItemAtendimentos pelo seu identificador")
    @GetMapping(value="/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ItemAtendimento consultaObjetoItemAtendimento(@ApiParam(value="Id do ItemAtendimento") @PathVariable("id") Long id) {
        ItemAtendimento result = null;
        Optional<ItemAtendimento> objetoItemAtendimento = this.itemAtendimentoService.consultaItemAtendimento(id);
        if(objetoItemAtendimento.isPresent()){
            result = objetoItemAtendimento.get();
        } else {
           throw new ApiNegocioRuntimeException(env.getProperty("ItemAtendimento.naoEncontrado"), HttpStatus.NOT_FOUND);
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
    
    @ApiOperation(value = "Obtem ItemAtendimentos de Captação Automatica por MCU.", notes="")
    @GetMapping("/vigentes/{mcu}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<ItemAtendimento> findItemAtendimentosCaptacaoAutomaticaPorMcu(@ApiParam(value="Id OrgaoCorreios") @PathVariable("mcu") Long idOrgaoCorreios) {   
    	return this.itemAtendimentoService.findItemAtendimentosPorMcu(idOrgaoCorreios);
    }

    @ApiOperation(value = "Obtem ItemAtendimentos de Captação Automatica por MCU.", notes="")
    @GetMapping("/captacaoautomatica/{mcu}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<ItemAtendimento> findItemAtendimentosVigentesPorMcu(@ApiParam(value="Id OrgaoCorreios") @PathVariable("mcu") Long idOrgaoCorreios) {   
    	return this.itemAtendimentoService.findItemAtendimentosVigentesPorMcu(idOrgaoCorreios);
    }
    
}
