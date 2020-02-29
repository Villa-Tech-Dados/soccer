package br.com.correios.api.sara.atendimento.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.correios.api.sara.atendimento.model.OrgaoCorreiosSubordinada;

@Repository
public interface OrgaoCorreiosSubordinadaRepository extends JpaSpecificationExecutor<OrgaoCorreiosSubordinada>, JpaRepository<OrgaoCorreiosSubordinada, Integer>{
		
	public List<OrgaoCorreiosSubordinada> findAll(Specification<OrgaoCorreiosSubordinada> spec, Sort sort);

	public Optional<OrgaoCorreiosSubordinada> findById(Long id);
}
