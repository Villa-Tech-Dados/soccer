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
@Table(name = "NEP_CAIXA")
public class Caixa implements Serializable {

	@ApiModelProperty(value = "Id do Caixa", required = true, notes = "")
	@Id
	@Column(name = "CAX_NU_CAIXA")
	private Long id;

	@ApiModelProperty(value = "Id do Retaguarda associado ao Caixa", required = true, notes = "")
	@Column(name = "CXR_NU_CAIXA_RETAGUARDA")
	private Long numeroCaixaRetaguarda;
	
	@ApiModelProperty(value = "Numero do Usuario associado ao Caixa", required = true, notes = "")
	@Column(name = "USU_NU_USUARIO")
	private Long numeroUsuario;
	
	@ApiModelProperty(value = "Numero Caixa Estoque", required = true, notes = "")
	@Column(name = "CAX_NU_CAIXA_ESTOQUE")
	private Long numeroCaixaEstoque;
	
	@ApiModelProperty(value = "Numero do Usuario de Reabertura", required = true, notes = "")
	@Column(name = "USU_NU_USUARIO_REABERTURA")
	private Long numeroUsuarioReabertura;
	
	@ApiModelProperty(value = "Data de Abertura do Caixa", required = true, notes = "")
	@Column(name = "CAX_DH_ABERTURA_CAIXA")
	private Date dataAberturaCaixa;
	
	@ApiModelProperty(value = "Data de Fechamento do Caixa", required = true, notes = "")
	@Column(name = "CAX_DH_FECHAMENTO_CAIXA")
	private Date dataFechamentoCaixa;
	
	@ApiModelProperty(value = "Indicador de Caixa Aberto", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "CAX_IN_ABERTO")
	private Boolean isCaixaAberto;
	
	@ApiModelProperty(value = "Data de Geracao Relatorio", required = true, notes = "")
	@Column(name = "CAX_DH_GERACAO_RELATORIO")
	private Date dataGeracaoRelatorio;
	
	@ApiModelProperty(value = "Indicador de Controle", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "CAX_IN_CONTROLE")
	private Boolean isControle;
	
	@ApiModelProperty(value = "Indicador de Guiche Empresarial", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "CAX_IN_GUICHE_EMPRESARIAL")
	private Boolean isGuicheEmpresarial;
	
	@ApiModelProperty(value = "Numero Sequencial de Abertura", required = true, notes = "")
	@Column(name = "CAX_NU_SEQUENCIAL_ABERTURA")
	private Long numeroSequencialAbertura;
	
	@ApiModelProperty(value = "Numero Sequencial de Atendimento", required = true, notes = "")
	@Column(name = "CAX_NU_SEQUENCIAL_ATENDIMENTO")
	private Long numeroSequencialAtendimento;

	public Caixa() {}

	public Caixa(Long id, Long numeroCaixaRetaguarda, Long numeroUsuario, Long numeroCaixaEstoque,
			Long numeroUsuarioReabertura, Date dataAberturaCaixa, Date dataFechamentoCaixa, Boolean isCaixaAberto,
			Date dataGeracaoRelatorio, Boolean isControle, Boolean isGuicheEmpresarial, Long numeroSequencialAbertura,
			Long numeroSequencialAtendimento) {
		super();
		this.id = id;
		this.numeroCaixaRetaguarda = numeroCaixaRetaguarda;
		this.numeroUsuario = numeroUsuario;
		this.numeroCaixaEstoque = numeroCaixaEstoque;
		this.numeroUsuarioReabertura = numeroUsuarioReabertura;
		this.dataAberturaCaixa = dataAberturaCaixa;
		this.dataFechamentoCaixa = dataFechamentoCaixa;
		this.isCaixaAberto = isCaixaAberto;
		this.dataGeracaoRelatorio = dataGeracaoRelatorio;
		this.isControle = isControle;
		this.isGuicheEmpresarial = isGuicheEmpresarial;
		this.numeroSequencialAbertura = numeroSequencialAbertura;
		this.numeroSequencialAtendimento = numeroSequencialAtendimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroCaixaRetaguarda() {
		return numeroCaixaRetaguarda;
	}

	public void setNumeroCaixaRetaguarda(Long numeroCaixaRetaguarda) {
		this.numeroCaixaRetaguarda = numeroCaixaRetaguarda;
	}

	public Long getNumeroUsuario() {
		return numeroUsuario;
	}

	public void setNumeroUsuario(Long numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}

	public Long getNumeroCaixaEstoque() {
		return numeroCaixaEstoque;
	}

	public void setNumeroCaixaEstoque(Long numeroCaixaEstoque) {
		this.numeroCaixaEstoque = numeroCaixaEstoque;
	}

	public Long getNumeroUsuarioReabertura() {
		return numeroUsuarioReabertura;
	}

	public void setNumeroUsuarioReabertura(Long numeroUsuarioReabertura) {
		this.numeroUsuarioReabertura = numeroUsuarioReabertura;
	}

	public Date getDataAberturaCaixa() {
		return dataAberturaCaixa;
	}

	public void setDataAberturaCaixa(Date dataAberturaCaixa) {
		this.dataAberturaCaixa = dataAberturaCaixa;
	}

	public Date getDataFechamentoCaixa() {
		return dataFechamentoCaixa;
	}

	public void setDataFechamentoCaixa(Date dataFechamentoCaixa) {
		this.dataFechamentoCaixa = dataFechamentoCaixa;
	}

	public Boolean getIsCaixaAberto() {
		return isCaixaAberto;
	}

	public void setIsCaixaAberto(Boolean isCaixaAberto) {
		this.isCaixaAberto = isCaixaAberto;
	}

	public Date getDataGeracaoRelatorio() {
		return dataGeracaoRelatorio;
	}

	public void setDataGeracaoRelatorio(Date dataGeracaoRelatorio) {
		this.dataGeracaoRelatorio = dataGeracaoRelatorio;
	}

	public Boolean getIsControle() {
		return isControle;
	}

	public void setIsControle(Boolean isControle) {
		this.isControle = isControle;
	}

	public Boolean getIsGuicheEmpresarial() {
		return isGuicheEmpresarial;
	}

	public void setIsGuicheEmpresarial(Boolean isGuicheEmpresarial) {
		this.isGuicheEmpresarial = isGuicheEmpresarial;
	}

	public Long getNumeroSequencialAbertura() {
		return numeroSequencialAbertura;
	}

	public void setNumeroSequencialAbertura(Long numeroSequencialAbertura) {
		this.numeroSequencialAbertura = numeroSequencialAbertura;
	}

	public Long getNumeroSequencialAtendimento() {
		return numeroSequencialAtendimento;
	}

	public void setNumeroSequencialAtendimento(Long numeroSequencialAtendimento) {
		this.numeroSequencialAtendimento = numeroSequencialAtendimento;
	}
	
}
