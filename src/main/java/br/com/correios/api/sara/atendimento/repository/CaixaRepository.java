package br.com.correios.api.sara.atendimento.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.correios.api.sara.atendimento.model.Caixa;

@Repository
public interface CaixaRepository extends JpaSpecificationExecutor<Caixa>, JpaRepository<Caixa, Integer>{
		
	public List<Caixa> findAll(Specification<Caixa> spec, Sort sort);

	public Optional<Caixa> findById(Long id);
}
