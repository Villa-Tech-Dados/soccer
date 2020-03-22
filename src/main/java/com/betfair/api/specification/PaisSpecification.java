package com.betfair.api.specification;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.betfair.api.model.Pais;
import com.betfair.api.model.Pais_;

@SuppressWarnings("serial")
public class PaisSpecification implements Specification<Pais> {

	@PersistenceContext
	static EntityManager em;

	private Long id;
	private String nome;

	public PaisSpecification(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public static Specification<Pais> whereId(Long id) {
		return (Root<Pais> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(Pais_.id), id);
		};
	}

	private static Specification<Pais> whereNome(String nome) {
		return (Root<Pais> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(Pais_.nome), nome);
		};
	}
	
	@Override
	public Predicate toPredicate(Root<Pais> root, CriteriaQuery<?> query,
			CriteriaBuilder criteriaBuilder) {
		final Collection<Predicate> predicates = new ArrayList<Predicate>();
		if (this.id != null) {
			Predicate p = criteriaBuilder.isTrue(root.get(Pais_.id).in(this.id));
			predicates.add(p);
		}
		
		if (this.nome != null) {
			predicates.add(whereNome(this.nome).toPredicate(root, query, criteriaBuilder));
		}

		Predicate[] array = predicates.toArray(new Predicate[predicates.size()]);

		return criteriaBuilder.and(array);
	}

}