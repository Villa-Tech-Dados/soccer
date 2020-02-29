package br.com.correios.api.sara.atendimento.repository;

import br.com.correios.api.commons.repository.SlicePagingRepository;
import br.com.correios.api.sara.atendimento.model.ItemAtendimento;

@org.springframework.stereotype.Repository
public class ItemAtendimentoSliceRepository extends SlicePagingRepository<ItemAtendimento> {
	    
    public ItemAtendimentoSliceRepository() {
        super(ItemAtendimento.class);
    }   
	
}
