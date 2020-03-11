package com.betfair.api.soccer.specification;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.betfair.api.soccer.model.Clube;
import com.betfair.api.soccer.model.Clube_;



@SuppressWarnings("serial")
public class ClubeSpecification implements Specification<Clube> {

	private Long id;

	public ClubeSpecification(Long id) {
		super();
		this.id = id;
	}

	public static Specification<Clube> whereNome(String nome) {
		return (Root<Clube> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(Clube_.nome), nome);
		};
	}
	
	@Override
	public Predicate toPredicate(Root<Clube> root, CriteriaQuery<?> query,
			CriteriaBuilder criteriaBuilder) {
		final Collection<Predicate> predicates = new ArrayList<Predicate>();
		if (this.id != null) {
			Predicate p = criteriaBuilder.isTrue(root.get(Clube_.id).in(this.id));
			predicates.add(p);
		}

		Predicate[] array = predicates.toArray(new Predicate[predicates.size()]);

		return criteriaBuilder.and(array);
	}

}