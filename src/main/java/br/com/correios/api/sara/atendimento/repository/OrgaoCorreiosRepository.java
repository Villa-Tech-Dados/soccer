package br.com.correios.api.sara.atendimento.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.correios.api.sara.atendimento.model.OrgaoCorreios;

@Repository
public interface OrgaoCorreiosRepository extends JpaSpecificationExecutor<OrgaoCorreios>, JpaRepository<OrgaoCorreios, Integer>{
		
	public List<OrgaoCorreios> findAll(Specification<OrgaoCorreios> spec, Sort sort);

	public Optional<OrgaoCorreios> findById(Long id);
}
