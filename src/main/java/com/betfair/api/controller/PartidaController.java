package com.betfair.api.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.betfair.api.model.Partida;
import com.betfair.api.service.PartidaService;


@RestController
@RequestMapping(value="/v1/partidas", produces=MediaType.APPLICATION_JSON_VALUE )
public class PartidaController {
	
	
	@Autowired
	private PartidaService partidaService;
	
    @GetMapping("/parse")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Partida> parseToPartidaLista(
    		@RequestParam(name="file", required=false) String file) {    
    	
        List<Partida> result = this.partidaService.parseToPartidaLista(file);   
        
        return result;
    }

    @GetMapping("")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Partida> listaPartida(
    		@RequestParam(name="id", required=false) Long id,
			@RequestParam(name = "nome", required = false) String nome,
    		@RequestParam(name="sort", required=false) String[] sort) {    
    	
        List<Partida> result = this.partidaService.findAll(id, nome, sort);   
        return result;
    }

    @GetMapping(value="/{id}")
    public Partida consultaPartida ( @PathVariable("id") Long id) {
        Partida result = null;
        Optional<Partida> partida = this.partidaService.consultaPartida(id);
        if(partida.isPresent()){
            result = partida.get();
        } else {
//           throw new RuntimeException(env.getProperty("Partida.naoEncontrado"), HttpStatus.NOT_FOUND);
        }
        return result;
    }

    @GetMapping(value="/clubeout")
    @ResponseStatus(value = HttpStatus.OK)
    public void clubeout() {
        try {
            Thread.sleep(360000);
         } catch (Exception e) {
            e.printStackTrace();
         }        
    }     

}
