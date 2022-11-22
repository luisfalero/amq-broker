package com.lfalero.amqp.producerentity.producer;

import com.lfalero.amqp.producerentity.model.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class JmsProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${jms.queue.destination}")
    String destinationQueue;

    public void send(String msg){
        jmsTemplate.convertAndSend(destinationQueue, msg);
    }

    public void send(PersonEntity p){
        jmsTemplate.convertAndSend(destinationQueue, p);
    }
}
