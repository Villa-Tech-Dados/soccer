package br.com.correios.api.sara.atendimento.repository;

import br.com.correios.api.commons.repository.SlicePagingRepository;
import br.com.correios.api.sara.atendimento.model.Usuario;

@org.springframework.stereotype.Repository
public class UsuarioSliceRepository extends SlicePagingRepository<Usuario> {
	    
    public UsuarioSliceRepository() {
        super(Usuario.class);
    }   
	
}
