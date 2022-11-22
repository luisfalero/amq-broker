package com.lfalero.amqp.consumerentity.consumer;

import com.lfalero.amqp.consumerentity.model.entity.PersonEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JmsConsumer {

    @JmsListener(destination = "${jms.queue.destination}")
    public void receive(Message message){

        log.info("Message Payload = [{}]:", message.getPayload());

        if (message.getPayload() instanceof String){
            log.info("Recieved Message String = [{}]:", message.getPayload().toString());

        } else if (message.getPayload() instanceof PersonEntity){
            log.info("Recieved Message Entity = [{}]:", message.getPayload().toString());

        } else {
            System.err.println("Message Type Unkown !");
            log.info("Message Type Unkown !");
        }
    }
}
