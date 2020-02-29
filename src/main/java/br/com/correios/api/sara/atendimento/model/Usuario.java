package br.com.correios.api.sara.atendimento.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.eclipse.persistence.internal.sessions.DirectCollectionChangeRecord.NULL;

import br.com.correios.api.sara.atendimento.util.BooleanSimNaoConverter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Documentação da classe.")

@Entity
@Table(name = "NEP_USUARIO")
public class Usuario implements Serializable {

	@ApiModelProperty(value = "Id do Usuario", required = true, notes = "")
	@Id
	@Column(name = "USU_NU_USUARIO")
	private Long id;

	@ApiModelProperty(value = "Id do Orgao Correios ", required = true, notes = "")
	@Column(name = "ORG_NU_AGENCIA")
	private Long idOrgaoCorreios;

	@ApiModelProperty(value = "Tipo Perfil", required = true, notes = "")
	@Column(name = "TPF_NU_TIPO_PERFIL")
	private Long tipoPerfil;
	
	@ApiModelProperty(value = "Numero Funcionario Correios", required = true, notes = "")
	@Column(name = "FCR_NU_FUNCIONARIO")
	private Long numeroFuncionarioCorreios;
	
	@ApiModelProperty(value = "Numero Funcionario Externo", required = true, notes = "")
	@Column(name = "FTE_NU_FUNCIONARIO")
	private Long numeroFuncionarioExterno;
	
	@ApiModelProperty(value = "Indicador de Alteração de Senha Proximo Login", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "USU_IN_SENHA")
	private Boolean isAlterarSenha;
	
	@ApiModelProperty(value = "Indicador de Usuario Ativo", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "USU_IN_ATIVO")
	private Boolean isAtivo;
	
	@ApiModelProperty(value = "Data da Ultima Alteração de Senha", required = true, notes = "")
	@Column(name = "USU_DT_ULT_SENHA")
	private Date dataAlteracaoSenha;
	
	@ApiModelProperty(value = "Data de Cadastro do Usuario", required = true, notes = "")
	@Column(name = "USU_DT_CADASTRO")
	private Date dataCadastro;
	
	@ApiModelProperty(value = "Numero de Tentativas de Login", required = true, notes = "")
	@Column(name = "USU_NU_TENT_LOGIN")
	private Integer quantidadeTentativaLogin;
	
	@ApiModelProperty(value = "Data da Ultima Alteração do Usuario", required = true, notes = "")
	@Column(name = "USU_DH_ALTERACAO")
	private Date dataAlteracaoUsuario;
	
	@ApiModelProperty(value = "Senha Criptografada", required = true, notes = "")
	@Column(name = "USU_TX_SENHA_CRIPTO")
	private String senhaCriptografada;
	
	@ApiModelProperty(value = "Data da Ultima Alteração de Senha 2", required = true, notes = "")
	@Column(name = "USU_DT_ALTERACAO_SENHA")
	private Date dataAlteracaoSenha2;
	
	@ApiModelProperty(value = "Indicador de Usuario Virtual", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "USU_IN_VIRTUAL")
	private Boolean isUsuarioVirtual;

	public Usuario() {}

	public Usuario(Long id, Long idOrgaoCorreios, Long tipoPerfil, Long numeroFuncionarioCorreios,
			Long numeroFuncionarioExterno, Boolean isAlterarSenha, Boolean isAtivo, Date dataAlteracaoSenha,
			Date dataCadastro, Integer quantidadeTentativaLogin, Date dataAlteracaoUsuario, String senhaCriptografada,
			Date dataAlteracaoSenha2, Boolean isUsuarioVirtual) {
		super();
		this.id = id;
		this.idOrgaoCorreios = idOrgaoCorreios;
		this.tipoPerfil = tipoPerfil;
		this.numeroFuncionarioCorreios = numeroFuncionarioCorreios;
		this.numeroFuncionarioExterno = numeroFuncionarioExterno;
		this.isAlterarSenha = isAlterarSenha;
		this.isAtivo = isAtivo;
		this.dataAlteracaoSenha = dataAlteracaoSenha;
		this.dataCadastro = dataCadastro;
		this.quantidadeTentativaLogin = quantidadeTentativaLogin;
		this.dataAlteracaoUsuario = dataAlteracaoUsuario;
		this.senhaCriptografada = senhaCriptografada;
		this.dataAlteracaoSenha2 = dataAlteracaoSenha2;
		this.isUsuarioVirtual = isUsuarioVirtual;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdOrgaoCorreios() {
		return idOrgaoCorreios;
	}

	public void setIdOrgaoCorreios(Long idOrgaoCorreios) {
		this.idOrgaoCorreios = id;
	}

	public Long getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(Long tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	public Long getNumeroFuncionarioCorreios() {
		return numeroFuncionarioCorreios;
	}

	public void setNumeroFuncionarioCorreios(Long numeroFuncionarioCorreios) {
		this.numeroFuncionarioCorreios = numeroFuncionarioCorreios;
	}

	public Long getNumeroFuncionarioExterno() {
		return numeroFuncionarioExterno;
	}

	public void setNumeroFuncionarioExterno(Long numeroFuncionarioExterno) {
		this.numeroFuncionarioExterno = numeroFuncionarioExterno;
	}

	public Boolean getIsAlterarSenha() {
		return isAlterarSenha;
	}

	public void setIsAlterarSenha(Boolean isAlterarSenha) {
		this.isAlterarSenha = isAlterarSenha;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public Date getDataAlteracaoSenha() {
		return dataAlteracaoSenha;
	}

	public void setDataAlteracaoSenha(Date dataAlteracaoSenha) {
		this.dataAlteracaoSenha = dataAlteracaoSenha;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Integer getQuantidadeTentativaLogin() {
		return quantidadeTentativaLogin;
	}

	public void setQuantidadeTentativaLogin(Integer quantidadeTentativaLogin) {
		this.quantidadeTentativaLogin = quantidadeTentativaLogin;
	}

	public Date getDataAlteracaoUsuario() {
		return dataAlteracaoUsuario;
	}

	public void setDataAlteracaoUsuario(Date dataAlteracaoUsuario) {
		this.dataAlteracaoUsuario = dataAlteracaoUsuario;
	}

	public String getSenhaCriptografada() {
		return senhaCriptografada;
	}

	public void setSenhaCriptografada(String senhaCriptografada) {
		this.senhaCriptografada = senhaCriptografada;
	}

	public Date getDataAlteracaoSenha2() {
		return dataAlteracaoSenha2;
	}

	public void setDataAlteracaoSenha2(Date dataAlteracaoSenha2) {
		this.dataAlteracaoSenha2 = dataAlteracaoSenha2;
	}

	public Boolean getIsUsuarioVirtual() {
		return isUsuarioVirtual;
	}

	public void setIsUsuarioVirtual(Boolean isUsuarioVirtual) {
		this.isUsuarioVirtual = isUsuarioVirtual;
	}
	
}
