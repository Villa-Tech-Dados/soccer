package br.com.correios.api.sara.atendimento.specification;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.correios.api.sara.atendimento.model.ItemAtendimento;
import br.com.correios.api.sara.atendimento.model.ItemAtendimento_;

@SuppressWarnings("serial")
public class ItemAtendimentoSpecification implements Specification<ItemAtendimento> {

	@PersistenceContext
	static EntityManager em;

	private Long id;

	public ItemAtendimentoSpecification(Long id) {
		super();
		this.id = id;
	}

	public static Specification<ItemAtendimento> whereMCU(Long mcu) {
		return (Root<ItemAtendimento> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(ItemAtendimento_.idAgencia), mcu);
		};
	}

	public static Specification<ItemAtendimento> whereAtendimento(List<Long> idAtendimentoList) {
		return (Root<ItemAtendimento> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.isTrue(root.get(ItemAtendimento_.idAtendimento).in(idAtendimentoList));
		};
	}
	
	public static Specification<ItemAtendimento> whereIsVigente() {
		return (Root<ItemAtendimento> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			LocalDateTime dataAtual = LocalDateTime.now();
			dataAtual = dataAtual.minusDays(30);
			Date dataVigencia = Date.from(dataAtual.atZone(ZoneId.systemDefault()).toInstant());
			return criteriaBuilder.greaterThanOrEqualTo(root.get(ItemAtendimento_.dataHoraInicioAtendimento), dataVigencia);
		};
	}
	
	@Override
	public Predicate toPredicate(Root<ItemAtendimento> root, CriteriaQuery<?> query,
			CriteriaBuilder criteriaBuilder) {
		final Collection<Predicate> predicates = new ArrayList<Predicate>();
		if (this.id != null) {
			Predicate p = criteriaBuilder.isTrue(root.get(ItemAtendimento_.id).in(this.id));
			predicates.add(p);
		}

		Predicate[] array = predicates.toArray(new Predicate[predicates.size()]);

		return criteriaBuilder.and(array);
	}

}