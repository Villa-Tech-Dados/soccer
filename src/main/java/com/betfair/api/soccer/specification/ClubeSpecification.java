package com.betfair.api.soccer.specification;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.betfair.api.soccer.model.Clube;


@SuppressWarnings("serial")
public class ClubeSpecification implements Specification<Clube> {

	private Long id;
	private Long mcu;

	public ClubeSpecification(Long id, Long mcu) {
		super();
		this.id = id;
		this.mcu = mcu;
	}

	//Sem uso de lambda
//	private static Specification<Clube> isLongTermCustomer() {
//		return new Specification<Clube>() {
//			public Predicate toPredicate(Root<Clube> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
//				LocalDate date = null;//new LocalDate(0, 0, 0);
//				return builder.lessThan(root.get(Clube_.DATA_INICIO_EXECUCAO), date);
//			}
//		};
//	}

	public static Specification<Clube> whereMCU(Long mcu) {
		return (Root<Clube> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(Clube_.mcu), mcu);
		};
	}

	public static Specification<Clube> whereIsVigente() {
		return (Root<Clube> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			LocalDateTime dataAtual = LocalDateTime.now();
			dataAtual = dataAtual.minusDays(Integer.valueOf(30)); 
			return criteriaBuilder.greaterThanOrEqualTo(root.get(Clube_.dataInicioClube), dataAtual);
		};
	}
	
	public static Specification<Clube> whereCaixa(List<Long> idCaixaList) {
		return (Root<Clube> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.isTrue(root.get(Clube_.numeroDoCaixa).in(idCaixaList));
		};
	}
	
	public static Specification<Clube> whereCaixa(Long idCaixa) {
		return (Root<Clube> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(Clube_.numeroDoCaixa), idCaixa);
		};
	}
	
	public static Specification<Clube> whereIsPendente() {
		return (Root<Clube> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.isNull(root.get(Clube_.dataFinalClube));
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

		if (this.mcu != null) {
			Predicate p = criteriaBuilder.equal(root.get(Clube_.mcu), mcu);
			predicates.add(p);
		}
		
		//Vigente
		LocalDateTime dataAtual = LocalDateTime.now();
		dataAtual = dataAtual.minusDays(Integer.valueOf(30)); 
		Predicate p =  criteriaBuilder.greaterThanOrEqualTo(root.get(Clube_.dataInicioClube), dataAtual);
		predicates.add(p);
		
		Predicate[] array = predicates.toArray(new Predicate[predicates.size()]);

		return criteriaBuilder.and(array);
	}

}