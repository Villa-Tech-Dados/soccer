package br.com.correios.api.sara_grandepostagem.controler;
//package br.com.correios.api.suaapi.controler;
//
//import static org.hamcrest.CoreMatchers.startsWith;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
////@ActiveProfiles("local")
//public class ClientesControlerTest {
//	
//	@Autowired
//	private MockMvc mvc;
//	
//	@Test
//	public void testListaClientesSemParametros() throws Exception {
////		ResultMatcher json = content().json("{\"nome\": \"ARIVALDO TESTE 1\"}]}", false);
//		MockHttpServletRequestBuilder request = get("/v1/clientes/page");
//		mvc.perform(request)
//		   .andExpect(status().isOk())
//		   .andExpect(jsonPath("@.itens").exists())
//		   .andExpect(jsonPath("@.links").exists())
//		   .andExpect(jsonPath("@.page").exists())
//	       .andExpect(jsonPath("@.page.number").value("0"));
//	}
//
//	@Test
//	public void testListaClientes() throws Exception {
////		ResultMatcher json = content().json("{\"nome\": \"ARIVALDO TESTE 1\"}]}", false);
//		MockHttpServletRequestBuilder request = get("/v1/clientes?nome=Claiton");
//		ResultActions result = mvc.perform(request);
//		result.andExpect(status().isOk())
////		      .andExpect(json)
//	     	  .andExpect(jsonPath("@.itens.[0].nome").value(startsWith("CLAITON 1")));
//	}
//	
//	@Test
//	public void testConsultaCliente() throws Exception {
//		mvc.perform(get("/v1/clientes/88849393")).andExpect(status().isOk()).andExpect(content().json("{\"nome\": \"ARIVALDO GONÇALVES DE FREITAS\"}", false));
//	}
//
//}
