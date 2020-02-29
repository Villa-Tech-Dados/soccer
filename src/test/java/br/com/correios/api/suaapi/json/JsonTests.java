//package br.com.correios.api.suaapi.json;
//
//
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.Month;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.json.JsonTest;
//import org.springframework.boot.test.json.JacksonTester;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import br.com.correios.api.commons.exception.MessageResponse;
//import br.com.correios.api.sara_atendimento.enums.EstadoCivil;
//import br.com.correios.api.sara_atendimento.enums.Sexo;
//import br.com.correios.api.sara_atendimento.model.FaseCaptacao;
//
//
//@RunWith(SpringRunner.class)
//@JsonTest
//public class JsonTests {
//	
//	private Logger log = LoggerFactory.getLogger(JsonTests.class);
//	
//	@Autowired
//	private JacksonTester<FaseCaptacao> jsonCliente;
//	
//	@Autowired
//	private JacksonTester<MessageResponse> jsonMessageResponse;
//	
//	
//	@Test
//	public void testaSerializacaoMessage() throws IOException {
//		MessageResponse msg = new MessageResponse();
//		msg.setCausa("java.lang.NullPointerException");
//		msg.setDate(LocalDateTime.of(2018, Month.JANUARY, 3, 22, 6, 1));
////		msg.setExcecao("java.lang.NullPointerException");
//		msg.setPath("/teste/erro/json");
//		msg.setUser("80131085");
//		log.info("Json serializado: {}", jsonMessageResponse.write(msg).getJson());
//		assertThat(jsonMessageResponse.write(msg)).hasJsonPathStringValue("@.causa");
//		assertThat(jsonMessageResponse.write(msg)).extractingJsonPathStringValue("@.causa").isEqualTo("java.lang.NullPointerException");
//		assertThat(jsonMessageResponse.write(msg)).extractingJsonPathStringValue("@.date").isEqualTo("2018-01-03T22:06:01");
//		assertThat(jsonMessageResponse.write(msg)).doesNotHaveJsonPathValue("@.stacktrace");
//		
//	}
//	
//	
//	@Test
//	public void testaSerializacaoCliente() throws IOException {
//		FaseCaptacao c = new FaseCaptacao(
//				123456, "Jhon Connor" , LocalDate.of(2018, Month.APRIL, 10) ,Sexo.M , EstadoCivil.CASADO, null
//		);
//		
//		log.info("Json serializado: {}", jsonCliente.write(c).getJson());
//		assertThat(jsonCliente.write(c)).hasJsonPathNumberValue("@.numero");
//		assertThat(jsonCliente.write(c)).extractingJsonPathStringValue("@.nome").isEqualTo("Jhon Connor");
//		assertThat(jsonCliente.write(c)).extractingJsonPathStringValue("@.dataNascimento").isEqualTo("2018-04-10");
//		assertThat(jsonCliente.write(c)).doesNotHaveJsonPathValue("@.telefone");
//		
//	}
//			
//
//}
