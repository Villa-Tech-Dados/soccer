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

import com.betfair.api.model.Clube;
import com.betfair.api.service.ClubeService;


@RestController
@RequestMapping(value="/v1/clubes", produces=MediaType.APPLICATION_JSON_VALUE )
public class ClubeController {
	
	
	@Autowired
	private ClubeService clubeService;
	
    @GetMapping("")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Clube> listaClube(
    		@RequestParam(name="id", required=false) Long id,
			@RequestParam(name = "nome", required = false) String nome,
    		@RequestParam(name="sort", required=false) String[] sort) {    
    	
        List<Clube> result = this.clubeService.findAll(id, nome);   
        return result;
    }

    @GetMapping(value="/{id}")
    public Clube consultaClube ( @PathVariable("id") Long id) {
        Clube result = null;
        Optional<Clube> clube = this.clubeService.consultaClube(id);
        if(clube.isPresent()){
            result = clube.get();
        } else {
//           throw new RuntimeException(env.getProperty("Clube.naoEncontrado"), HttpStatus.NOT_FOUND);
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
