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

import br.com.correios.api.sara.atendimento.model.Atendimento;

@Repository
public interface AtendimentoRepository extends JpaSpecificationExecutor<Atendimento>, JpaRepository<Atendimento, Integer>{
		
	public List<Atendimento> findAll(Specification<Atendimento> spec, Sort sort);

	public Optional<Atendimento> findById(Long id);

//	@Query(value = "SELECT new String ogp.etiqueta "
//			+ " FROM ObjetoAtendimento ogp "
//			+ " WHERE ogp.numeroAgenciaOrigem =  ?1"
//			+ " AND ogp.dataCadastro >= ?2", nativeQuery = false )
//	public List<String> findAllSelectEtiqueta(@Param("mcu") Long mcu, @Param("dataCadastro") Date dataVigencia);
	
}
