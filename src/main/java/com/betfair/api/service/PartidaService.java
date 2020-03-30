package com.betfair.api.service;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.betfair.api.model.Clube;
import com.betfair.api.model.Pais;
import com.betfair.api.model.Partida;
import com.betfair.api.repository.PartidaRepository;
import com.betfair.api.specification.PartidaSpecification;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PartidaService {


	private Logger log = LoggerFactory.getLogger(PartidaService.class);

	@Autowired
	private PartidaRepository partidaRepository;
	@Autowired
	private ClubeService clubeService;;
	@Autowired
	private PaisService paisService;;
	@Autowired
	private Environment environment;
	@Autowired
	private ObjectMapper mapper;

	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<Partida> consultaPartida(Long id) {
		Optional<Partida> result = partidaRepository.findById(id);
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<Partida> consultaPartidaComRedis(Long id) {
		Optional<Partida> result = null;
		result = partidaRepository.findById(id);
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void salva(Partida clube) {
		Optional<Partida> exists = partidaRepository.findById(clube.getId());
		if (exists.isPresent()) {
//			throw new RuntimeException(environment.getProperty("Partida.jaExistente"), exists.get().getId());
		}
		partidaRepository.save(clube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void atualiza(Partida clube) {
		Optional<Partida> exists = this.partidaRepository.findById(clube.getId());
		if (exists.isPresent()) {
			partidaRepository.save(clube);
		} else {
			throw new RuntimeException(environment.getProperty("Partida.naoEncontradoParaAtualizacao"));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(Long id) {
		Optional<Partida> exists = this.partidaRepository.findById(id);
		if (exists.isPresent()) {
			partidaRepository.deleteById(id);
		} else {
			throw new RuntimeException(environment.getProperty("Partida.naoEncontradoParaExclusao"));
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Partida> findAll(Long id, String nome, String[] sort) {
//		Sort sort2 = utilSortOrder.sorting(sort);
		Specification<Partida> specs = new PartidaSpecification(id, nome);
//		List<Partida> result = clubeRepository.findAll(specs, sort2);
//		try {
//			log.info("Partida: {}", mapper.writeValueAsString(result));
//		} catch (Exception ignored) {
//		}
//		return result;
		return null;
	}
	
	public ArrayList<Partida> parseToPartidaLista(String file) {
		ArrayList<Partida> partidas = new ArrayList<Partida>();
		String path = "//home//villa//resultados//" + file;
//		String path = "C:\\resultados\\" + file.getFile();
		try {
			Partida partida = new Partida();
			BufferedReader br = new BufferedReader(new FileReader(path));
			String linha1 = "";
			String linha2 = "";
			String linha3 = "";
			String linha4 = "";
			String linha5 = "";
			String nomePais = "";
			boolean isCabecalho = false;
			if(br.ready()) {
				linha1 = br.readLine(); //﻿ROMÊNIA
				linha2 = br.readLine(); //﻿W-League - Playoffs
				linha3 = br.readLine(); //﻿1
				linha4 = br.readLine(); //﻿X
				linha5 = br.readLine(); //﻿2				
				isCabecalho = true;
			}
			while (br.ready()) {
				if(isCabecalho) {
					//Linha com Nome da Liga
					partida = new Partida();
					boolean acheiMinuscula = false;
					nomePais = linha1;
					String nomeLiga = linha2;
					isCabecalho = false;
				}else {
					String encerrado = br.readLine();
					if(!encerrado.equals("Encerrado")) {
						isCabecalho = true;
						linha1 = encerrado; //﻿ROMÊNIA
						linha2 = br.readLine(); //﻿W-League - Playoffs
						linha3 = br.readLine(); //﻿1
						linha4 = br.readLine(); //﻿X
						linha5 = br.readLine(); //﻿2				
						isCabecalho = true;
					}else {
						isCabecalho = false;
						String data = file.substring(0, 10);
						DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate localData = LocalDate.parse(data, format);;
						partida.setData_hora(java.sql.Date.valueOf(localData));
//						partida.setHora("00:00:00");
						String clubeCasa = br.readLine();
						List<Clube> clubes = clubeService.findAll(null, clubeCasa);
						Clube clube = new Clube();
						Pais pais = new Pais();
						if(clubes.isEmpty()) { //Novo Clube
							clube.setNome(clubeCasa);
							List<Pais> paises = paisService.findAll(null, nomePais);
							if(paises.isEmpty()) {
								pais.setNome(nomePais);
								paisService.salva(pais);
								pais = paisService.findAll(null, nomePais).get(0);
							}else {
								pais = paises.get(0);	
							}
							clube.setPais(pais.getId());
							clubeService.salva(clube);
							clube = clubeService.findAll(null, clubeCasa).get(0);	
						}else {
							clube = clubes.get(0);	
						}
						partida.setId_clube_casa(clube.getId());
						
						String clubeFora = br.readLine();
						clubes = clubeService.findAll(null, clubeFora);
						clube = new Clube();
						pais = new Pais();
						if(clubes.isEmpty()) { //Novo Clube
							clube.setNome(clubeFora);
							List<Pais> paises = paisService.findAll(null, nomePais);
							if(paises.isEmpty()) {
								pais.setNome(nomePais);
								paisService.salva(pais);
								pais = paisService.findAll(null, nomePais).get(0);
							}else {
								pais = paises.get(0);	
							}
							clube.setPais(pais.getId());
							clubeService.salva(clube);
							clube = clubeService.findAll(null, clubeFora).get(0);	
						}else {
							clube = clubes.get(0);	
						}
						partida.setId_clube_fora(clube.getId());						
						
						String placarCasa = br.readLine();
						partida.setGols_clube_casa(new Long(placarCasa));
						br.readLine();
						String placarFora = br.readLine();
						partida.setGols_clube_fora(new Long(placarFora));
						Double oddCasa = new Double("0.0");
						String oddString = br.readLine();
						if(!oddString.equals("-")) {
							oddCasa = new Double(oddString);
						}
						partida.setOdd_casa(oddCasa);
						Double oddEmpate = new Double("0.0");
						oddString = br.readLine();
						if(!oddString.equals("-")) {
							oddEmpate = new Double(oddString);
						}
						partida.setOdd_empate(oddEmpate);
						Double oddFora = new Double("0.0");
						oddString = br.readLine();
						if(!oddString.equals("-")) {
							oddFora = new Double(oddString);
						}
						partida.setOdd_fora(oddFora);
						partidas.add(partida);
//						this.salva(partida);
					}
				}
			}
			br.close();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return partidas;
	}
	
	private boolean isNumber(String str) {
		if(str.matches("[0-9]")) {
			return true;
		}
		return false;
	}
}
