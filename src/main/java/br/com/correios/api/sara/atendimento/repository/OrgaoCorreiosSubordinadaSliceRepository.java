package br.com.correios.api.sara.atendimento.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.domain.Specification;

import br.com.correios.api.commons.repository.SlicePagingRepository;
import br.com.correios.api.sara.atendimento.model.OrgaoCorreios;
import br.com.correios.api.sara.atendimento.model.OrgaoCorreiosSubordinada;

@org.springframework.stereotype.Repository
public class OrgaoCorreiosSubordinadaSliceRepository extends SlicePagingRepository<OrgaoCorreiosSliceRepository> {
	    
    public OrgaoCorreiosSubordinadaSliceRepository() {
        super(OrgaoCorreiosSliceRepository.class);
    }
	
}
