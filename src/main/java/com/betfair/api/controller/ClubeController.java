package com.betfair.api.controller;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.betfair.api.model.Clube;
import com.betfair.api.service.ClubeService;



@RestController
@RequestMapping(value="/clubes")
public class ClubeController {


	@Autowired
	private ClubeService clubeService;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Clube getById(@PathVariable Long id) throws Exception {
		Clube detail = (Clube) clubeService.getById(id);
        if (detail == null) {
            throw new Exception();
        } else {
            return detail;
        }
    }
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Clube> findAll() throws Exception {
		return clubeService.findAll();
    }
	
	//Procura com Like
	@RequestMapping(value = "/search/{place}", method = RequestMethod.GET)
    public List<Clube> findByPlaceContaining(@PathVariable String place) throws Exception {
		return clubeService.findByPlaceContaining(place.toUpperCase());
    }
	
	//Encontra o nome exato
	@RequestMapping(value = "/find/{place}", method = RequestMethod.GET)
    public Clube findByPlace(@PathVariable String place) throws Exception {
		return clubeService.findByPlace(place.toUpperCase());
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public Clube create(@RequestBody Clube detail) {
        return clubeService.save(detail);
	}

	@RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Clube detail) throws Exception {
		Clube clubeEncontrado = (Clube) clubeService.getById(detail.getId());
        if (detail == null) {
            throw new Exception();
        } else {
        	 clubeService.delete(clubeEncontrado);
        }
       
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info() throws Exception {
		return "Informações sobre a API de Clubes";
	}
	
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    static class ClubeNotFoundException extends RuntimeException {
//    }
}