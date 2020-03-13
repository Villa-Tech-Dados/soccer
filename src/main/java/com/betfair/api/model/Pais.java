package com.betfair.api.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "paises")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
public class Pais implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "clube_generator")
	@SequenceGenerator(
            name = "clube_generator",
            sequenceName = "clube_sequence"
			)
	private Long id;
	
	@Column(columnDefinition = "text")
	private String nome;
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "question_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
//	private Pais pais;

	public Pais() {
	}
	
	public Pais(String nome) {
		this.setNome(nome);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
		
	
}
