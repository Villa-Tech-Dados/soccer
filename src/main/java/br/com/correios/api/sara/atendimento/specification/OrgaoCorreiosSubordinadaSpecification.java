package br.com.correios.api.sara.atendimento.specification;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.correios.api.sara.atendimento.model.OrgaoCorreiosSubordinada;
import br.com.correios.api.sara.atendimento.model.OrgaoCorreiosSubordinada_;

@SuppressWarnings("serial")
public class OrgaoCorreiosSubordinadaSpecification implements Specification<OrgaoCorreiosSubordinada> {

	@PersistenceContext
	static EntityManager em;

	private Long id;

	public OrgaoCorreiosSubordinadaSpecification(Long id) {
		super();
		this.id = id;
	}


	public static Specification<OrgaoCorreiosSubordinada> whereIdSubordinada(Long mcu) {
		return (Root<OrgaoCorreiosSubordinada> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(OrgaoCorreiosSubordinada_.idSubordinada), mcu);
		};
	}

	@Override
	public Predicate toPredicate(Root<OrgaoCorreiosSubordinada> root, CriteriaQuery<?> query,
			CriteriaBuilder criteriaBuilder) {
		final Collection<Predicate> predicates = new ArrayList<Predicate>();
		if (this.id != null) {
			Predicate p = criteriaBuilder.isTrue(root.get(OrgaoCorreiosSubordinada_.id).in(this.id));
			predicates.add(p);
		}

		Predicate[] array = predicates.toArray(new Predicate[predicates.size()]);

		return criteriaBuilder.and(array);
	}

}