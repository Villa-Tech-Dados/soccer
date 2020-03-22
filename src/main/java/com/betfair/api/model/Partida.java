package com.betfair.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "partidas")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
public class Partida implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "partida_generator")
	@SequenceGenerator(
            name = "partida_generator",
            sequenceName = "partida_id_seq"
			)
	private Long id;
	
	@Column(columnDefinition = "date")
	private Date data_hora;
	
	@Column(columnDefinition = "integer")
	private Long id_liga;
	
	@Column(columnDefinition = "integer")
	private Long id_clube_casa;
	
	@Column(columnDefinition = "integer")
	private Long id_clube_fora;
	
	@Column(columnDefinition = "integer")
	private Long gols_clube_casa;
	
	@Column(columnDefinition = "integer")
	private Long gols_clube_fora;
	
	@Column(columnDefinition = "double precision")
	private Double odd_casa;
	
	@Column(columnDefinition = "double precision")
	private Double odd_empate;
	
	@Column(columnDefinition = "double precision")
	private Double odd_fora;
	
//	@Column(columnDefinition = "text")
//	private String nome;
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "question_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
//	private Pais pais;

	public Partida() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData_hora() {
		return data_hora;
	}

	public void setData_hora(Date data_hora) {
		this.data_hora = data_hora;
	}

	public Long getId_liga() {
		return id_liga;
	}

	public void setId_liga(Long id_liga) {
		this.id_liga = id_liga;
	}

	public Long getId_clube_casa() {
		return id_clube_casa;
	}

	public void setId_clube_casa(Long id_clube_casa) {
		this.id_clube_casa = id_clube_casa;
	}

	public Long getId_clube_fora() {
		return id_clube_fora;
	}

	public void setId_clube_fora(Long id_clube_fora) {
		this.id_clube_fora = id_clube_fora;
	}

	public Long getGols_clube_casa() {
		return gols_clube_casa;
	}

	public void setGols_clube_casa(Long gols_clube_casa) {
		this.gols_clube_casa = gols_clube_casa;
	}

	public Long getGols_clube_fora() {
		return gols_clube_fora;
	}

	public void setGols_clube_fora(Long gols_clube_fora) {
		this.gols_clube_fora = gols_clube_fora;
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
		
	
}
