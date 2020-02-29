package br.com.correios.api.sara.atendimento.specification;

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

import br.com.correios.api.sara.atendimento.model.Caixa;
import br.com.correios.api.sara.atendimento.model.Caixa_;

@SuppressWarnings("serial")
public class CaixaSpecification implements Specification<Caixa> {

	@PersistenceContext
	static EntityManager em;

	private Long id;

	public CaixaSpecification(Long id) {
		super();
		this.id = id;
	}

	//Sem uso de lambda
//	private static Specification<Caixa> isLongTermCustomer() {
//		return new Specification<Caixa>() {
//			public Predicate toPredicate(Root<Caixa> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
//				LocalDate date = null;//new LocalDate(0, 0, 0);
//				return builder.lessThan(root.get(Caixa_.DATA_INICIO_EXECUCAO), date);
//			}
//		};
//	}

	public static Specification<Caixa> whereNumeroUsuario(Long numeroUsuario) {
		return (Root<Caixa> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(Caixa_.numeroUsuario), numeroUsuario);
		};
	}

	public static Specification<Caixa> whereCaixaIsAberto() {
		return (Root<Caixa> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(Caixa_.isCaixaAberto), true);
		};
	}
	
//	public static Specification<Caixa> whereIsCaixaVirtual(Boolean isCaixaVirtual) {
//		return (Root<Caixa> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
//			return criteriaBuilder.equal(root.get(Caixa_.isCaixaVirtual), isCaixaVirtual);
//		};
//	}
	
	public static Specification<Caixa> whereIsVigente() {
		return (Root<Caixa> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			LocalDateTime dataAtual = LocalDateTime.now();
			dataAtual = dataAtual.minusDays(30);
			Date dataVigencia = Date.from(dataAtual.atZone(ZoneId.systemDefault()).toInstant());
			return criteriaBuilder.greaterThanOrEqualTo(root.get(Caixa_.dataAberturaCaixa), dataVigencia);
		};
	}
	
	@Override
	public Predicate toPredicate(Root<Caixa> root, CriteriaQuery<?> query,
			CriteriaBuilder criteriaBuilder) {
		final Collection<Predicate> predicates = new ArrayList<Predicate>();
		if (this.id != null) {
			Predicate p = criteriaBuilder.isTrue(root.get(Caixa_.id).in(this.id));
			predicates.add(p);
		}

		Predicate[] array = predicates.toArray(new Predicate[predicates.size()]);

		return criteriaBuilder.and(array);
	}

}