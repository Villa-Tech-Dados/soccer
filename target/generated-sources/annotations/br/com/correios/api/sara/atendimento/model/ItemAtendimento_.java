package br.com.correios.api.sara.atendimento.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.betfair.api.soccer.model.ItemAtendimento;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItemAtendimento.class)
public abstract class ItemAtendimento_ {

	public static volatile SingularAttribute<ItemAtendimento, Long> idItemCasado;
	public static volatile SingularAttribute<ItemAtendimento, Long> quantidadeAtendimento;
	public static volatile SingularAttribute<ItemAtendimento, BigDecimal> valorDesconto;
	public static volatile SingularAttribute<ItemAtendimento, String> controleCPC;
	public static volatile SingularAttribute<ItemAtendimento, Boolean> isAcertoFinanceiro;
	public static volatile SingularAttribute<ItemAtendimento, Date> dataInsercao;
	public static volatile SingularAttribute<ItemAtendimento, Long> sequncialItem;
	public static volatile SingularAttribute<ItemAtendimento, Boolean> isUtilizaCaptacao;
	public static volatile SingularAttribute<ItemAtendimento, BigDecimal> valorTotalRetencao;
	public static volatile SingularAttribute<ItemAtendimento, Long> motivoIsencao;
	public static volatile SingularAttribute<ItemAtendimento, Date> dataHoraFinalAtendimento;
	public static volatile SingularAttribute<ItemAtendimento, BigDecimal> valorReceita;
	public static volatile SingularAttribute<ItemAtendimento, String> etiqueta;
	public static volatile SingularAttribute<ItemAtendimento, String> codigoBarra;
	public static volatile SingularAttribute<ItemAtendimento, BigDecimal> precoDefinido;
	public static volatile SingularAttribute<ItemAtendimento, Boolean> isListaPostagem;
	public static volatile SingularAttribute<ItemAtendimento, Long> numeroNotaFiscal;
	public static volatile SingularAttribute<ItemAtendimento, Boolean> isFranqGrandePostagem;
	public static volatile SingularAttribute<ItemAtendimento, String> codigoRFID;
	public static volatile SingularAttribute<ItemAtendimento, Integer> tipoModelo;
	public static volatile SingularAttribute<ItemAtendimento, Long> id;
	public static volatile SingularAttribute<ItemAtendimento, String> numeroDocumento;
	public static volatile SingularAttribute<ItemAtendimento, String> protocoloCPC;
	public static volatile SingularAttribute<ItemAtendimento, Long> isEstornoItem;
	public static volatile SingularAttribute<ItemAtendimento, BigDecimal> precoUnitario;
	public static volatile SingularAttribute<ItemAtendimento, Long> numeroLancamento;
	public static volatile SingularAttribute<ItemAtendimento, Long> numeroContrato;
	public static volatile SingularAttribute<ItemAtendimento, BigDecimal> valorIsencao;
	public static volatile SingularAttribute<ItemAtendimento, Long> codigoMenuOrigemTopCo;
	public static volatile SingularAttribute<ItemAtendimento, Long> numeroCIC;
	public static volatile SingularAttribute<ItemAtendimento, BigDecimal> valorAtendimento;
	public static volatile SingularAttribute<ItemAtendimento, BigDecimal> valorTotalTaxa;
	public static volatile SingularAttribute<ItemAtendimento, Long> sequencialDocumentoFiscal;
	public static volatile SingularAttribute<ItemAtendimento, Long> idAtendimento;
	public static volatile SingularAttribute<ItemAtendimento, BigDecimal> valorOriginalItem;
	public static volatile SingularAttribute<ItemAtendimento, Long> idAgencia;
	public static volatile SingularAttribute<ItemAtendimento, Boolean> isExpedicao;
	public static volatile SingularAttribute<ItemAtendimento, BigDecimal> valorPreFranqueado;
	public static volatile SingularAttribute<ItemAtendimento, Date> dataHoraInicioAtendimento;
	public static volatile SingularAttribute<ItemAtendimento, Long> numeroRecargaMaquina;
	public static volatile SingularAttribute<ItemAtendimento, Date> dataPostagem;
	public static volatile SingularAttribute<ItemAtendimento, Boolean> isEstorno;
	public static volatile SingularAttribute<ItemAtendimento, Boolean> isOffline;
	public static volatile SingularAttribute<ItemAtendimento, BigDecimal> pesoObjeto;
	public static volatile SingularAttribute<ItemAtendimento, BigDecimal> numeroFaixa;
	public static volatile SingularAttribute<ItemAtendimento, Long> idProdutoServico;

	public static final String ID_ITEM_CASADO = "idItemCasado";
	public static final String QUANTIDADE_ATENDIMENTO = "quantidadeAtendimento";
	public static final String VALOR_DESCONTO = "valorDesconto";
	public static final String CONTROLE_CP_C = "controleCPC";
	public static final String IS_ACERTO_FINANCEIRO = "isAcertoFinanceiro";
	public static final String DATA_INSERCAO = "dataInsercao";
	public static final String SEQUNCIAL_ITEM = "sequncialItem";
	public static final String IS_UTILIZA_CAPTACAO = "isUtilizaCaptacao";
	public static final String VALOR_TOTAL_RETENCAO = "valorTotalRetencao";
	public static final String MOTIVO_ISENCAO = "motivoIsencao";
	public static final String DATA_HORA_FINAL_ATENDIMENTO = "dataHoraFinalAtendimento";
	public static final String VALOR_RECEITA = "valorReceita";
	public static final String ETIQUETA = "etiqueta";
	public static final String CODIGO_BARRA = "codigoBarra";
	public static final String PRECO_DEFINIDO = "precoDefinido";
	public static final String IS_LISTA_POSTAGEM = "isListaPostagem";
	public static final String NUMERO_NOTA_FISCAL = "numeroNotaFiscal";
	public static final String IS_FRANQ_GRANDE_POSTAGEM = "isFranqGrandePostagem";
	public static final String CODIGO_RF_ID = "codigoRFID";
	public static final String TIPO_MODELO = "tipoModelo";
	public static final String ID = "id";
	public static final String NUMERO_DOCUMENTO = "numeroDocumento";
	public static final String PROTOCOLO_CP_C = "protocoloCPC";
	public static final String IS_ESTORNO_ITEM = "isEstornoItem";
	public static final String PRECO_UNITARIO = "precoUnitario";
	public static final String NUMERO_LANCAMENTO = "numeroLancamento";
	public static final String NUMERO_CONTRATO = "numeroContrato";
	public static final String VALOR_ISENCAO = "valorIsencao";
	public static final String CODIGO_MENU_ORIGEM_TOP_CO = "codigoMenuOrigemTopCo";
	public static final String NUMERO_CI_C = "numeroCIC";
	public static final String VALOR_ATENDIMENTO = "valorAtendimento";
	public static final String VALOR_TOTAL_TAXA = "valorTotalTaxa";
	public static final String SEQUENCIAL_DOCUMENTO_FISCAL = "sequencialDocumentoFiscal";
	public static final String ID_ATENDIMENTO = "idAtendimento";
	public static final String VALOR_ORIGINAL_ITEM = "valorOriginalItem";
	public static final String ID_AGENCIA = "idAgencia";
	public static final String IS_EXPEDICAO = "isExpedicao";
	public static final String VALOR_PRE_FRANQUEADO = "valorPreFranqueado";
	public static final String DATA_HORA_INICIO_ATENDIMENTO = "dataHoraInicioAtendimento";
	public static final String NUMERO_RECARGA_MAQUINA = "numeroRecargaMaquina";
	public static final String DATA_POSTAGEM = "dataPostagem";
	public static final String IS_ESTORNO = "isEstorno";
	public static final String IS_OFFLINE = "isOffline";
	public static final String PESO_OBJETO = "pesoObjeto";
	public static final String NUMERO_FAIXA = "numeroFaixa";
	public static final String ID_PRODUTO_SERVICO = "idProdutoServico";

}

