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
@Table(name = "NEP_ITEM_ATENDIMENTO")
public class ItemAtendimento implements Serializable {

	@ApiModelProperty(value = "Id do Item Atendimento", required = true, notes = "")
	@Id
	@Column(name = "IAT_NU_ITEM_ATENDIMENTO")
	private Long id;

	@ApiModelProperty(value = "Id do Atendimento ao qual o Item pertence", required = true, notes = "")
	@Column(name = "ACX_NU_ATENDIMENTO")
	private Long idAtendimento;
	
	@ApiModelProperty(value = "Id do Produto Servico", required = true, notes = "")
	@Column(name = "PRS_NU_PRODUTO_SERVICO")
	private Long idProdutoServico;
	
	@ApiModelProperty(value = "Motivo Isencao", required = true, notes = "")
	@Column(name = "MIS_NU_MOTIVO_ISENCAO")
	private Long motivoIsencao;
	
	@ApiModelProperty(value = "Id de Estorno do Item", required = true, notes = "")
	@Column(name = "IAT_NU_ESTORNO_ITEM")
	private Long isEstornoItem;
	
	@ApiModelProperty(value = "Numero Contrato", required = true, notes = "")
	@Column(name = "CTC_NU_CONTRATO")
	private Long numeroContrato;
	
	@ApiModelProperty(value = "Numero Recarga Maquina", required = true, notes = "")
	@Column(name = "RMQ_NU_RECARGA_MAQUINA")
	private Long numeroRecargaMaquina;
	
	@ApiModelProperty(value = "Sequencial do Item dentro do Atendimento", required = true, notes = "")
	@Column(name = "IAT_NU_SEQUENCIAL_ITEM")
	private Long sequncialItem;
	
	@ApiModelProperty(value = "Data e Hora do Inicio do Atendimento", required = true, notes = "")
	@Column(name = "IAT_HR_INICIAL")
	private Date dataHoraInicioAtendimento;
	
	@ApiModelProperty(value = "Data e Hora do Final do Atendimento", required = true, notes = "")
	@Column(name = "IAT_HR_FINAL")
	private Date dataHoraFinalAtendimento;
	
	@ApiModelProperty(value = "Quantidade de Itens (Fator Multiplicativo)", required = true, notes = "")
	@Column(name = "IAT_QT_ATENDIMENTO")
	private Long quantidadeAtendimento;
	
	@ApiModelProperty(value = "Preço Unitário", required = true, notes = "")
	@Column(name = "IAT_PR_UNITARIO")
	private BigDecimal precoUnitario;
	
	@ApiModelProperty(value = "Valor do Atendimento", required = true, notes = "")
	@Column(name = "IAT_VR_ATENDIMENTO")
	private BigDecimal valorAtendimento;
	
	@ApiModelProperty(value = "Valor Pre-Franqueado", required = true, notes = "")
	@Column(name = "IAT_VR_PREFRANQUEADO")
	private BigDecimal valorPreFranqueado;
	
	@ApiModelProperty(value = "Valor de Desconto", required = true, notes = "")
	@Column(name = "IAT_VR_DESCONTO")
	private BigDecimal valorDesconto;
	
	@ApiModelProperty(value = "Valor Isenção", required = true, notes = "")
	@Column(name = "IAT_VR_ISENCAO")
	private BigDecimal valorIsencao;
	
	@ApiModelProperty(value = "Peso do Objeto", required = true, notes = "")
	@Column(name = "IAT_PS_OBJETO")
	private BigDecimal pesoObjeto;
	
	@ApiModelProperty(value = "Codigo de Barra", required = true, notes = "")
	@Column(name = "IAT_NU_CODIGO_BARRA")
	private String codigoBarra;
	
	@ApiModelProperty(value = "Numero Documento", required = true, notes = "")
	@Column(name = "IAT_NU_DOCUMENTO")
	private String numeroDocumento;
	
	@ApiModelProperty(value = "Etiqueta", required = true, notes = "")
	@Column(name = "IAT_NU_ETIQUETA")
	private String etiqueta;
	
	@ApiModelProperty(value = "Indicador de Estorno", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "IAT_IN_ESTORNO")
	private Boolean isEstorno;
	
	@ApiModelProperty(value = "Valor da Receita", required = true, notes = "")
	@Column(name = "IAT_VR_RECEITA")
	private BigDecimal valorReceita;
	
	@ApiModelProperty(value = "Indicador de Lista Postagem", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "IAT_IN_LISTA_POSTAGEM")
	private Boolean isListaPostagem;
	
	@ApiModelProperty(value = "Numero Faixa", required = true, notes = "")
	@Column(name = "IAT_NU_FAIXA")
	private BigDecimal numeroFaixa;
	
	@ApiModelProperty(value = "Indicador de Item criado Offline", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "IAT_IN_OFFLINE")
	private Boolean isOffline;
	
	@ApiModelProperty(value = "Id do Item Casado", required = true, notes = "")
	@Column(name = "IAT_NU_CASADO_ITEM")
	private Long idItemCasado;
	
	@ApiModelProperty(value = "Indicador de Item criado Offline", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "IAT_IN_EXPEDICAO")
	private Boolean isExpedicao;
	
	@ApiModelProperty(value = "Numero da Nota Fiscal", required = true, notes = "")
	@Column(name = "IAT_NU_NOTA_FISCAL")
	private Long numeroNotaFiscal;
	
	@ApiModelProperty(value = "Preço Definido", required = true, notes = "")
	@Column(name = "IAT_PE_PRECO_DEFINIDO")
	private BigDecimal precoDefinido;
	
	@ApiModelProperty(value = "Valor Original do Item", required = true, notes = "")
	@Column(name = "IAT_VR_ORIGINAL_ITEM")
	private BigDecimal valorOriginalItem;
	
	@ApiModelProperty(value = "Codigo do Menu de Origem", required = true, notes = "")
	@Column(name = "TOP_CO")
	private Long codigoMenuOrigemTopCo;
	
	@ApiModelProperty(value = "Protocolo CPC", required = true, notes = "")
	@Column(name = "IAT_NU_PROTOCOLO_CPC")
	private String protocoloCPC;
	
	@ApiModelProperty(value = "Controle CPC", required = true, notes = "")
	@Column(name = "IAT_NU_TSCONTROLE_CPC")
	private String controleCPC;
	
	@ApiModelProperty(value = "Numero CIC", required = true, notes = "")
	@Column(name = "CIC_NU")
	private Long numeroCIC;
	
	@ApiModelProperty(value = "Id da Agencia", required = true, notes = "")
	@Column(name = "ORG_NU_AGENCIA")
	private Long idAgencia;
	
	@ApiModelProperty(value = "Data de Postagem", required = true, notes = "")
	@Column(name = "IAT_DT_POSTAGEM")
	private Date dataPostagem;

	@ApiModelProperty(value = "Indicador de Franq Grande Postagem", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "IAT_IN_FRANQ_GRANDE_POSTAGEM")
	private Boolean isFranqGrandePostagem;
	
	@ApiModelProperty(value = "Numero do Lançamento", required = true, notes = "")
	@Column(name = "LAN_NU_LANCAMENTO")
	private Long numeroLancamento;
	
	@ApiModelProperty(value = "Indicador de Utilização de Captação", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "IAT_IN_UTILIZA_CAPTACAO")
	private Boolean isUtilizaCaptacao;
	
	@ApiModelProperty(value = "Valor Total Retenção", required = true, notes = "")
	@Column(name = "IAT_VR_TOTAL_RETENCAO")
	private BigDecimal valorTotalRetencao;
	
	@ApiModelProperty(value = "Tipo de Modelo", required = true, notes = "")
	@Column(name = "DFC_NU_TIPO_MODELO")
	private Integer tipoModelo;
	
	@ApiModelProperty(value = "Indicador de Acerto Financeiro", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "IAT_IN_ACERTO_FINANCEIRO")
	private Boolean isAcertoFinanceiro;
	
	@ApiModelProperty(value = "Sequencial Documento Fiscal", required = true, notes = "")
	@Column(name = "IAT_NU_SEQ_DOCUMENTO_FISCAL")
	private Long sequencialDocumentoFiscal;
	
	@ApiModelProperty(value = "Data de Insercao do Item", required = true, notes = "")
	@Column(name = "IAT_DH_INSERCAO")
	private Date dataInsercao;
	
	@ApiModelProperty(value = "Valor Total Taxa", required = true, notes = "")
	@Column(name = "IAT_VR_TOTAL_TAXA")
	private BigDecimal valorTotalTaxa;
	
//	@ApiModelProperty(value = "Indicador de Conversao de Item Industrial em Comum", required = true, notes = "")
//	@Convert(converter = BooleanSimNaoConverter.class)
//	@Column(name = "IAT_IN_CONVERSAO_INDUSTRIAL")
//	private Boolean isAcertoFinanceiro;
//	IAT_IN_CONVERSAO_INDUSTRIAL           VARCHAR2(1)  
	
	@ApiModelProperty(value = "Codigo FRID", required = true, notes = "")
	@Column(name = "IAT_CO_RFID")
	private String codigoRFID;

	public ItemAtendimento() {}

	public ItemAtendimento(Long id, Long idAtendimento, Long idProdutoServico, Long motivoIsencao, Long isEstornoItem,
			Long numeroContrato, Long numeroRecargaMaquina, Long sequncialItem, Date dataHoraInicioAtendimento,
			Date dataHoraFinalAtendimento, Long quantidadeAtendimento, BigDecimal precoUnitario,
			BigDecimal valorAtendimento, BigDecimal valorPreFranqueado, BigDecimal valorDesconto,
			BigDecimal valorIsencao, BigDecimal pesoObjeto, String codigoBarra, String numeroDocumento, String etiqueta,
			Boolean isEstorno, BigDecimal valorReceita, Boolean isListaPostagem, BigDecimal numeroFaixa,
			Boolean isOffline, Long idItemCasado, Boolean isExpedicao, Long numeroNotaFiscal, BigDecimal precoDefinido,
			BigDecimal valorOriginalItem, Long codigoMenuOrigemTopCo, String protocoloCPC, String controleCPC,
			Long numeroCIC, Long idAgencia, Date dataPostagem, Boolean isFranqGrandePostagem, Long numeroLancamento,
			Boolean isUtilizaCaptacao, BigDecimal valorTotalRetencao, Integer tipoModelo, Boolean isAcertoFinanceiro,
			Long sequencialDocumentoFiscal, Date dataInsercao, BigDecimal valorTotalTaxa, String codigoRFID) {
		super();
		this.id = id;
		this.idAtendimento = idAtendimento;
		this.idProdutoServico = idProdutoServico;
		this.motivoIsencao = motivoIsencao;
		this.isEstornoItem = isEstornoItem;
		this.numeroContrato = numeroContrato;
		this.numeroRecargaMaquina = numeroRecargaMaquina;
		this.sequncialItem = sequncialItem;
		this.dataHoraInicioAtendimento = dataHoraInicioAtendimento;
		this.dataHoraFinalAtendimento = dataHoraFinalAtendimento;
		this.quantidadeAtendimento = quantidadeAtendimento;
		this.precoUnitario = precoUnitario;
		this.valorAtendimento = valorAtendimento;
		this.valorPreFranqueado = valorPreFranqueado;
		this.valorDesconto = valorDesconto;
		this.valorIsencao = valorIsencao;
		this.pesoObjeto = pesoObjeto;
		this.codigoBarra = codigoBarra;
		this.numeroDocumento = numeroDocumento;
		this.etiqueta = etiqueta;
		this.isEstorno = isEstorno;
		this.valorReceita = valorReceita;
		this.isListaPostagem = isListaPostagem;
		this.numeroFaixa = numeroFaixa;
		this.isOffline = isOffline;
		this.idItemCasado = idItemCasado;
		this.isExpedicao = isExpedicao;
		this.numeroNotaFiscal = numeroNotaFiscal;
		this.precoDefinido = precoDefinido;
		this.valorOriginalItem = valorOriginalItem;
		this.codigoMenuOrigemTopCo = codigoMenuOrigemTopCo;
		this.protocoloCPC = protocoloCPC;
		this.controleCPC = controleCPC;
		this.numeroCIC = numeroCIC;
		this.idAgencia = idAgencia;
		this.dataPostagem = dataPostagem;
		this.isFranqGrandePostagem = isFranqGrandePostagem;
		this.numeroLancamento = numeroLancamento;
		this.isUtilizaCaptacao = isUtilizaCaptacao;
		this.valorTotalRetencao = valorTotalRetencao;
		this.tipoModelo = tipoModelo;
		this.isAcertoFinanceiro = isAcertoFinanceiro;
		this.sequencialDocumentoFiscal = sequencialDocumentoFiscal;
		this.dataInsercao = dataInsercao;
		this.valorTotalTaxa = valorTotalTaxa;
		this.codigoRFID = codigoRFID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdAtendimento() {
		return idAtendimento;
	}

	public void setIdAtendimento(Long idAtendimento) {
		this.idAtendimento = idAtendimento;
	}

	public Long getIdProdutoServico() {
		return idProdutoServico;
	}

	public void setIdProdutoServico(Long idProdutoServico) {
		this.idProdutoServico = idProdutoServico;
	}

	public Long getMotivoIsencao() {
		return motivoIsencao;
	}

	public void setMotivoIsencao(Long motivoIsencao) {
		this.motivoIsencao = motivoIsencao;
	}

	public Long getIsEstornoItem() {
		return isEstornoItem;
	}

	public void setIsEstornoItem(Long isEstornoItem) {
		this.isEstornoItem = isEstornoItem;
	}

	public Long getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(Long numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public Long getNumeroRecargaMaquina() {
		return numeroRecargaMaquina;
	}

	public void setNumeroRecargaMaquina(Long numeroRecargaMaquina) {
		this.numeroRecargaMaquina = numeroRecargaMaquina;
	}

	public Long getSequncialItem() {
		return sequncialItem;
	}

	public void setSequncialItem(Long sequncialItem) {
		this.sequncialItem = sequncialItem;
	}

	public Date getDataHoraInicioAtendimento() {
		return dataHoraInicioAtendimento;
	}

	public void setDataHoraInicioAtendimento(Date dataHoraInicioAtendimento) {
		this.dataHoraInicioAtendimento = dataHoraInicioAtendimento;
	}

	public Date getDataHoraFinalAtendimento() {
		return dataHoraFinalAtendimento;
	}

	public void setDataHoraFinalAtendimento(Date dataHoraFinalAtendimento) {
		this.dataHoraFinalAtendimento = dataHoraFinalAtendimento;
	}

	public Long getQuantidadeAtendimento() {
		return quantidadeAtendimento;
	}

	public void setQuantidadeAtendimento(Long quantidadeAtendimento) {
		this.quantidadeAtendimento = quantidadeAtendimento;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public BigDecimal getValorAtendimento() {
		return valorAtendimento;
	}

	public void setValorAtendimento(BigDecimal valorAtendimento) {
		this.valorAtendimento = valorAtendimento;
	}

	public BigDecimal getValorPreFranqueado() {
		return valorPreFranqueado;
	}

	public void setValorPreFranqueado(BigDecimal valorPreFranqueado) {
		this.valorPreFranqueado = valorPreFranqueado;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorIsencao() {
		return valorIsencao;
	}

	public void setValorIsencao(BigDecimal valorIsencao) {
		this.valorIsencao = valorIsencao;
	}

	public BigDecimal getPesoObjeto() {
		return pesoObjeto;
	}

	public void setPesoObjeto(BigDecimal pesoObjeto) {
		this.pesoObjeto = pesoObjeto;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public Boolean getIsEstorno() {
		return isEstorno;
	}

	public void setIsEstorno(Boolean isEstorno) {
		this.isEstorno = isEstorno;
	}

	public BigDecimal getValorReceita() {
		return valorReceita;
	}

	public void setValorReceita(BigDecimal valorReceita) {
		this.valorReceita = valorReceita;
	}

	public Boolean getIsListaPostagem() {
		return isListaPostagem;
	}

	public void setIsListaPostagem(Boolean isListaPostagem) {
		this.isListaPostagem = isListaPostagem;
	}

	public BigDecimal getNumeroFaixa() {
		return numeroFaixa;
	}

	public void setNumeroFaixa(BigDecimal numeroFaixa) {
		this.numeroFaixa = numeroFaixa;
	}

	public Boolean getIsOffline() {
		return isOffline;
	}

	public void setIsOffline(Boolean isOffline) {
		this.isOffline = isOffline;
	}

	public Long getIdItemCasado() {
		return idItemCasado;
	}

	public void setIdItemCasado(Long idItemCasado) {
		this.idItemCasado = idItemCasado;
	}

	public Boolean getIsExpedicao() {
		return isExpedicao;
	}

	public void setIsExpedicao(Boolean isExpedicao) {
		this.isExpedicao = isExpedicao;
	}

	public Long getNumeroNotaFiscal() {
		return numeroNotaFiscal;
	}

	public void setNumeroNotaFiscal(Long numeroNotaFiscal) {
		this.numeroNotaFiscal = numeroNotaFiscal;
	}

	public BigDecimal getPrecoDefinido() {
		return precoDefinido;
	}

	public void setPrecoDefinido(BigDecimal precoDefinido) {
		this.precoDefinido = precoDefinido;
	}

	public BigDecimal getValorOriginalItem() {
		return valorOriginalItem;
	}

	public void setValorOriginalItem(BigDecimal valorOriginalItem) {
		this.valorOriginalItem = valorOriginalItem;
	}

	public Long getCodigoMenuOrigemTopCo() {
		return codigoMenuOrigemTopCo;
	}

	public void setCodigoMenuOrigemTopCo(Long codigoMenuOrigemTopCo) {
		this.codigoMenuOrigemTopCo = codigoMenuOrigemTopCo;
	}

	public String getProtocoloCPC() {
		return protocoloCPC;
	}

	public void setProtocoloCPC(String protocoloCPC) {
		this.protocoloCPC = protocoloCPC;
	}

	public String getControleCPC() {
		return controleCPC;
	}

	public void setControleCPC(String controleCPC) {
		this.controleCPC = controleCPC;
	}

	public Long getNumeroCIC() {
		return numeroCIC;
	}

	public void setNumeroCIC(Long numeroCIC) {
		this.numeroCIC = numeroCIC;
	}

	public Long getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(Long idAgencia) {
		this.idAgencia = idAgencia;
	}

	public Date getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(Date dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	public Boolean getIsFranqGrandePostagem() {
		return isFranqGrandePostagem;
	}

	public void setIsFranqGrandePostagem(Boolean isFranqGrandePostagem) {
		this.isFranqGrandePostagem = isFranqGrandePostagem;
	}

	public Long getNumeroLancamento() {
		return numeroLancamento;
	}

	public void setNumeroLancamento(Long numeroLancamento) {
		this.numeroLancamento = numeroLancamento;
	}

	public Boolean getIsUtilizaCaptacao() {
		return isUtilizaCaptacao;
	}

	public void setIsUtilizaCaptacao(Boolean isUtilizaCaptacao) {
		this.isUtilizaCaptacao = isUtilizaCaptacao;
	}

	public BigDecimal getValorTotalRetencao() {
		return valorTotalRetencao;
	}

	public void setValorTotalRetencao(BigDecimal valorTotalRetencao) {
		this.valorTotalRetencao = valorTotalRetencao;
	}

	public Integer getTipoModelo() {
		return tipoModelo;
	}

	public void setTipoModelo(Integer tipoModelo) {
		this.tipoModelo = tipoModelo;
	}

	public Boolean getIsAcertoFinanceiro() {
		return isAcertoFinanceiro;
	}

	public void setIsAcertoFinanceiro(Boolean isAcertoFinanceiro) {
		this.isAcertoFinanceiro = isAcertoFinanceiro;
	}

	public Long getSequencialDocumentoFiscal() {
		return sequencialDocumentoFiscal;
	}

	public void setSequencialDocumentoFiscal(Long sequencialDocumentoFiscal) {
		this.sequencialDocumentoFiscal = sequencialDocumentoFiscal;
	}

	public Date getDataInsercao() {
		return dataInsercao;
	}

	public void setDataInsercao(Date dataInsercao) {
		this.dataInsercao = dataInsercao;
	}

	public BigDecimal getValorTotalTaxa() {
		return valorTotalTaxa;
	}

	public void setValorTotalTaxa(BigDecimal valorTotalTaxa) {
		this.valorTotalTaxa = valorTotalTaxa;
	}

	public String getCodigoRFID() {
		return codigoRFID;
	}

	public void setCodigoRFID(String codigoRFID) {
		this.codigoRFID = codigoRFID;
	}
	
}
