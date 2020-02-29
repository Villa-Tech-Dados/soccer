package br.com.correios.api.sara.atendimento.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, Long> numeroFuncionarioExterno;
	public static volatile SingularAttribute<Usuario, Boolean> isUsuarioVirtual;
	public static volatile SingularAttribute<Usuario, Date> dataAlteracaoSenha2;
	public static volatile SingularAttribute<Usuario, Date> dataAlteracaoUsuario;
	public static volatile SingularAttribute<Usuario, Boolean> isAlterarSenha;
	public static volatile SingularAttribute<Usuario, Long> numeroFuncionarioCorreios;
	public static volatile SingularAttribute<Usuario, Integer> quantidadeTentativaLogin;
	public static volatile SingularAttribute<Usuario, Boolean> isAtivo;
	public static volatile SingularAttribute<Usuario, Long> tipoPerfil;
	public static volatile SingularAttribute<Usuario, Date> dataAlteracaoSenha;
	public static volatile SingularAttribute<Usuario, String> senhaCriptografada;
	public static volatile SingularAttribute<Usuario, Long> id;
	public static volatile SingularAttribute<Usuario, Long> idOrgaoCorreios;
	public static volatile SingularAttribute<Usuario, Date> dataCadastro;

	public static final String NUMERO_FUNCIONARIO_EXTERNO = "numeroFuncionarioExterno";
	public static final String IS_USUARIO_VIRTUAL = "isUsuarioVirtual";
	public static final String DATA_ALTERACAO_SENHA2 = "dataAlteracaoSenha2";
	public static final String DATA_ALTERACAO_USUARIO = "dataAlteracaoUsuario";
	public static final String IS_ALTERAR_SENHA = "isAlterarSenha";
	public static final String NUMERO_FUNCIONARIO_CORREIOS = "numeroFuncionarioCorreios";
	public static final String QUANTIDADE_TENTATIVA_LOGIN = "quantidadeTentativaLogin";
	public static final String IS_ATIVO = "isAtivo";
	public static final String TIPO_PERFIL = "tipoPerfil";
	public static final String DATA_ALTERACAO_SENHA = "dataAlteracaoSenha";
	public static final String SENHA_CRIPTOGRAFADA = "senhaCriptografada";
	public static final String ID = "id";
	public static final String ID_ORGAO_CORREIOS = "idOrgaoCorreios";
	public static final String DATA_CADASTRO = "dataCadastro";

}

