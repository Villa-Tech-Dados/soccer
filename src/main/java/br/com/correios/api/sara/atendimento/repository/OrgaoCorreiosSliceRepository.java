package br.com.correios.api.sara.atendimento.repository;

import br.com.correios.api.commons.repository.SlicePagingRepository;
import br.com.correios.api.sara.atendimento.model.OrgaoCorreios;

@org.springframework.stereotype.Repository
public class OrgaoCorreiosSliceRepository extends SlicePagingRepository<OrgaoCorreios> {
	    
    public OrgaoCorreiosSliceRepository() {
        super(OrgaoCorreios.class);
    }   
	
}
