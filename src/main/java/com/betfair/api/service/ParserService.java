package com.betfair.api.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.betfair.api.model.InterfacePartida;
import com.betfair.api.model.Partida;

@Service
public class ParserService {
	
	public ArrayList<Partida> converterTxtPartidasJson(InterfacePartida file) {
		ArrayList<Partida> partidas = new ArrayList<Partida>();
		String path = "//home//villa//resultados//" + file.getFile();
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
					partida.setPais(nomePais.trim());
					partida.setLiga(nomeLiga.trim());
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
						String data = file.getFile().substring(0, 10);
						partida.setData(data);
						partida.setHora("00:00:00");
						String timeCasa = br.readLine();
						partida.setTime_casa(timeCasa.trim());
						String timeFora = br.readLine();
						partida.setTime_fora(timeFora.trim());
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
	
	@Deprecated
	public ArrayList<Partida> converterTxtPartidasJsonOld(InterfacePartida file) {
		ArrayList<Partida> partidas = new ArrayList<Partida>();
		String path = "//home//villa//resultados//" + file.getFile();
//		String path = "C:\\resultados\\" + file.getFile();
		try {
			Partida partida = new Partida();
			BufferedReader br = new BufferedReader(new FileReader(path));
			while (br.ready()) {
				
				String linha = br.readLine();
				if(!isNumber(linha.substring(1, 2))) {
					//Linha com Nome da Liga
					partida = new Partida();
					String liga = linha.substring(0, linha.length() - 7);
					String[] ligaCampos = liga.split(":");
					partida.setPais(ligaCampos[0].trim());
					partida.setLiga(ligaCampos[1].trim());
				}else {
					//Linha com dados da partida
					String[] campos = linha.split("\t");
					if(!campos[4].equals("-")) {
						String data = file.getFile().substring(0, 10);
						partida.setData(data);
						String hora = campos[1];
						partida.setHora(hora);
						String timeCasa = campos[2];
						partida.setTime_casa(timeCasa.trim());
						String timeFora = campos[3];
						partida.setTime_fora(timeFora.trim());
						String[] placar = campos[4].split(" : ");
						String placarCasa = placar[0];
						partida.setGols_time_casa(new Long(placarCasa));
						String placarFora = placar[1];
						partida.setGols_time_fora(new Long(placarFora));
						Double oddCasa = new Double("0.0");
						if(!campos[5].equals("-")) {
							oddCasa = new Double(campos[5]);
						}
						partida.setOdd_casa(oddCasa);
						Double oddEmpate = new Double("0.0");
						if(!campos[6].equals("-")) {
							oddEmpate = new Double(campos[6]);
						}
						partida.setOdd_empate(oddEmpate);
						Double oddFora = new Double("0.0");
						if(!campos[7].equals("-")) {
							oddFora = new Double(campos[7]);
						}
						partida.setOdd_fora(oddFora);
					}
					partidas.add(partida);
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
