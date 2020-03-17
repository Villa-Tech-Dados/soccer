package com.betfair.api.model;

import java.io.Serializable;
import java.util.Date;

public class Partida implements Serializable{

	private String data;
	
	private String hora;
	
	private String pais;
	
	private String liga;
	
	private String time_casa;
	
	private String time_fora;
	
	private Long gols_time_casa;
	
	private Long gols_time_fora;
	
	private Double odd_casa;
	
	private Double odd_empate;
	
	private Double odd_fora;

	public Partida() {
	}
	
	

	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public String getHora() {
		return hora;
	}



	public void setHora(String hora) {
		this.hora = hora;
	}



	public String getLiga() {
		return liga;
	}

	public void setLiga(String liga) {
		this.liga = liga;
	}

	public String getTime_casa() {
		return time_casa;
	}

	public void setTime_casa(String time_casa) {
		this.time_casa = time_casa;
	}

	public String getTime_fora() {
		return time_fora;
	}

	public void setTime_fora(String time_fora) {
		this.time_fora = time_fora;
	}

	public Long getGols_time_casa() {
		return gols_time_casa;
	}

	public void setGols_time_casa(Long gols_time_casa) {
		this.gols_time_casa = gols_time_casa;
	}

	public Long getGols_time_fora() {
		return gols_time_fora;
	}

	public void setGols_time_fora(Long gols_time_fora) {
		this.gols_time_fora = gols_time_fora;
	}

	public Double getOdd_casa() {
		return odd_casa;
	}

	public void setOdd_casa(Double odd_casa) {
		this.odd_casa = odd_casa;
	}

	public Double getOdd_empate() {
		return odd_empate;
	}

	public void setOdd_empate(Double odd_empate) {
		this.odd_empate = odd_empate;
	}

	public Double getOdd_fora() {
		return odd_fora;
	}

	public void setOdd_fora(Double odd_fora) {
		this.odd_fora = odd_fora;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Partida [data=" + data + ", hora=" + hora + ", pais=" + pais + ", liga=" + liga + ", time_casa="
				+ time_casa + ", time_fora=" + time_fora + ", gols_time_casa=" + gols_time_casa + ", gols_time_fora="
				+ gols_time_fora + ", odd_casa=" + odd_casa + ", odd_empate=" + odd_empate + ", odd_fora=" + odd_fora
				+ "]";
	}

}
