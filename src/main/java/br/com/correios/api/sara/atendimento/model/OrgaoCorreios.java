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
@Table(name = "NEP_ORGAO_CORREIOS")
public class OrgaoCorreios implements Serializable {

	@ApiModelProperty(value = "Id da Unidade", required = true, notes = "")
	@Id
	@Column(name = "ORG_NU_AGENCIA")
	private Long id;

	@ApiModelProperty(value = "Numero do Tipo de Agencia", required = true, notes = "")
	@Column(name = "TAG_NU_TIPO_AGENCIA")
	private Long numeroTipoAgencia;

	@ApiModelProperty(value = "Numero da Diretoria", required = true, notes = "")
	@Column(name = "DIR_NU_DIRETORIA")
	private Long numeroDiretoria;
	
	@ApiModelProperty(value = "Numero da REOP", required = true, notes = "")
	@Column(name = "REP_NU_REOP")
	private Long numeroReop;
	
	@ApiModelProperty(value = "Numero da Cidade", required = true, notes = "")
	@Column(name = "CID_NU_CIDADE")
	private Long numeroCidade;
	
	@ApiModelProperty(value = "Tipo de Logradouro", required = true, notes = "")
	@Column(name = "TLG_NU_TIPO_LOGRADOURO")
	private Long tipoLogradouro;
	
	@ApiModelProperty(value = "Numero Funcionario do Gerente", required = true, notes = "")
	@Column(name = "FCR_NU_FUNC_GERENTE")
	private Long numeroFuncionarioGerente;
	
	@ApiModelProperty(value = "Nome da Unidade", required = true, notes = "")
	@Column(name = "ORG_TX_NOME_FANTASIA")
	private String nomeUnidade;
	
	@ApiModelProperty(value = "Codigo STO", required = true, notes = "")
	@Column(name = "ORG_CO_STO")
	private String codigoSto;
	
	@ApiModelProperty(value = "Codigo OPR", required = true, notes = "")
	@Column(name = "ORG_CO_OPR")
	private String codigoOpr;
	
	@ApiModelProperty(value = "CNPJ da Unidade", required = true, notes = "")
	@Column(name = "ORG_CO_CNPJ")
	private String cnpj;

	@ApiModelProperty(value = "Inscricao Estadual", required = true, notes = "")
	@Column(name = "ORG_CO_INSCRICAO_ESTADUAL")
	private String inscricaoEstadual;
	
	@ApiModelProperty(value = "Valor Limite Numerario", required = true, notes = "")
	@Column(name = "ORG_VR_LIMITE_NUMERARIO")
	private BigDecimal valorLimiteNumerario;
	
	@ApiModelProperty(value = "Hora de Abertura durante a semana", required = true, notes = "")
	@Column(name = "ORG_HR_INICIO_SEMANA")
	private Date horaAberturaDuranteSemana;
	
	@ApiModelProperty(value = "Hora de Fechamento durante a semana", required = true, notes = "")
	@Column(name = "ORG_HR_FINAL_SEMANA")
	private Date horaFechamentoDuranteSemana;
	
	@ApiModelProperty(value = "Hora de Abertura durante o sábado", required = true, notes = "")
	@Column(name = "ORG_HR_INICIO_SABADO")
	private Date horaAberturaDuranteSabado;
	
	@ApiModelProperty(value = "Hora de Fechamento durante o sábado", required = true, notes = "")
	@Column(name = "ORG_HR_FINAL_SABADO")
	private Date horaFechamentoDuranteSabado;
	
	@ApiModelProperty(value = "Hora de Abertura durante o domingo", required = true, notes = "")
	@Column(name = "ORG_HR_INICIO_DOMINGO")
	private Date horaAberturaDuranteDomingo;
	
	@ApiModelProperty(value = "Hora de Fechamento durante o domingo", required = true, notes = "")
	@Column(name = "ORG_HR_FINAL_DOMINGO")
	private Date horaFechamentoDuranteDomingo;
      
	@ApiModelProperty(value = "Hora de Abertura de Plantão no sábado", required = true, notes = "")
	@Column(name = "ORG_HR_INIC_PLAN_SABADO")
	private Date horaAberturaPlantaoSabado;
	
	@ApiModelProperty(value = "Hora de Fechamento de Plantão no sábado", required = true, notes = "")
	@Column(name = "ORG_HR_FINAL_PLAN_SABADO")
	private Date horaFechamentoPlantaoSabado;
	
	@ApiModelProperty(value = "Hora de Abertura de Plantão no domingo", required = true, notes = "")
	@Column(name = "ORG_HR_INIC_PLAN_DOMINGO")
	private Date horaAberturaPlantaoDomingo;
	
	@ApiModelProperty(value = "Hora de Fechamento de Plantão no domingo", required = true, notes = "")
	@Column(name = "ORG_HR_FINAL_PLAN_DOMINGO")
	private Date horaFechamentoPlantaoDomingo;
	
	@ApiModelProperty(value = "Indicador de Agencia Unipessoal", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_AGENCIA_UNIPESSOAL")
	private Boolean isUnipessoal;
	
	@ApiModelProperty(value = "Indicador de Emissao de Cupom", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_EMISSAO_CUPOM")
	private Boolean isEmissaoCupom;
	
	@ApiModelProperty(value = "Indicador de Trabalho aos Sábados", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_TRABALHO_SABADO")
	private Boolean isTrabalhaAosSabados;
	
	@ApiModelProperty(value = "Indicador de Trabalho aos Domingos", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_TRABALHO_DOMINGO")
	private Boolean isTrabalhaAosDomingos;
	
	@ApiModelProperty(value = "Indicador de Plantão aos Sábados", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_PLANTAO_SABADO")
	private Boolean isPlantaoAosSabados;
	
	@ApiModelProperty(value = "Indicador de Plantao aos Domingos", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_PLANTAO_DOMINGO")
	private Boolean isPlantaoAosDomingos;
	
	@ApiModelProperty(value = "Indicador de Funcao Postal", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_FUNCAO_POSTAL")
	private Boolean isFuncaoPostal;
	
	@ApiModelProperty(value = "Indicador de Funcao Banco", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_FUNCAO_BANCO")
	private Boolean isFuncaoBanco;
	
	@ApiModelProperty(value = "Endereço", required = true, notes = "")
	@Column(name = "ORG_TX_ENDERECO_ORGAO")
	private String endereco;
	
	@ApiModelProperty(value = "Complemento do Endereço", required = true, notes = "")
	@Column(name = "ORG_TX_COMPL_ORGAO")
	private String complementoEndereco;
	
	@ApiModelProperty(value = "Numero do Endereço", required = true, notes = "")
	@Column(name = "ORG_NU_ENDERECO_ORGAO")
	private String numeroEndereco;
	
	@ApiModelProperty(value = "Bairro", required = true, notes = "")
	@Column(name = "ORG_TX_BAIRRO_ORGAO")
	private String bairro;
	
	@ApiModelProperty(value = "Cep", required = true, notes = "")
	@Column(name = "ORG_CO_CEP_ORGAO")
	private Long cep;
	
	@ApiModelProperty(value = "Código DDD", required = true, notes = "")
	@Column(name = "ORG_NU_DDD")
	private Integer codigoDDD;
	
	@ApiModelProperty(value = "Numero de Telefone", required = true, notes = "")
	@Column(name = "ORG_NU_TELEFONE")
	private String numeroTelefone;
	
	@ApiModelProperty(value = "Indicador Unidade Ativa", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_ATIVO")
	private Boolean isAtivo;
	
	@ApiModelProperty(value = "Data de Implantação do SARA", required = true, notes = "")
	@Column(name = "ORG_DT_IMPLANTACAO_SARA")
	private Date dataImplantacaoSARA;
	
	@ApiModelProperty(value = "Hora Limite de Postagem Durante a Semana", required = true, notes = "")
	@Column(name = "ORG_HR_LIMITE_POST_SEMANA")
	private Date horaLimitePostagemSemana;
	
	@ApiModelProperty(value = "Hora Limite de Postagem Durante Fins de Semana", required = true, notes = "")
	@Column(name = "ORG_HR_LIMITE_POST_FIM_SEMANA")
	private Date horaLimitePostagemFimDeSemana;
	
	@ApiModelProperty(value = "Codigo do Cadastro Geral", required = true, notes = "")
	@Column(name = "ORG_CO_CADASTRO_GERAL")
	private Long codigoCadastroGeral;
	
	@ApiModelProperty(value = "Indicador de Pagador de INSS", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_PAGADOR_INSS")
	private Boolean isPagadorINSS;
	
	@ApiModelProperty(value = "Indicador de QMATIQ", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_QMATIC")
	private Boolean isQMATIC;
	
	@ApiModelProperty(value = "Numero da Microregiao", required = true, notes = "")
	@Column(name = "ORG_NU_MICROREGIAO")
	private Long numeroMicroregiao;
	
	@ApiModelProperty(value = "Numero da Regiao", required = true, notes = "")
	@Column(name = "ORG_NU_REGIAO")
	private Long numeroRegiao;
	
	@ApiModelProperty(value = "Grupo de Tarifacao", required = true, notes = "")
	@Column(name = "ORG_TX_GRUPO_TARIFACAO")
	private String grupoTarifacao;
	
	@ApiModelProperty(value = "Data da Ultima Alteração", required = true, notes = "")
	@Column(name = "ORG_DH_ALTERACAO")
	private Date dataAlteracao;

	@ApiModelProperty(value = "CEP SRO", required = true, notes = "")
	@Column(name = "ORG_CO_CEP_SRO")
	private Long cepSRO;
	
	@ApiModelProperty(value = "mcu", required = true, notes = "")
	@Column(name = "ORG_NU_MCU")
	private Long mcu;
	
	@ApiModelProperty(value = "Indicador de Centro de Distribuição", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_CENTRO_DISTRIBUIC")
	private Boolean isCentroDistribuicao;
	
	@ApiModelProperty(value = "Indicador de Habilitado Offline", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_HABILITADO_OFFLINE")
	private Boolean isHabilitadoOffline;
	
	@ApiModelProperty(value = "Indicador de Fornecedor Mat Suspenso", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_FORNEC_MAT_SUSPENSO")
	private Boolean isFornecedorMatSuspenso;
	
	@ApiModelProperty(value = "Quantidade Máxima Guiche Empresarial", required = true, notes = "")
	@Column(name = "ORG_QT_MAX_GUICHE_EMPRESARIAL")
	private Long quantidadeMaximaGuicheEmpresarial;
	
	@ApiModelProperty(value = "Indicador de Atendimento Balcao", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_ATENDIMENTO_BALCAO")
	private Boolean isAtendimentoBalcao;
	
	@ApiModelProperty(value = "Indicador de Atendimento Internet", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_ATENDIMENTO_INTERNET")
	private Boolean isAtendimentoInternet;
	
	@ApiModelProperty(value = "Indicador de Atendimento Internacional", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_ATEND_INTERNACIONAL")
	private Boolean isAtendimentoInternacional;
	
	@ApiModelProperty(value = "Indicador de Atendimento Internacional", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_CONTRIBUINTE_ICMS")
	private Boolean isContribuinteICMS;
	
	@ApiModelProperty(value = "Email", required = true, notes = "")
	@Column(name = "ORG_ED_EMAIL")
	private String email;
	
	@ApiModelProperty(value = "ABAC25 MECANIZACAO ANTERIOR", required = true, notes = "")
	@Column(name = "ABAC25_MECANIZACAO_ANTERIOR")
	private String mecanizacaoAnterior;
	
	@ApiModelProperty(value = "Indicador de Impressao", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_IMPRESSAO")
	private Boolean isImpressao;
	
	@ApiModelProperty(value = "Indicador de Sistema CBP", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_SISTEMA_CBP")
	private Boolean isSistemCBP;
	
	@ApiModelProperty(value = "Indicador de Realizacao Verificação Atual", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_REALIZ_VERIF_ATUAL")
	private Boolean isRealizacaoVerificacaoAtual;
	
	@ApiModelProperty(value = "Indicador de Situacao Fiscal", required = true, notes = "")
	@Column(name = "ORG_IN_SITUACAO_FISCAL")
	private String indicadorSituacaoFiscal;
	
	@ApiModelProperty(value = "Indicador de Solução Fiscal", required = true, notes = "")
	@Column(name = "ORG_IN_SOLUCAO_FISCAL")
	private String indicadorSolucaoFiscal;
	
	@ApiModelProperty(value = "Tipo de Agencia Real", required = true, notes = "")
	@Column(name = "TAG_NU_TIPO_AGENCIA_REAL")
	private Long tipoAgenciaReal;
	
	@ApiModelProperty(value = "Indicador de Plano de Triagem Ativado", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_PLANO_TRIAGEM")
	private Boolean isPlanoTriagemAtivado;
	
	@ApiModelProperty(value = "Indicador de Captacao Automatica Ativada", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_CAPTACAO_AUTOMATICA")
	private Boolean isCaptacaoAutomaticaAtivado;
	
	@ApiModelProperty(value = "Status da Rotina de Captação Automática", required = true, notes = "")
	@Column(name = "ORG_IN_ROTINA_CAPTACAO")
	private String indicadorRotinaCaptacaoAutomatica;
	
	@ApiModelProperty(value = "Indicador de Trabalho aos Feriados", required = true, notes = "")
	@Convert(converter = BooleanSimNaoConverter.class)
	@Column(name = "ORG_IN_TRABALHO_FERIADO")
	private Boolean isTrabalhaAosFeriados;
	
	@ApiModelProperty(value = "Indicador de MOV_BDF_ERP", required = true, notes = "")
	@Column(name = "ORG_IN_MOV_BDF_ERP")
	private String indicadorMOV_BDF_ERP;

	public OrgaoCorreios() {}

	public OrgaoCorreios(Long id, Long numeroTipoAgencia, Long numeroDiretoria, Long numeroReop, Long numeroCidade,
			Long tipoLogradouro, Long numeroFuncionarioGerente, String nomeUnidade, String codigoSto, String codigoOpr,
			String cnpj, String inscricaoEstadual, BigDecimal valorLimiteNumerario, Date horaAberturaDuranteSemana,
			Date horaFechamentoDuranteSemana, Date horaAberturaDuranteSabado, Date horaFechamentoDuranteSabado,
			Date horaAberturaDuranteDomingo, Date horaFechamentoDuranteDomingo, Date horaAberturaPlantaoSabado,
			Date horaFechamentoPlantaoSabado, Date horaAberturaPlantaoDomingo, Date horaFechamentoPlantaoDomingo,
			Boolean isUnipessoal, Boolean isEmissaoCupom, Boolean isTrabalhaAosSabados, Boolean isTrabalhaAosDomingos,
			Boolean isPlantaoAosSabados, Boolean isPlantaoAosDomingos, Boolean isFuncaoPostal, Boolean isFuncaoBanco,
			String endereco, String complementoEndereco, String numeroEndereco, String bairro, Long cep,
			Integer codigoDDD, String numeroTelefone, Boolean isAtivo, Date dataImplantacaoSARA,
			Date horaLimitePostagemSemana, Date horaLimitePostagemFimDeSemana, Long codigoCadastroGeral,
			Boolean isPagadorINSS, Boolean isQMATIC, Long numeroMicroregiao, Long numeroRegiao, String grupoTarifacao,
			Date dataAlteracao, Long cepSRO, Long mcu, Boolean isCentroDistribuicao, Boolean isHabilitadoOffline,
			Boolean isFornecedorMatSuspenso, Long quantidadeMaximaGuicheEmpresarial, Boolean isAtendimentoBalcao,
			Boolean isAtendimentoInternet, Boolean isAtendimentoInternacional, Boolean isContribuinteICMS, String email,
			String mecanizacaoAnterior, Boolean isImpressao, Boolean isSistemCBP, Boolean isRealizacaoVerificacaoAtual,
			String indicadorSituacaoFiscal, String indicadorSolucaoFiscal, Long tipoAgenciaReal,
			Boolean isPlanoTriagemAtivado, Boolean isCaptacaoAutomaticaAtivado,
			String indicadorRotinaCaptacaoAutomatica, Boolean isTrabalhaAosFeriados, String indicadorMOV_BDF_ERP) {
		super();
		this.id = id;
		this.numeroTipoAgencia = numeroTipoAgencia;
		this.numeroDiretoria = numeroDiretoria;
		this.numeroReop = numeroReop;
		this.numeroCidade = numeroCidade;
		this.tipoLogradouro = tipoLogradouro;
		this.numeroFuncionarioGerente = numeroFuncionarioGerente;
		this.nomeUnidade = nomeUnidade;
		this.codigoSto = codigoSto;
		this.codigoOpr = codigoOpr;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.valorLimiteNumerario = valorLimiteNumerario;
		this.horaAberturaDuranteSemana = horaAberturaDuranteSemana;
		this.horaFechamentoDuranteSemana = horaFechamentoDuranteSemana;
		this.horaAberturaDuranteSabado = horaAberturaDuranteSabado;
		this.horaFechamentoDuranteSabado = horaFechamentoDuranteSabado;
		this.horaAberturaDuranteDomingo = horaAberturaDuranteDomingo;
		this.horaFechamentoDuranteDomingo = horaFechamentoDuranteDomingo;
		this.horaAberturaPlantaoSabado = horaAberturaPlantaoSabado;
		this.horaFechamentoPlantaoSabado = horaFechamentoPlantaoSabado;
		this.horaAberturaPlantaoDomingo = horaAberturaPlantaoDomingo;
		this.horaFechamentoPlantaoDomingo = horaFechamentoPlantaoDomingo;
		this.isUnipessoal = isUnipessoal;
		this.isEmissaoCupom = isEmissaoCupom;
		this.isTrabalhaAosSabados = isTrabalhaAosSabados;
		this.isTrabalhaAosDomingos = isTrabalhaAosDomingos;
		this.isPlantaoAosSabados = isPlantaoAosSabados;
		this.isPlantaoAosDomingos = isPlantaoAosDomingos;
		this.isFuncaoPostal = isFuncaoPostal;
		this.isFuncaoBanco = isFuncaoBanco;
		this.endereco = endereco;
		this.complementoEndereco = complementoEndereco;
		this.numeroEndereco = numeroEndereco;
		this.bairro = bairro;
		this.cep = cep;
		this.codigoDDD = codigoDDD;
		this.numeroTelefone = numeroTelefone;
		this.isAtivo = isAtivo;
		this.dataImplantacaoSARA = dataImplantacaoSARA;
		this.horaLimitePostagemSemana = horaLimitePostagemSemana;
		this.horaLimitePostagemFimDeSemana = horaLimitePostagemFimDeSemana;
		this.codigoCadastroGeral = codigoCadastroGeral;
		this.isPagadorINSS = isPagadorINSS;
		this.isQMATIC = isQMATIC;
		this.numeroMicroregiao = numeroMicroregiao;
		this.numeroRegiao = numeroRegiao;
		this.grupoTarifacao = grupoTarifacao;
		this.dataAlteracao = dataAlteracao;
		this.cepSRO = cepSRO;
		this.mcu = mcu;
		this.isCentroDistribuicao = isCentroDistribuicao;
		this.isHabilitadoOffline = isHabilitadoOffline;
		this.isFornecedorMatSuspenso = isFornecedorMatSuspenso;
		this.quantidadeMaximaGuicheEmpresarial = quantidadeMaximaGuicheEmpresarial;
		this.isAtendimentoBalcao = isAtendimentoBalcao;
		this.isAtendimentoInternet = isAtendimentoInternet;
		this.isAtendimentoInternacional = isAtendimentoInternacional;
		this.isContribuinteICMS = isContribuinteICMS;
		this.email = email;
		this.mecanizacaoAnterior = mecanizacaoAnterior;
		this.isImpressao = isImpressao;
		this.isSistemCBP = isSistemCBP;
		this.isRealizacaoVerificacaoAtual = isRealizacaoVerificacaoAtual;
		this.indicadorSituacaoFiscal = indicadorSituacaoFiscal;
		this.indicadorSolucaoFiscal = indicadorSolucaoFiscal;
		this.tipoAgenciaReal = tipoAgenciaReal;
		this.isPlanoTriagemAtivado = isPlanoTriagemAtivado;
		this.isCaptacaoAutomaticaAtivado = isCaptacaoAutomaticaAtivado;
		this.indicadorRotinaCaptacaoAutomatica = indicadorRotinaCaptacaoAutomatica;
		this.isTrabalhaAosFeriados = isTrabalhaAosFeriados;
		this.indicadorMOV_BDF_ERP = indicadorMOV_BDF_ERP;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroTipoAgencia() {
		return numeroTipoAgencia;
	}

	public void setNumeroTipoAgencia(Long numeroTipoAgencia) {
		this.numeroTipoAgencia = numeroTipoAgencia;
	}

	public Long getNumeroDiretoria() {
		return numeroDiretoria;
	}

	public void setNumeroDiretoria(Long numeroDiretoria) {
		this.numeroDiretoria = numeroDiretoria;
	}

	public Long getNumeroReop() {
		return numeroReop;
	}

	public void setNumeroReop(Long numeroReop) {
		this.numeroReop = numeroReop;
	}

	public Long getNumeroCidade() {
		return numeroCidade;
	}

	public void setNumeroCidade(Long numeroCidade) {
		this.numeroCidade = numeroCidade;
	}

	public Long getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(Long tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public Long getNumeroFuncionarioGerente() {
		return numeroFuncionarioGerente;
	}

	public void setNumeroFuncionarioGerente(Long numeroFuncionarioGerente) {
		this.numeroFuncionarioGerente = numeroFuncionarioGerente;
	}

	public String getNomeUnidade() {
		return nomeUnidade;
	}

	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}

	public String getCodigoSto() {
		return codigoSto;
	}

	public void setCodigoSto(String codigoSto) {
		this.codigoSto = codigoSto;
	}

	public String getCodigoOpr() {
		return codigoOpr;
	}

	public void setCodigoOpr(String codigoOpr) {
		this.codigoOpr = codigoOpr;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public BigDecimal getValorLimiteNumerario() {
		return valorLimiteNumerario;
	}

	public void setValorLimiteNumerario(BigDecimal valorLimiteNumerario) {
		this.valorLimiteNumerario = valorLimiteNumerario;
	}

	public Date getHoraAberturaDuranteSemana() {
		return horaAberturaDuranteSemana;
	}

	public void setHoraAberturaDuranteSemana(Date horaAberturaDuranteSemana) {
		this.horaAberturaDuranteSemana = horaAberturaDuranteSemana;
	}

	public Date getHoraFechamentoDuranteSemana() {
		return horaFechamentoDuranteSemana;
	}

	public void setHoraFechamentoDuranteSemana(Date horaFechamentoDuranteSemana) {
		this.horaFechamentoDuranteSemana = horaFechamentoDuranteSemana;
	}

	public Date getHoraAberturaDuranteSabado() {
		return horaAberturaDuranteSabado;
	}

	public void setHoraAberturaDuranteSabado(Date horaAberturaDuranteSabado) {
		this.horaAberturaDuranteSabado = horaAberturaDuranteSabado;
	}

	public Date getHoraFechamentoDuranteSabado() {
		return horaFechamentoDuranteSabado;
	}

	public void setHoraFechamentoDuranteSabado(Date horaFechamentoDuranteSabado) {
		this.horaFechamentoDuranteSabado = horaFechamentoDuranteSabado;
	}

	public Date getHoraAberturaDuranteDomingo() {
		return horaAberturaDuranteDomingo;
	}

	public void setHoraAberturaDuranteDomingo(Date horaAberturaDuranteDomingo) {
		this.horaAberturaDuranteDomingo = horaAberturaDuranteDomingo;
	}

	public Date getHoraFechamentoDuranteDomingo() {
		return horaFechamentoDuranteDomingo;
	}

	public void setHoraFechamentoDuranteDomingo(Date horaFechamentoDuranteDomingo) {
		this.horaFechamentoDuranteDomingo = horaFechamentoDuranteDomingo;
	}

	public Date getHoraAberturaPlantaoSabado() {
		return horaAberturaPlantaoSabado;
	}

	public void setHoraAberturaPlantaoSabado(Date horaAberturaPlantaoSabado) {
		this.horaAberturaPlantaoSabado = horaAberturaPlantaoSabado;
	}

	public Date getHoraFechamentoPlantaoSabado() {
		return horaFechamentoPlantaoSabado;
	}

	public void setHoraFechamentoPlantaoSabado(Date horaFechamentoPlantaoSabado) {
		this.horaFechamentoPlantaoSabado = horaFechamentoPlantaoSabado;
	}

	public Date getHoraAberturaPlantaoDomingo() {
		return horaAberturaPlantaoDomingo;
	}

	public void setHoraAberturaPlantaoDomingo(Date horaAberturaPlantaoDomingo) {
		this.horaAberturaPlantaoDomingo = horaAberturaPlantaoDomingo;
	}

	public Date getHoraFechamentoPlantaoDomingo() {
		return horaFechamentoPlantaoDomingo;
	}

	public void setHoraFechamentoPlantaoDomingo(Date horaFechamentoPlantaoDomingo) {
		this.horaFechamentoPlantaoDomingo = horaFechamentoPlantaoDomingo;
	}

	public Boolean getIsUnipessoal() {
		return isUnipessoal;
	}

	public void setIsUnipessoal(Boolean isUnipessoal) {
		this.isUnipessoal = isUnipessoal;
	}

	public Boolean getIsEmissaoCupom() {
		return isEmissaoCupom;
	}

	public void setIsEmissaoCupom(Boolean isEmissaoCupom) {
		this.isEmissaoCupom = isEmissaoCupom;
	}

	public Boolean getIsTrabalhaAosSabados() {
		return isTrabalhaAosSabados;
	}

	public void setIsTrabalhaAosSabados(Boolean isTrabalhaAosSabados) {
		this.isTrabalhaAosSabados = isTrabalhaAosSabados;
	}

	public Boolean getIsTrabalhaAosDomingos() {
		return isTrabalhaAosDomingos;
	}

	public void setIsTrabalhaAosDomingos(Boolean isTrabalhaAosDomingos) {
		this.isTrabalhaAosDomingos = isTrabalhaAosDomingos;
	}

	public Boolean getIsPlantaoAosSabados() {
		return isPlantaoAosSabados;
	}

	public void setIsPlantaoAosSabados(Boolean isPlantaoAosSabados) {
		this.isPlantaoAosSabados = isPlantaoAosSabados;
	}

	public Boolean getIsPlantaoAosDomingos() {
		return isPlantaoAosDomingos;
	}

	public void setIsPlantaoAosDomingos(Boolean isPlantaoAosDomingos) {
		this.isPlantaoAosDomingos = isPlantaoAosDomingos;
	}

	public Boolean getIsFuncaoPostal() {
		return isFuncaoPostal;
	}

	public void setIsFuncaoPostal(Boolean isFuncaoPostal) {
		this.isFuncaoPostal = isFuncaoPostal;
	}

	public Boolean getIsFuncaoBanco() {
		return isFuncaoBanco;
	}

	public void setIsFuncaoBanco(Boolean isFuncaoBanco) {
		this.isFuncaoBanco = isFuncaoBanco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplementoEndereco() {
		return complementoEndereco;
	}

	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public Integer getCodigoDDD() {
		return codigoDDD;
	}

	public void setCodigoDDD(Integer codigoDDD) {
		this.codigoDDD = codigoDDD;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public Date getDataImplantacaoSARA() {
		return dataImplantacaoSARA;
	}

	public void setDataImplantacaoSARA(Date dataImplantacaoSARA) {
		this.dataImplantacaoSARA = dataImplantacaoSARA;
	}

	public Date getHoraLimitePostagemSemana() {
		return horaLimitePostagemSemana;
	}

	public void setHoraLimitePostagemSemana(Date horaLimitePostagemSemana) {
		this.horaLimitePostagemSemana = horaLimitePostagemSemana;
	}

	public Date getHoraLimitePostagemFimDeSemana() {
		return horaLimitePostagemFimDeSemana;
	}

	public void setHoraLimitePostagemFimDeSemana(Date horaLimitePostagemFimDeSemana) {
		this.horaLimitePostagemFimDeSemana = horaLimitePostagemFimDeSemana;
	}

	public Long getCodigoCadastroGeral() {
		return codigoCadastroGeral;
	}

	public void setCodigoCadastroGeral(Long codigoCadastroGeral) {
		this.codigoCadastroGeral = codigoCadastroGeral;
	}

	public Boolean getIsPagadorINSS() {
		return isPagadorINSS;
	}

	public void setIsPagadorINSS(Boolean isPagadorINSS) {
		this.isPagadorINSS = isPagadorINSS;
	}

	public Boolean getIsQMATIC() {
		return isQMATIC;
	}

	public void setIsQMATIC(Boolean isQMATIC) {
		this.isQMATIC = isQMATIC;
	}

	public Long getNumeroMicroregiao() {
		return numeroMicroregiao;
	}

	public void setNumeroMicroregiao(Long numeroMicroregiao) {
		this.numeroMicroregiao = numeroMicroregiao;
	}

	public Long getNumeroRegiao() {
		return numeroRegiao;
	}

	public void setNumeroRegiao(Long numeroRegiao) {
		this.numeroRegiao = numeroRegiao;
	}

	public String getGrupoTarifacao() {
		return grupoTarifacao;
	}

	public void setGrupoTarifacao(String grupoTarifacao) {
		this.grupoTarifacao = grupoTarifacao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Long getCepSRO() {
		return cepSRO;
	}

	public void setCepSRO(Long cepSRO) {
		this.cepSRO = cepSRO;
	}

	public Long getMcu() {
		return mcu;
	}

	public void setMcu(Long mcu) {
		this.mcu = mcu;
	}

	public Boolean getIsCentroDistribuicao() {
		return isCentroDistribuicao;
	}

	public void setIsCentroDistribuicao(Boolean isCentroDistribuicao) {
		this.isCentroDistribuicao = isCentroDistribuicao;
	}

	public Boolean getIsHabilitadoOffline() {
		return isHabilitadoOffline;
	}

	public void setIsHabilitadoOffline(Boolean isHabilitadoOffline) {
		this.isHabilitadoOffline = isHabilitadoOffline;
	}

	public Boolean getIsFornecedorMatSuspenso() {
		return isFornecedorMatSuspenso;
	}

	public void setIsFornecedorMatSuspenso(Boolean isFornecedorMatSuspenso) {
		this.isFornecedorMatSuspenso = isFornecedorMatSuspenso;
	}

	public Long getQuantidadeMaximaGuicheEmpresarial() {
		return quantidadeMaximaGuicheEmpresarial;
	}

	public void setQuantidadeMaximaGuicheEmpresarial(Long quantidadeMaximaGuicheEmpresarial) {
		this.quantidadeMaximaGuicheEmpresarial = quantidadeMaximaGuicheEmpresarial;
	}

	public Boolean getIsAtendimentoBalcao() {
		return isAtendimentoBalcao;
	}

	public void setIsAtendimentoBalcao(Boolean isAtendimentoBalcao) {
		this.isAtendimentoBalcao = isAtendimentoBalcao;
	}

	public Boolean getIsAtendimentoInternet() {
		return isAtendimentoInternet;
	}

	public void setIsAtendimentoInternet(Boolean isAtendimentoInternet) {
		this.isAtendimentoInternet = isAtendimentoInternet;
	}

	public Boolean getIsAtendimentoInternacional() {
		return isAtendimentoInternacional;
	}

	public void setIsAtendimentoInternacional(Boolean isAtendimentoInternacional) {
		this.isAtendimentoInternacional = isAtendimentoInternacional;
	}

	public Boolean getIsContribuinteICMS() {
		return isContribuinteICMS;
	}

	public void setIsContribuinteICMS(Boolean isContribuinteICMS) {
		this.isContribuinteICMS = isContribuinteICMS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMecanizacaoAnterior() {
		return mecanizacaoAnterior;
	}

	public void setMecanizacaoAnterior(String mecanizacaoAnterior) {
		this.mecanizacaoAnterior = mecanizacaoAnterior;
	}

	public Boolean getIsImpressao() {
		return isImpressao;
	}

	public void setIsImpressao(Boolean isImpressao) {
		this.isImpressao = isImpressao;
	}

	public Boolean getIsSistemCBP() {
		return isSistemCBP;
	}

	public void setIsSistemCBP(Boolean isSistemCBP) {
		this.isSistemCBP = isSistemCBP;
	}

	public Boolean getIsRealizacaoVerificacaoAtual() {
		return isRealizacaoVerificacaoAtual;
	}

	public void setIsRealizacaoVerificacaoAtual(Boolean isRealizacaoVerificacaoAtual) {
		this.isRealizacaoVerificacaoAtual = isRealizacaoVerificacaoAtual;
	}

	public String getIndicadorSituacaoFiscal() {
		return indicadorSituacaoFiscal;
	}

	public void setIndicadorSituacaoFiscal(String indicadorSituacaoFiscal) {
		this.indicadorSituacaoFiscal = indicadorSituacaoFiscal;
	}

	public String getIndicadorSolucaoFiscal() {
		return indicadorSolucaoFiscal;
	}

	public void setIndicadorSolucaoFiscal(String indicadorSolucaoFiscal) {
		this.indicadorSolucaoFiscal = indicadorSolucaoFiscal;
	}

	public Long getTipoAgenciaReal() {
		return tipoAgenciaReal;
	}

	public void setTipoAgenciaReal(Long tipoAgenciaReal) {
		this.tipoAgenciaReal = tipoAgenciaReal;
	}

	public Boolean getIsPlanoTriagemAtivado() {
		return isPlanoTriagemAtivado;
	}

	public void setIsPlanoTriagemAtivado(Boolean isPlanoTriagemAtivado) {
		this.isPlanoTriagemAtivado = isPlanoTriagemAtivado;
	}

	public Boolean getIsCaptacaoAutomaticaAtivado() {
		return isCaptacaoAutomaticaAtivado;
	}

	public void setIsCaptacaoAutomaticaAtivado(Boolean isCaptacaoAutomaticaAtivado) {
		this.isCaptacaoAutomaticaAtivado = isCaptacaoAutomaticaAtivado;
	}

	public String getIndicadorRotinaCaptacaoAutomatica() {
		return indicadorRotinaCaptacaoAutomatica;
	}

	public void setIndicadorRotinaCaptacaoAutomatica(String indicadorRotinaCaptacaoAutomatica) {
		this.indicadorRotinaCaptacaoAutomatica = indicadorRotinaCaptacaoAutomatica;
	}

	public Boolean getIsTrabalhaAosFeriados() {
		return isTrabalhaAosFeriados;
	}

	public void setIsTrabalhaAosFeriados(Boolean isTrabalhaAosFeriados) {
		this.isTrabalhaAosFeriados = isTrabalhaAosFeriados;
	}

	public String getIndicadorMOV_BDF_ERP() {
		return indicadorMOV_BDF_ERP;
	}

	public void setIndicadorMOV_BDF_ERP(String indicadorMOV_BDF_ERP) {
		this.indicadorMOV_BDF_ERP = indicadorMOV_BDF_ERP;
	}
	
}