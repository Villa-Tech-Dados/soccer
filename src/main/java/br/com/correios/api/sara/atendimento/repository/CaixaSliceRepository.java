package br.com.correios.api.sara.atendimento.repository;

import br.com.correios.api.commons.repository.SlicePagingRepository;
import br.com.correios.api.sara.atendimento.model.Caixa;

@org.springframework.stereotype.Repository
public class CaixaSliceRepository extends SlicePagingRepository<Caixa> {
	    
    public CaixaSliceRepository() {
        super(Caixa.class);
    }   
	
}
