package com.betfair.api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.betfair.api.controller.ClubeController;
import com.betfair.api.model.Clube;
import com.betfair.api.model.Pais;
import com.betfair.api.service.ClubeService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;
 
@Component
public class CodificarClubesQueueConsumer {

	@Autowired
	private ClubeController clubeController;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	ClubesCodificadosQueueSender clubesCodificadosQueueSender;
	
	private String betfairApiPaisesUrl = "${componentes.betfair.api.paises.url}";
	
    @RabbitListener(queues = {"${queue.clubes.codificar.name}"})
    public void receive(@Payload String partidas) throws Exception {
		System.out.println("BetfairAPI - Consumindo da fila CodificarClubesQueue");
		System.out.println(partidas);
		JSONArray jSONArray = new JSONArray(partidas);
		JSONArray jSONArrayRetorno = new JSONArray();
		for(Object partidaArray: jSONArray) {
			JSONObject partida = new JSONObject(partidaArray.toString());
			
			String timeForaNome =  partida.getString("time_fora");
			Clube timeFora = clubeController.findByPlace(timeForaNome);
			if (timeFora == null) {
				String pais = partida.getString("pais");
				Long paisId = this.obterPaisId(pais);
				timeFora = new Clube();
				timeFora.setPais(paisId);
				timeFora.setNome(timeForaNome);
				timeFora = clubeController.create(timeFora);
				partida.put("id", timeFora.getId());
			}
			
			String timeCasaNome =  partida.getString("time_casa");
			Clube timeCasa = clubeController.findByPlace(timeCasaNome);
			if (timeCasa == null) {
				String pais = partida.getString("pais");
				Long paisId = this.obterPaisId(pais);
				timeCasa= new Clube();
				timeCasa.setPais(paisId);
				timeCasa.setNome(timeCasaNome);
				timeCasa = clubeController.create(timeCasa);
				partida.put("id", timeCasa.getId());
			}
			jSONArrayRetorno.put(partida);
		}
		clubesCodificadosQueueSender.send(jSONArrayRetorno.toString());
		System.out.println(jSONArrayRetorno.toString() +  "\n" + "enviado para a fila ClubesCodificadosQueue");
    }

	private Long obterPaisId(String pais) throws URISyntaxException {
		JSONObject paisREST;
		String paisRESTString = restTemplate.getForObject(betfairApiPaisesUrl + "find/" + pais, String.class);
		if(paisRESTString == null) { //Pais nao existe
			HttpHeaders headers = new HttpHeaders();
			URI uri = new URI(betfairApiPaisesUrl);
			Pais paisRequest = new Pais(pais);
            HttpEntity<Pais> request = new HttpEntity<Pais>( paisRequest, headers);
            Pais response = restTemplate.postForObject(uri, request, Pais.class);
            
			paisREST = new JSONObject(response);
		}else {
			paisREST = new JSONObject(paisRESTString);
		}
		return new Long(paisREST.getLong("id"));
	}
}