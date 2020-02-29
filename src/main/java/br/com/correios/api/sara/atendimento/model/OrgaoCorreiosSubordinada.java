package br.com.correios.api.sara.atendimento.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Documentação da classe.")

@Entity
@Table(name = "NEP_AGENCIA_SUBORDINADA")
public class OrgaoCorreiosSubordinada implements Serializable {

	@ApiModelProperty(value = "Id da Unidade", required = true, notes = "")
	@Id
	@Column(name = "ORG_NU_AGENCIA")
	private Long id;

	@ApiModelProperty(value = "Id da Unidade Subordinada", required = true, notes = "")
	@Column(name = "ORG_NU_AGENCIA_SUBORD")
	private Long idSubordinada;

	public OrgaoCorreiosSubordinada(Long id, Long idSubordinada) {
		super();
		this.id = id;
		this.idSubordinada = idSubordinada;
	}

	public OrgaoCorreiosSubordinada() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdSubordinada() {
		return idSubordinada;
	}

	public void setIdSubordinada(Long idSubordinada) {
		this.idSubordinada = idSubordinada;
	}

}
