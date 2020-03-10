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



@RestController
@RequestMapping(value = "/v1/clube")
public class ClubeController {

	@Autowired
	private Environment env;

	@Autowired
	private ClubeService clubeService;
	
	private HttpServletResponse response;

	@Autowired
	private PagedResourcesAssembler<Clube> assembler;

	
	public ClubeController() {
		super();
	}

	public ClubeController(ClubeService clubeService, HttpServletResponse response) {
		this.clubeService = clubeService;
		this.response = response;
	}

	@GetMapping 
	@ResponseStatus(value = HttpStatus.OK)
	public List<Clube> listaObjetoClube(
			@RequestParam(name = "id", required = false) Long id,
			@RequestParam(name = "mcu", required = false) Long mcu,
			@RequestParam(name = "sort", required = false, defaultValue = "id") String[] sort) {
		
		List<Clube> result = this.clubeService.findAll(id, sort);
		return result;
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Clube consultaObjetoClube(@PathVariable("id") Long id) {
		Clube result = null;
		Optional<Clube> clube = this.clubeService.consultaObjetoClube(id);
		if (clube.isPresent()) {
			result = clube.get();
		} else {
			throw new RuntimeException(env.getProperty("Clube.naoEncontrado"));
		}
		return result;
	}

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
