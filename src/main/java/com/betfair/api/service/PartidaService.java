package com.betfair.api.service;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

import com.betfair.api.model.Partida;
import com.betfair.api.repository.PartidaRepository;
import com.betfair.api.specification.PartidaSpecification;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PartidaService {


	private Logger log = LoggerFactory.getLogger(PartidaService.class);

	@Autowired
	private PartidaRepository clubeRepository;
	@Autowired
	private Environment environment;
	@Autowired
	private ObjectMapper mapper;

	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<Partida> consultaPartida(Long id) {
		Optional<Partida> result = clubeRepository.findById(id);
		return result;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Optional<Partida> consultaPartidaComRedis(Long id) {
		Optional<Partida> result = null;
		result = clubeRepository.findById(id);
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void salva(Partida clube) {
		Optional<Partida> exists = clubeRepository.findById(clube.getId());
		if (exists.isPresent()) {
//			throw new RuntimeException(environment.getProperty("Partida.jaExistente"), exists.get().getId());
		}
		clubeRepository.save(clube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void atualiza(Partida clube) {
		Optional<Partida> exists = this.clubeRepository.findById(clube.getId());
		if (exists.isPresent()) {
			clubeRepository.save(clube);
		} else {
			throw new RuntimeException(environment.getProperty("Partida.naoEncontradoParaAtualizacao"));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(Long id) {
		Optional<Partida> exists = this.clubeRepository.findById(id);
		if (exists.isPresent()) {
			clubeRepository.deleteById(id);
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
			boolean isCabecalho = false;
			if(br.ready()) {
				linha1 = br.readLine(); //﻿ROMÊNIALiga 2
				linha2 = br.readLine(); //﻿1
				linha3 = br.readLine(); //﻿X
				linha4 = br.readLine(); //﻿2				
				isCabecalho = true;
			}
			while (br.ready()) {
				if(isCabecalho) {
					//Linha com Nome da Liga
					partida = new Partida();
					boolean acheiMinuscula = false;
					int pos = 0;
					while(!acheiMinuscula && pos < linha1.length()) {
						if(linha1.charAt(pos) >= 97 && linha1.charAt(pos) <= 122) { //Minuscula
							acheiMinuscula = true;
						}
						pos++;
					}
					String nomePais = linha1.substring(0, pos - 2);
					String nomeLiga = linha1.substring(pos - 2, linha1.length());
//					partida.setPais(nomePais.trim());
//					partida.setLiga(nomeLiga.trim());
					isCabecalho = false;
				}else {
					String encerrado = br.readLine();
					if(!encerrado.equals("Encerrado")) {
						isCabecalho = true;
						linha1 = encerrado; //﻿ROMÊNIALiga 2
						linha2 = br.readLine(); //﻿1
						linha3 = br.readLine(); //﻿X
						linha4 = br.readLine(); //﻿2				
						isCabecalho = true;
					}else {
						isCabecalho = false;
						String data = file.substring(0, 10);
//						partida.setData(data);
//						partida.setHora("00:00:00");
//						String timeCasa = br.readLine();
//						partida.setTime_casa(timeCasa.trim());
//						String timeFora = br.readLine();
//						partida.setTime_fora(timeFora.trim());
						String resultado = br.readLine();
						String[] placar = resultado.split(" - ");
						String placarCasa = placar[0];
						partida.setGols_time_casa(new Long(placarCasa));
						String placarFora = placar[1];
						partida.setGols_time_fora(new Long(placarFora));
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
