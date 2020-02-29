package br.com.correios.api.sara.atendimento.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.correios.api.sara.atendimento.model.ItemAtendimento;

@Repository
public interface ItemAtendimentoRepository extends JpaSpecificationExecutor<ItemAtendimento>, JpaRepository<ItemAtendimento, Integer>{
		
	public List<ItemAtendimento> findAll(Specification<ItemAtendimento> spec, Sort sort);

	public Optional<ItemAtendimento> findById(Long id);
}
