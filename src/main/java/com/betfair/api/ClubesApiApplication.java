package com.betfair.api;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaAuditing
public class ClubesApiApplication {

	@Value("${queue.clubes.codificados.name}")
    private String clubesCodificadosQueue;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
    public Queue clubesCodificadosQueue() {
        return new Queue(clubesCodificadosQueue, true);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ClubesApiApplication.class, args);
	}

}

