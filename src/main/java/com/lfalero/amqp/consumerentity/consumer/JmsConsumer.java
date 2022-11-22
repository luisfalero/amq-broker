package com.lfalero.amqp.consumerentity.consumer;

import com.lfalero.amqp.consumerentity.model.entity.PersonEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {

    @JmsListener(destination = "${jms.queue.destination}")
    public void receive(Message message){

        if (message.getPayload() instanceof String){
            System.out.println("Recieved Message: " + message.getPayload().toString());
        } else if (message.getPayload() instanceof PersonEntity){
            System.out.println("Recieved Person: " + message.getPayload().toString());
        } else {
            System.err.println("Message Type Unkown !");
        }
    }
}
