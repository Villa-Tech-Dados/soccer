package br.com.correios.api.sara.atendimento.specification;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.correios.api.sara.atendimento.model.Atendimento;
import br.com.correios.api.sara.atendimento.model.Atendimento_;

@SuppressWarnings("serial")
public class AtendimentoSpecification implements Specification<Atendimento> {

	private Long id;
	private Long mcu;

	public AtendimentoSpecification(Long id, Long mcu) {
		super();
		this.id = id;
		this.mcu = mcu;
	}

	//Sem uso de lambda
//	private static Specification<Atendimento> isLongTermCustomer() {
//		return new Specification<Atendimento>() {
//			public Predicate toPredicate(Root<Atendimento> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
//				LocalDate date = null;//new LocalDate(0, 0, 0);
//				return builder.lessThan(root.get(Atendimento_.DATA_INICIO_EXECUCAO), date);
//			}
//		};
//	}

	public static Specification<Atendimento> whereMCU(Long mcu) {
		return (Root<Atendimento> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(Atendimento_.mcu), mcu);
		};
	}

	public static Specification<Atendimento> whereIsVigente() {
		return (Root<Atendimento> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			LocalDateTime dataAtual = LocalDateTime.now();
			dataAtual = dataAtual.minusDays(Integer.valueOf(30)); 
			return criteriaBuilder.greaterThanOrEqualTo(root.get(Atendimento_.dataInicioAtendimento), dataAtual);
		};
	}
	
	public static Specification<Atendimento> whereCaixa(List<Long> idCaixaList) {
		return (Root<Atendimento> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.isTrue(root.get(Atendimento_.numeroDoCaixa).in(idCaixaList));
		};
	}
	
	public static Specification<Atendimento> whereCaixa(Long idCaixa) {
		return (Root<Atendimento> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(Atendimento_.numeroDoCaixa), idCaixa);
		};
	}
	
	public static Specification<Atendimento> whereIsPendente() {
		return (Root<Atendimento> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.isNull(root.get(Atendimento_.dataFinalAtendimento));
		};
	}
	
	@Override
	public Predicate toPredicate(Root<Atendimento> root, CriteriaQuery<?> query,
			CriteriaBuilder criteriaBuilder) {
		final Collection<Predicate> predicates = new ArrayList<Predicate>();
		if (this.id != null) {
			Predicate p = criteriaBuilder.isTrue(root.get(Atendimento_.id).in(this.id));
			predicates.add(p);
		}

		if (this.mcu != null) {
			Predicate p = criteriaBuilder.equal(root.get(Atendimento_.mcu), mcu);
			predicates.add(p);
		}
		
		//Vigente
		LocalDateTime dataAtual = LocalDateTime.now();
		dataAtual = dataAtual.minusDays(Integer.valueOf(30)); 
		Predicate p =  criteriaBuilder.greaterThanOrEqualTo(root.get(Atendimento_.dataInicioAtendimento), dataAtual);
		predicates.add(p);
		
		Predicate[] array = predicates.toArray(new Predicate[predicates.size()]);

		return criteriaBuilder.and(array);
	}

}