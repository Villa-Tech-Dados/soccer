package br.com.correios.api.sara.atendimento.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.betfair.api.soccer.model.Caixa;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Caixa.class)
public abstract class Caixa_ {

	public static volatile SingularAttribute<Caixa, Date> dataGeracaoRelatorio;
	public static volatile SingularAttribute<Caixa, Date> dataFechamentoCaixa;
	public static volatile SingularAttribute<Caixa, Boolean> isCaixaAberto;
	public static volatile SingularAttribute<Caixa, Long> numeroCaixaRetaguarda;
	public static volatile SingularAttribute<Caixa, Date> dataAberturaCaixa;
	public static volatile SingularAttribute<Caixa, Long> numeroUsuario;
	public static volatile SingularAttribute<Caixa, Long> numeroUsuarioReabertura;
	public static volatile SingularAttribute<Caixa, Boolean> isGuicheEmpresarial;
	public static volatile SingularAttribute<Caixa, Long> numeroSequencialAbertura;
	public static volatile SingularAttribute<Caixa, Long> id;
	public static volatile SingularAttribute<Caixa, Boolean> isControle;
	public static volatile SingularAttribute<Caixa, Long> numeroCaixaEstoque;
	public static volatile SingularAttribute<Caixa, Long> numeroSequencialAtendimento;

	public static final String DATA_GERACAO_RELATORIO = "dataGeracaoRelatorio";
	public static final String DATA_FECHAMENTO_CAIXA = "dataFechamentoCaixa";
	public static final String IS_CAIXA_ABERTO = "isCaixaAberto";
	public static final String NUMERO_CAIXA_RETAGUARDA = "numeroCaixaRetaguarda";
	public static final String DATA_ABERTURA_CAIXA = "dataAberturaCaixa";
	public static final String NUMERO_USUARIO = "numeroUsuario";
	public static final String NUMERO_USUARIO_REABERTURA = "numeroUsuarioReabertura";
	public static final String IS_GUICHE_EMPRESARIAL = "isGuicheEmpresarial";
	public static final String NUMERO_SEQUENCIAL_ABERTURA = "numeroSequencialAbertura";
	public static final String ID = "id";
	public static final String IS_CONTROLE = "isControle";
	public static final String NUMERO_CAIXA_ESTOQUE = "numeroCaixaEstoque";
	public static final String NUMERO_SEQUENCIAL_ATENDIMENTO = "numeroSequencialAtendimento";

}

