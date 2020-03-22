package com.betfair.api.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Partida.class)
public abstract class Partida_ {

	public static volatile SingularAttribute<Partida, Long> gols_clube_fora;
	public static volatile SingularAttribute<Partida, Double> odd_casa;
	public static volatile SingularAttribute<Partida, Long> gols_clube_casa;
	public static volatile SingularAttribute<Partida, Long> id_clube_casa;
	public static volatile SingularAttribute<Partida, Double> odd_fora;
	public static volatile SingularAttribute<Partida, Date> data_hora;
	public static volatile SingularAttribute<Partida, Long> id_clube_fora;
	public static volatile SingularAttribute<Partida, Long> id;
	public static volatile SingularAttribute<Partida, Long> id_liga;
	public static volatile SingularAttribute<Partida, Double> odd_empate;

}

