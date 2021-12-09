package br.com.systemsgs.consumer.controller;

import br.com.systemsgs.consumer.model.ModelMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsumerController {

    @RabbitListener(queues = "queue.A")
    private void receiveA(ModelMessage modelMessage){
        log.info("Mensagem recebida queue A ->{}", modelMessage);
    }

    @RabbitListener(queues = "queue.B")
    private void receiveB(ModelMessage modelMessage){
        log.info("Mensagem recebida queue B ->{}", modelMessage);
    }

}
