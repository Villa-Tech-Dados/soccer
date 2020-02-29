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

import br.com.correios.api.sara.atendimento.model.Usuario;
import br.com.correios.api.sara.atendimento.model.Usuario_;

@SuppressWarnings("serial")
public class UsuarioSpecification implements Specification<Usuario> {

	@PersistenceContext
	static EntityManager em;

	private Long id;

	public UsuarioSpecification(Long id) {
		super();
		this.id = id;
	}

	//Sem uso de lambda
//	private static Specification<Usuario> isLongTermCustomer() {
//		return new Specification<Usuario>() {
//			public Predicate toPredicate(Root<Usuario> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
//				LocalDate date = null;//new LocalDate(0, 0, 0);
//				return builder.lessThan(root.get(Usuario_.DATA_INICIO_EXECUCAO), date);
//			}
//		};
//	}

	public static Specification<Usuario> whereMCU(Long mcu) {
		return (Root<Usuario> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(Usuario_.idOrgaoCorreios), mcu);
		};
	}

	public static Specification<Usuario> whereIsUsuarioVirtual(Boolean isUsuarioVirtual) {
		return (Root<Usuario> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(Usuario_.isUsuarioVirtual), isUsuarioVirtual);
		};
	}
	
//	public static Specification<Usuario> whereIsPlpVigente() {
//		return (Root<Usuario> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
//			LocalDateTime dataAtual = LocalDateTime.now();
//			dataAtual = dataAtual.minusDays(8);
//			Date dataVigencia = Date.from(dataAtual.atZone(ZoneId.systemDefault()).toInstant());
//			return criteriaBuilder.greaterThanOrEqualTo(root.get(Usuario_.dataInicioUsuario), dataVigencia);
//		};
//	}
	
	@Override
	public Predicate toPredicate(Root<Usuario> root, CriteriaQuery<?> query,
			CriteriaBuilder criteriaBuilder) {
		final Collection<Predicate> predicates = new ArrayList<Predicate>();
		if (this.id != null) {
			Predicate p = criteriaBuilder.isTrue(root.get(Usuario_.id).in(this.id));
			predicates.add(p);
		}

		Predicate[] array = predicates.toArray(new Predicate[predicates.size()]);

		return criteriaBuilder.and(array);
	}

}