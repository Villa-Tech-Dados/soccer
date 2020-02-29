package br.com.correios.api.sara.atendimento.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.correios.api.sara.atendimento.util.BooleanSimNaoConverter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Documentação da classe.")

@Entity
@Table(name = "NEP_ATENDIMENTO_CAIXA")
public class Atendimento implements Serializable {

	@ApiModelProperty(value = "Id da Execucao", required = true, notes = "")
	@Id
	@Column(name = "ACX_NU_ATENDIMENTO")
	private Long id;

	@ApiModelProperty(value = "Numero do Caixa", required = true, notes = "")
	@Column(name = "CAX_NU_CAIXA")
	private Long numeroDoCaixa;

	@ApiModelProperty(value = "Numero do Cliente", required = true, notes = "")
	@Column(name = "CLI_NU_CLIENTE")
	private Long numeroDoCliente;
	
	@ApiModelProperty(value = "Numero do Contrato", required = true, notes = "")
	@Column(name = "CTC_NU_CONTRATO")
	private Long numeroDoContrato;
	
	@ApiModelProperty(value = "MCU da Unidade", required = true, notes = "")
	@Column(name = "ORG_NU_AGENCIA")
	private Long mcu;
	
	@ApiModelProperty(value = "Numero do Funcionario", required = true, notes = "")
	@Column(name = "FCR_NU_FUNCIONARIO")
	private Long numeroFuncionario;
	
	@ApiModelProperty(value = "Id do Atendimento de Estorno", required = true, notes = "")
	@Column(name = "ACX_ESTORNO_ATENDIMENTO")
	private Long idAtendimentoDeEstorno;
	
	@ApiModelProperty(value = "Numero da Modalidade de Pagamento", required = true, notes = "")
	@Column(name = "MPT_NU_MODALIDADE_PGTO")
	private Long numeroModalidadePagamento;
	
	@ApiModelProperty(value = "Numero do Cartão de Postagem", required = true, notes = "")
	@Column(name = "CPT_NU_CARTAO_POSTAGEM")
	private Long numeroCartaoPostagem;
	
	@ApiModelProperty(value = "Sequencial de Atendimentos do Caixa", required = true, notes = "")
	@Column(name = "ACX_NU_ATENDIMENTO_CAIXA")
	private Long sequencialAtendimentoCaixa;
	
	@ApiModelProperty(value = "Início do Atendimento", required = true, notes = "")
	@Column(name = "ACX_DH_INICIAL")
	private LocalDateTime dataInicioAtendimento;

	@ApiModelProperty(value = "Final do Atendimento", required = true, notes = "")
	@Column(name = "ACX_DH_FINAL")
	private LocalDateTime dataFinalAtendimento;
	
	@ApiModelProperty(value = "Total de Desconto", required = true, notes = "")
	@Column(name = "ACX_VR_TOTAL_DESCONTO")
	private BigDecimal valorTotalDesconto;
	
	@ApiModelProperty(value = "Total do Atendimento", required = true, notes = "")
	@Column(name = "ACX_VR_TOTAL_ATENDIMENTO")
	private BigDecimal valorTotalAtendimento;

	@ApiModelProperty(value = "Indicador de Atendimento Estornado", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ACX_IN_ESTORNO")
	private Boolean isEstornado;
	
	@ApiModelProperty(value = "Total de Isenção", required = true, notes = "")
	@Column(name = "ACX_VR_TOTAL_ISENCAO")
	private BigDecimal valorTotalIsencao;

	@ApiModelProperty(value = "Total de Franqueamento", required = true, notes = "")
	@Column(name = "ACX_VR_TOTAL_PREFRANQUEAMENTO")
	private BigDecimal valorTotalFranqueamento;
	
	@ApiModelProperty(value = "Sequencial de Atendimentos do Caixa", required = true, notes = "")
	@Column(name = "ACX_NU_DOCUMENTO_POSTAGEM")
	private Long numeroDocumentoPostagem;
	
	@ApiModelProperty(value = "Indicador de Atendimento Realizado no modo OffLine", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ACX_IN_OFFLINE")
	private Boolean isAtendidoOffline;
	
	@ApiModelProperty(value = "Sequencial de Atendimentos do Funcionario", required = true, notes = "")
	@Column(name = "ACX_NU_ATENDIMENTO_FUNC")
	private Long numeroAtendimentoFuncionario;
	
	@ApiModelProperty(value = "Indicador de Numero de Fatura de Cliente", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ACX_IN_NUM_FAT_CLIENTE")
	private Boolean isNumeroFaturaCliente;
	
	@ApiModelProperty(value = "Numero da Nota Fiscal", required = true, notes = "")
	@Column(name = "ACX_NU_NOTA_FISCAL")
	private Long numeroNotaFiscal;
	
	@ApiModelProperty(value = "Numero do STO ACF", required = true, notes = "")
	@Column(name = "ACX_NU_STO_ACF")
	private Long numeroStoAcf;
	
	@ApiModelProperty(value = "Indicador de Categoria de Precço Definido", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ACX_IN_CATEG_PRECO_DEFINIDO")
	private Boolean isCategoriaPrecoDefinido;
	
	@ApiModelProperty(value = "Indicador de Importacao", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ACX_IN_IMPORTACAO")
	private Boolean isImportacao;
	
	@ApiModelProperty(value = "Indicador de Origem de Atendimento", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ACX_IN_ORIGEM_ATENDIMENTO")
	private Boolean isOrigemAtendimento;
	
	@ApiModelProperty(value = "Data de Importacao do ERP", required = true, notes = "")
	@Column(name = "ACX_DH_IMPORTACAO_ERP")
	private LocalDateTime dataImportacaoErp;
	
	@ApiModelProperty(value = "Numero do Lote de Faturamento", required = true, notes = "")
	@Column(name = "ACX_NU_LOTE_FATURAMENTO")
	private String numeroLoteFaturamento;
	
	@ApiModelProperty(value = "Quantidade Total de Requisição a Solução Fiscal", required = true, notes = "")
	@Column(name = "ACX_QT_TOTAL_REQUISICAO_SF")
	private Long quantidadeRequisicaoSF;
	
	@ApiModelProperty(value = "Numero na Solução Fiscal", required = true, notes = "")
	@Column(name = "SFA_NU")
	private Long numeroSF;
	
	@ApiModelProperty(value = "Total de Taxas", required = true, notes = "")
	@Column(name = "ACX_VR_TOTAL_TAXA_ATENDIMENTO")
	private BigDecimal valorTotalTaxa;

	public Atendimento() {}

	public Atendimento(Long id, Long numeroDoCaixa, Long numeroDoCliente, Long numeroDoContrato, Long mcu,
			Long numeroFuncionario, Long idAtendimentoDeEstorno, Long numeroModalidadePagamento,
			Long numeroCartaoPostagem, Long sequencialAtendimentoCaixa, LocalDateTime dataInicioAtendimento, LocalDateTime dataFinalAtendimento,
			BigDecimal valorTotalDesconto, BigDecimal valorTotalAtendimento, Boolean isEstornado,
			BigDecimal valorTotalIsencao, BigDecimal valorTotalFranqueamento, Long numeroDocumentoPostagem,
			Boolean isAtendidoOffline, Long numeroAtendimentoFuncionario, Boolean isNumeroFaturaCliente,
			Long numeroNotaFiscal, Long numeroStoAcf, Boolean isCategoriaPrecoDefinido, Boolean isImportacao,
			Boolean isOrigemAtendimento, LocalDateTime dataImportacaoErp, String numeroLoteFaturamento,
			Long quantidadeRequisicaoSF, Long numeroSF, BigDecimal valorTotalTaxa) {
		super();
		this.id = id;
		this.numeroDoCaixa = numeroDoCaixa;
		this.numeroDoCliente = numeroDoCliente;
		this.numeroDoContrato = numeroDoContrato;
		this.mcu = mcu;
		this.numeroFuncionario = numeroFuncionario;
		this.idAtendimentoDeEstorno = idAtendimentoDeEstorno;
		this.numeroModalidadePagamento = numeroModalidadePagamento;
		this.numeroCartaoPostagem = numeroCartaoPostagem;
		this.sequencialAtendimentoCaixa = sequencialAtendimentoCaixa;
		this.dataInicioAtendimento = dataInicioAtendimento;
		this.dataFinalAtendimento = dataFinalAtendimento;
		this.valorTotalDesconto = valorTotalDesconto;
		this.valorTotalAtendimento = valorTotalAtendimento;
		this.isEstornado = isEstornado;
		this.valorTotalIsencao = valorTotalIsencao;
		this.valorTotalFranqueamento = valorTotalFranqueamento;
		this.numeroDocumentoPostagem = numeroDocumentoPostagem;
		this.isAtendidoOffline = isAtendidoOffline;
		this.numeroAtendimentoFuncionario = numeroAtendimentoFuncionario;
		this.isNumeroFaturaCliente = isNumeroFaturaCliente;
		this.numeroNotaFiscal = numeroNotaFiscal;
		this.numeroStoAcf = numeroStoAcf;
		this.isCategoriaPrecoDefinido = isCategoriaPrecoDefinido;
		this.isImportacao = isImportacao;
		this.isOrigemAtendimento = isOrigemAtendimento;
		this.dataImportacaoErp = dataImportacaoErp;
		this.numeroLoteFaturamento = numeroLoteFaturamento;
		this.quantidadeRequisicaoSF = quantidadeRequisicaoSF;
		this.numeroSF = numeroSF;
		this.valorTotalTaxa = valorTotalTaxa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroDoCaixa() {
		return numeroDoCaixa;
	}

	public void setNumeroDoCaixa(Long numeroDoCaixa) {
		this.numeroDoCaixa = numeroDoCaixa;
	}

	public Long getNumeroDoCliente() {
		return numeroDoCliente;
	}

	public void setNumeroDoCliente(Long numeroDoCliente) {
		this.numeroDoCliente = numeroDoCliente;
	}

	public Long getNumeroDoContrato() {
		return numeroDoContrato;
	}

	public void setNumeroDoContrato(Long numeroDoContrato) {
		this.numeroDoContrato = numeroDoContrato;
	}

	public Long getMcu() {
		return mcu;
	}

	public void setMcu(Long mcu) {
		this.mcu = mcu;
	}

	public Long getNumeroFuncionario() {
		return numeroFuncionario;
	}

	public void setNumeroFuncionario(Long numeroFuncionario) {
		this.numeroFuncionario = numeroFuncionario;
	}

	public Long getIdAtendimentoDeEstorno() {
		return idAtendimentoDeEstorno;
	}

	public void setIdAtendimentoDeEstorno(Long idAtendimentoDeEstorno) {
		this.idAtendimentoDeEstorno = idAtendimentoDeEstorno;
	}

	public Long getNumeroModalidadePagamento() {
		return numeroModalidadePagamento;
	}

	public void setNumeroModalidadePagamento(Long numeroModalidadePagamento) {
		this.numeroModalidadePagamento = numeroModalidadePagamento;
	}

	public Long getNumeroCartaoPostagem() {
		return numeroCartaoPostagem;
	}

	public void setNumeroCartaoPostagem(Long numeroCartaoPostagem) {
		this.numeroCartaoPostagem = numeroCartaoPostagem;
	}

	public Long getSequencialAtendimentoCaixa() {
		return sequencialAtendimentoCaixa;
	}

	public void setSequencialAtendimentoCaixa(Long sequencialAtendimentoCaixa) {
		this.sequencialAtendimentoCaixa = sequencialAtendimentoCaixa;
	}

	public LocalDateTime getDataInicioAtendimento() {
		return dataInicioAtendimento;
	}

	public void setDataInicioAtendimento(LocalDateTime dataInicioAtendimento) {
		this.dataInicioAtendimento = dataInicioAtendimento;
	}

	public LocalDateTime getDataFinalAtendimento() {
		return dataFinalAtendimento;
	}

	public void setDataFinalAtendimento(LocalDateTime dataFinalAtendimento) {
		this.dataFinalAtendimento = dataFinalAtendimento;
	}

	public BigDecimal getValorTotalDesconto() {
		return valorTotalDesconto;
	}

	public void setValorTotalDesconto(BigDecimal valorTotalDesconto) {
		this.valorTotalDesconto = valorTotalDesconto;
	}

	public BigDecimal getValorTotalAtendimento() {
		return valorTotalAtendimento;
	}

	public void setValorTotalAtendimento(BigDecimal valorTotalAtendimento) {
		this.valorTotalAtendimento = valorTotalAtendimento;
	}

	public Boolean getIsEstornado() {
		return isEstornado;
	}

	public void setIsEstornado(Boolean isEstornado) {
		this.isEstornado = isEstornado;
	}

	public BigDecimal getValorTotalIsencao() {
		return valorTotalIsencao;
	}

	public void setValorTotalIsencao(BigDecimal valorTotalIsencao) {
		this.valorTotalIsencao = valorTotalIsencao;
	}

	public BigDecimal getValorTotalFranqueamento() {
		return valorTotalFranqueamento;
	}

	public void setValorTotalFranqueamento(BigDecimal valorTotalFranqueamento) {
		this.valorTotalFranqueamento = valorTotalFranqueamento;
	}

	public Long getNumeroDocumentoPostagem() {
		return numeroDocumentoPostagem;
	}

	public void setNumeroDocumentoPostagem(Long numeroDocumentoPostagem) {
		this.numeroDocumentoPostagem = numeroDocumentoPostagem;
	}

	public Boolean getIsAtendidoOffline() {
		return isAtendidoOffline;
	}

	public void setIsAtendidoOffline(Boolean isAtendidoOffline) {
		this.isAtendidoOffline = isAtendidoOffline;
	}

	public Long getNumeroAtendimentoFuncionario() {
		return numeroAtendimentoFuncionario;
	}

	public void setNumeroAtendimentoFuncionario(Long numeroAtendimentoFuncionario) {
		this.numeroAtendimentoFuncionario = numeroAtendimentoFuncionario;
	}

	public Boolean getIsNumeroFaturaCliente() {
		return isNumeroFaturaCliente;
	}

	public void setIsNumeroFaturaCliente(Boolean isNumeroFaturaCliente) {
		this.isNumeroFaturaCliente = isNumeroFaturaCliente;
	}

	public Long getNumeroNotaFiscal() {
		return numeroNotaFiscal;
	}

	public void setNumeroNotaFiscal(Long numeroNotaFiscal) {
		this.numeroNotaFiscal = numeroNotaFiscal;
	}

	public Long getNumeroStoAcf() {
		return numeroStoAcf;
	}

	public void setNumeroStoAcf(Long numeroStoAcf) {
		this.numeroStoAcf = numeroStoAcf;
	}

	public Boolean getIsCategoriaPrecoDefinido() {
		return isCategoriaPrecoDefinido;
	}

	public void setIsCategoriaPrecoDefinido(Boolean isCategoriaPrecoDefinido) {
		this.isCategoriaPrecoDefinido = isCategoriaPrecoDefinido;
	}

	public Boolean getIsImportacao() {
		return isImportacao;
	}

	public void setIsImportacao(Boolean isImportacao) {
		this.isImportacao = isImportacao;
	}

	public Boolean getIsOrigemAtendimento() {
		return isOrigemAtendimento;
	}

	public void setIsOrigemAtendimento(Boolean isOrigemAtendimento) {
		this.isOrigemAtendimento = isOrigemAtendimento;
	}

	public LocalDateTime getDataImportacaoErp() {
		return dataImportacaoErp;
	}

	public void setDataImportacaoErp(LocalDateTime dataImportacaoErp) {
		this.dataImportacaoErp = dataImportacaoErp;
	}

	public String getNumeroLoteFaturamento() {
		return numeroLoteFaturamento;
	}

	public void setNumeroLoteFaturamento(String numeroLoteFaturamento) {
		this.numeroLoteFaturamento = numeroLoteFaturamento;
	}

	public Long getQuantidadeRequisicaoSF() {
		return quantidadeRequisicaoSF;
	}

	public void setQuantidadeRequisicaoSF(Long quantidadeRequisicaoSF) {
		this.quantidadeRequisicaoSF = quantidadeRequisicaoSF;
	}

	public Long getNumeroSF() {
		return numeroSF;
	}

	public void setNumeroSF(Long numeroSF) {
		this.numeroSF = numeroSF;
	}

	public BigDecimal getValorTotalTaxa() {
		return valorTotalTaxa;
	}

	public void setValorTotalTaxa(BigDecimal valorTotalTaxa) {
		this.valorTotalTaxa = valorTotalTaxa;
	}
	
	
	
}
