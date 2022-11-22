package com.lfalero.amqp.producerentity.producer;

import com.lfalero.amqp.producerentity.model.entity.PersonEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableJms
public class JmsProducerConsumer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${jms.queue.destination}")
    String destinationQueue;

    public void sendProducer(String personEntity){
        log.info("Send = [{}, {}]:", new Object[] {destinationQueue, personEntity});
        jmsTemplate.convertAndSend(destinationQueue, personEntity);
    }

    public void sendProducer(PersonEntity personEntity){
        log.info("Send = [{}, {}]:", new Object[] {destinationQueue, personEntity.toString()});
        jmsTemplate.convertAndSend(destinationQueue, personEntity);
    }
}
