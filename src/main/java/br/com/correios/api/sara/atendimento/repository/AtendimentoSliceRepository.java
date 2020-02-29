package br.com.correios.api.sara.atendimento.repository;

import br.com.correios.api.commons.repository.SlicePagingRepository;
import br.com.correios.api.sara.atendimento.model.Atendimento;

@org.springframework.stereotype.Repository
public class AtendimentoSliceRepository extends SlicePagingRepository<Atendimento> {
	    
    public AtendimentoSliceRepository() {
        super(Atendimento.class);
    }   
	
}
