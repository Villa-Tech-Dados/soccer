package br.com.correios.api.sara.atendimento.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Atendimento.class)
public abstract class Atendimento_ {

	public static volatile SingularAttribute<Atendimento, String> numeroLoteFaturamento;
	public static volatile SingularAttribute<Atendimento, Long> numeroFuncionario;
	public static volatile SingularAttribute<Atendimento, Long> numeroStoAcf;
	public static volatile SingularAttribute<Atendimento, BigDecimal> valorTotalDesconto;
	public static volatile SingularAttribute<Atendimento, BigDecimal> valorTotalFranqueamento;
	public static volatile SingularAttribute<Atendimento, BigDecimal> valorTotalAtendimento;
	public static volatile SingularAttribute<Atendimento, Boolean> isEstornado;
	public static volatile SingularAttribute<Atendimento, Long> idAtendimentoDeEstorno;
	public static volatile SingularAttribute<Atendimento, Long> numeroAtendimentoFuncionario;
	public static volatile SingularAttribute<Atendimento, Long> numeroDoCaixa;
	public static volatile SingularAttribute<Atendimento, LocalDateTime> dataImportacaoErp;
	public static volatile SingularAttribute<Atendimento, Long> numeroSF;
	public static volatile SingularAttribute<Atendimento, Long> numeroModalidadePagamento;
	public static volatile SingularAttribute<Atendimento, Long> numeroNotaFiscal;
	public static volatile SingularAttribute<Atendimento, Long> numeroCartaoPostagem;
	public static volatile SingularAttribute<Atendimento, Long> sequencialAtendimentoCaixa;
	public static volatile SingularAttribute<Atendimento, Long> quantidadeRequisicaoSF;
	public static volatile SingularAttribute<Atendimento, Long> id;
	public static volatile SingularAttribute<Atendimento, Long> numeroDoContrato;
	public static volatile SingularAttribute<Atendimento, Boolean> isCategoriaPrecoDefinido;
	public static volatile SingularAttribute<Atendimento, Long> mcu;
	public static volatile SingularAttribute<Atendimento, Boolean> isAtendidoOffline;
	public static volatile SingularAttribute<Atendimento, Boolean> isImportacao;
	public static volatile SingularAttribute<Atendimento, Boolean> isOrigemAtendimento;
	public static volatile SingularAttribute<Atendimento, Boolean> isNumeroFaturaCliente;
	public static volatile SingularAttribute<Atendimento, BigDecimal> valorTotalIsencao;
	public static volatile SingularAttribute<Atendimento, LocalDateTime> dataFinalAtendimento;
	public static volatile SingularAttribute<Atendimento, BigDecimal> valorTotalTaxa;
	public static volatile SingularAttribute<Atendimento, Long> numeroDocumentoPostagem;
	public static volatile SingularAttribute<Atendimento, LocalDateTime> dataInicioAtendimento;
	public static volatile SingularAttribute<Atendimento, Long> numeroDoCliente;

	public static final String NUMERO_LOTE_FATURAMENTO = "numeroLoteFaturamento";
	public static final String NUMERO_FUNCIONARIO = "numeroFuncionario";
	public static final String NUMERO_STO_ACF = "numeroStoAcf";
	public static final String VALOR_TOTAL_DESCONTO = "valorTotalDesconto";
	public static final String VALOR_TOTAL_FRANQUEAMENTO = "valorTotalFranqueamento";
	public static final String VALOR_TOTAL_ATENDIMENTO = "valorTotalAtendimento";
	public static final String IS_ESTORNADO = "isEstornado";
	public static final String ID_ATENDIMENTO_DE_ESTORNO = "idAtendimentoDeEstorno";
	public static final String NUMERO_ATENDIMENTO_FUNCIONARIO = "numeroAtendimentoFuncionario";
	public static final String NUMERO_DO_CAIXA = "numeroDoCaixa";
	public static final String DATA_IMPORTACAO_ERP = "dataImportacaoErp";
	public static final String NUMERO_SF = "numeroSF";
	public static final String NUMERO_MODALIDADE_PAGAMENTO = "numeroModalidadePagamento";
	public static final String NUMERO_NOTA_FISCAL = "numeroNotaFiscal";
	public static final String NUMERO_CARTAO_POSTAGEM = "numeroCartaoPostagem";
	public static final String SEQUENCIAL_ATENDIMENTO_CAIXA = "sequencialAtendimentoCaixa";
	public static final String QUANTIDADE_REQUISICAO_SF = "quantidadeRequisicaoSF";
	public static final String ID = "id";
	public static final String NUMERO_DO_CONTRATO = "numeroDoContrato";
	public static final String IS_CATEGORIA_PRECO_DEFINIDO = "isCategoriaPrecoDefinido";
	public static final String MCU = "mcu";
	public static final String IS_ATENDIDO_OFFLINE = "isAtendidoOffline";
	public static final String IS_IMPORTACAO = "isImportacao";
	public static final String IS_ORIGEM_ATENDIMENTO = "isOrigemAtendimento";
	public static final String IS_NUMERO_FATURA_CLIENTE = "isNumeroFaturaCliente";
	public static final String VALOR_TOTAL_ISENCAO = "valorTotalIsencao";
	public static final String DATA_FINAL_ATENDIMENTO = "dataFinalAtendimento";
	public static final String VALOR_TOTAL_TAXA = "valorTotalTaxa";
	public static final String NUMERO_DOCUMENTO_POSTAGEM = "numeroDocumentoPostagem";
	public static final String DATA_INICIO_ATENDIMENTO = "dataInicioAtendimento";
	public static final String NUMERO_DO_CLIENTE = "numeroDoCliente";

}

