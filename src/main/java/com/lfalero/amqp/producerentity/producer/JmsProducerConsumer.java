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
        log.info("Send Producer String = [{}, {}]:", new Object[] {destinationQueue, personEntity});
        jmsTemplate.convertAndSend(destinationQueue, personEntity, message -> {
            message.setJMSExpiration(1000);
            message.setStringProperty("jms-custom-header", "This is a custom jms property v1");
            message.setBooleanProperty("jms-custom-property", true);
            message.setDoubleProperty("jms-custom-property-price", 1.0);
            return message;
        });
    }

    public void sendProducer(PersonEntity personEntity){
        log.info("Send Producer Entity = [{}, {}]:", new Object[] {destinationQueue, personEntity.toString()});
        jmsTemplate.convertAndSend(destinationQueue, personEntity, message -> {
            message.setJMSExpiration(1000);
            message.setStringProperty("jms-custom-header", "This is a custom jms property v1");
            message.setBooleanProperty("jms-custom-property", true);
            message.setDoubleProperty("jms-custom-property-price", 1.0);
            return message;
        });
    }
}
