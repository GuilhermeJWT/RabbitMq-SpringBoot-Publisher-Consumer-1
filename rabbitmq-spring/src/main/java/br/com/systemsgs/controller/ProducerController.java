package br.com.systemsgs.controller;

import br.com.systemsgs.model.ModelMessage;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange fanoutExchange;

    @PostMapping(value = "/enviar")
    public String envia(ModelMessage modelMessage){
        rabbitTemplate.convertAndSend(fanoutExchange.getName(),  modelMessage);

        return "Mensagem Enviada com Sucesso!";
    }

}
