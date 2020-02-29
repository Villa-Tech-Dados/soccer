package br.com.correios.api.suaapi.service;
//package br.com.correios.api.suaapi.service;
//
//import static org.hamcrest.Matchers.startsWith;
//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.BDDMockito.given;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.Optional;
//
//import org.hamcrest.core.IsNull;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import br.com.correios.api.sara_atendimento.enums.EstadoCivil;
//import br.com.correios.api.sara_atendimento.enums.Sexo;
//import br.com.correios.api.sara_atendimento.model.FaseCaptacao;
//import br.com.correios.api.sara_atendimento.repository.FaseCaptacaoRepository;
//import br.com.correios.api.sara_atendimento.service.FaseCaptacaoService;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ClienteServiceTest {
//	
//	
//	
//	@Autowired(required=true)
//	private FaseCaptacaoService clienteService;
//	
//	
//	
//	@MockBean
//	private FaseCaptacaoRepository clienteRepository;
//
//	
//	@Before
//    public void setUp() {
//		
//		FaseCaptacao c = new FaseCaptacao(
//				123456, "Jhon Connor" , LocalDate.of(2018, Month.APRIL, 10) ,Sexo.M , EstadoCivil.CASADO, null
//		);
//		
//		Optional<FaseCaptacao> optional = Optional.of(c);
//		
//		given(clienteRepository.findById(123))
//			.willReturn(optional);
//        
//        
//	}  
//	
////	@Test
////	public void testaConsultaDeClientesSexoM(){
////		Cliente cliente = new Cliente(null,null,null,Sexo.M,null,null);	
////		Optional<List<Cliente>> optional = clienteService.listaClientesPorFiltros(cliente, 1, 10);		
////		assertEquals("Lista nao esta vazia", true, optional.map( lista -> !lista.isEmpty()).orElse(false));
////		optional.map(lista -> lista).orElse(new ArrayList<Cliente>()).forEach(c -> {
////			assertEquals(Sexo.M, c.getSexo());
////		});
////	}
//	
////	@Test
////	public void testaConsultaMockada() {
////		Optional<FaseCaptacao> clienteOp = clienteService.consultaCliente(123);
////		assertTrue(clienteOp.isPresent());
////		assertThat(clienteOp.get().getNome(), startsWith("Jho"));
////		assertThat(clienteOp.get().getTelefone(), IsNull.nullValue());
////		
////	}
//	
////	@Test
////	public void testaConsultaDeClientesMasculinos(){
////		Cliente cliente = new Cliente(null, "tes%", null, "F", null, null, null);		
////		Optional<List<Cliente>> todos = clienteService.pesquisaClientesPorNomeSexoStatusCivil(cliente);
////		assertEquals(true, todos.get().size() > 0);	
////		assertThat(todos.get().get(0).getNome().toLowerCase(), startsWith("tes"));
////	}
//
//}
