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

import br.com.correios.api.sara.atendimento.model.OrgaoCorreios;
import br.com.correios.api.sara.atendimento.model.OrgaoCorreios_;

@SuppressWarnings("serial")
public class OrgaoCorreiosSpecification implements Specification<OrgaoCorreios> {

	@PersistenceContext
	static EntityManager em;

	private Long id;

	public OrgaoCorreiosSpecification(Long id) {
		super();
		this.id = id;
	}

	//Sem uso de lambda
//	private static Specification<OrgaoCorreios> isLongTermCustomer() {
//		return new Specification<OrgaoCorreios>() {
//			public Predicate toPredicate(Root<OrgaoCorreios> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
//				LocalDate date = null;//new LocalDate(0, 0, 0);
//				return builder.lessThan(root.get(OrgaoCorreios_.DATA_INICIO_EXECUCAO), date);
//			}
//		};
//	}

	public static Specification<OrgaoCorreios> whereMCU(Long mcu) {
		return (Root<OrgaoCorreios> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(OrgaoCorreios_.mcu), mcu);
		};
	}

	public static Specification<OrgaoCorreios> whereIsCaptacaoAutomaticaAtivado(Boolean isAtivado) {
		return (Root<OrgaoCorreios> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(OrgaoCorreios_.isCaptacaoAutomaticaAtivado), isAtivado);
		};
	}
	
//	public static Specification<OrgaoCorreios> whereIsPlpVigente() {
//		return (Root<OrgaoCorreios> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
//			LocalDateTime dataAtual = LocalDateTime.now();
//			dataAtual = dataAtual.minusDays(8);
//			Date dataVigencia = Date.from(dataAtual.atZone(ZoneId.systemDefault()).toInstant());
//			return criteriaBuilder.greaterThanOrEqualTo(root.get(OrgaoCorreios_.dataInicioOrgaoCorreios), dataVigencia);
//		};
//	}
	
	@Override
	public Predicate toPredicate(Root<OrgaoCorreios> root, CriteriaQuery<?> query,
			CriteriaBuilder criteriaBuilder) {
		final Collection<Predicate> predicates = new ArrayList<Predicate>();
		if (this.id != null) {
			Predicate p = criteriaBuilder.isTrue(root.get(OrgaoCorreios_.id).in(this.id));
			predicates.add(p);
		}

		Predicate[] array = predicates.toArray(new Predicate[predicates.size()]);

		return criteriaBuilder.and(array);
	}

}