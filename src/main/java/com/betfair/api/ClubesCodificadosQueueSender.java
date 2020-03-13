package com.betfair.api;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
@Component
public class ClubesCodificadosQueueSender {
 
    @Autowired
    private RabbitTemplate rabbitTemplate;
 
    @Autowired
    private Queue clubesCodificadosQueue;
 
    public void send(String partidasJson) {
        rabbitTemplate.convertAndSend(this.clubesCodificadosQueue.getName(), partidasJson);
    }
}
