package com.betfair.api.specification;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.betfair.api.model.Partida;
import com.betfair.api.model.Partida_;

@SuppressWarnings("serial")
public class PartidaSpecification implements Specification<Partida> {

	@PersistenceContext
	static EntityManager em;

	private Long id;
	private String nome;

	public PartidaSpecification(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public static Specification<Partida> whereId(Long id) {
		return (Root<Partida> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(Partida_.id), id);
		};
	}

	private static Specification<Partida> whereNome(Long id_time_casa) {
		return (Root<Partida> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(Partida_.id_time_casa), id_time_casa);
		};
	}
	
	@Override
	public Predicate toPredicate(Root<Partida> root, CriteriaQuery<?> query,
			CriteriaBuilder criteriaBuilder) {
		final Collection<Predicate> predicates = new ArrayList<Predicate>();
		if (this.id != null) {
			Predicate p = criteriaBuilder.isTrue(root.get(Partida_.id).in(this.id));
			predicates.add(p);
		}
		

		Predicate[] array = predicates.toArray(new Predicate[predicates.size()]);

		return criteriaBuilder.and(array);
	}

}