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
import br.com.correios.api.sara.atendimento.model.Usuario;
import br.com.correios.api.sara.atendimento.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags={ "Usuario"}, description="Usuarios dos SARA")

@ApiResponses(value= {
        @ApiResponse(code=400, message="Caso ocorra alguma validação necessário por parte do requisitante.", response=MessageResponse.class),
        @ApiResponse(code=500, message="Caso ocorra algum erro no servidor.", response=MessageResponse.class)
})


@RestController
@RequestMapping(value="/v1/usuarios", produces=MediaType.APPLICATION_JSON_VALUE )
public class UsuarioController {
	
	@Autowired
	private Environment env;
	
	private UsuarioService usuarioService;	
    private HttpServletResponse response;
    
    @Autowired
    private PagedResourcesAssembler<Usuario> assembler;

	public UsuarioController(UsuarioService objetoUsuarioService, HttpServletResponse response) {
        this.usuarioService = objetoUsuarioService;
        this.response = response;
    }

    @ApiOperation(value = "Lista Usuarios de forma paginada, (NÃO ocorre count() em cada requisição). Retorna um booleano indicando se há uma próxima página.", notes="Retorna uma Lista de ObjetoUsuario")
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public PageSlice<Usuario> listaObjetoUsuarioSlice(@ApiParam(value="Id da objetoUsuario") @RequestParam(name="id", required=false) Long id,
                                                 @ApiParam(value="Número da página") @RequestParam(name="page", required=false, defaultValue="0") Integer page,
                                                 @ApiParam(value="Tamanho da página") @RequestParam(name="size", required=false, defaultValue="50") Integer size,
                                                 @ApiParam(value="Ordenação") @RequestParam(name="sort", required=false) String[] sort ) {        
        Slice<Usuario> list = this.usuarioService.findAllSlice(id, page, size, sort);  
        PageSlice<Usuario> result = new PageSlice<Usuario>(list);
        return result;
    }

    @ApiOperation(value = "Lista Usuarios sem paginação.", notes="Retorna uma Lista de ObjetoUsuario")
    @GetMapping("/sempaginacao")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Usuario> listaObjetoUsuario(@ApiParam(value="Id da objetoUsuario") @RequestParam(name="id", required=false) Long id, 
    		@ApiParam(value="Ordenação") @RequestParam(name="sort", required=false) String[] sort) {    
        List<Usuario> result = this.usuarioService.findAll(id, sort);   
        return result;
    }

    @ApiOperation(value = "Consulta Usuarios pelo seu identificador")
    @GetMapping(value="/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Usuario consultaObjetoUsuario(@ApiParam(value="Id do Usuario") @PathVariable("id") Long id) {
        Usuario result = null;
        Optional<Usuario> objetoUsuario = this.usuarioService.consultaUsuario(id);
        if(objetoUsuario.isPresent()){
            result = objetoUsuario.get();
        } else {
           throw new ApiNegocioRuntimeException(env.getProperty("Usuario.naoEncontrado"), HttpStatus.NOT_FOUND);
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
    
    @ApiOperation(value = "Obtem Usuarios.", notes="")
    @GetMapping("/captacaoautomatica/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<Usuario> findUsuarioCaptacaoAutomaticaPorMcu(@ApiParam(value="Id Usuario") @PathVariable("id") Long idOrgaoCorreios) {   
    	return this.usuarioService.findUsuarioCaptacaoAutomaticaPorMcu(idOrgaoCorreios);
    }
    
    @ApiOperation(value = "Obtem Usuarios.", notes="")
    @GetMapping("/captacaoautomatica")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Usuario> findUsuariosCaptacaoAutomatica() {   
    	return this.usuarioService.findUsuariosCaptacaoAutomatica();
    }

    
}
