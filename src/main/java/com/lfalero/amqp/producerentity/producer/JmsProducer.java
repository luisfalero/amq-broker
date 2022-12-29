package com.lfalero.amqp.producerentity.producer;

import com.lfalero.amqp.producerentity.model.entity.PersonEntity;
import com.lfalero.amqp.util.CommonsContants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.DeliveryMode;

@Slf4j
@Component
@EnableJms
public class JmsProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${jms.queue.destination2}")
    String destinationQueue;

    public void sendProducer(String personEntity){
        log.info("Send Producer String = [{}, {}]:", destinationQueue, personEntity);
        jmsTemplate.convertAndSend(destinationQueue, personEntity, message -> {
            message.setJMSExpiration(1000);
            message.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
            message.setStringProperty(CommonsContants.JMS_CUSTOM_HEADER_01, "This is a custom jms property v2");
            message.setBooleanProperty(CommonsContants.JMS_CUSTOM_HEADER_02, true);
            message.setDoubleProperty(CommonsContants.JMS_CUSTOM_HEADER_03, 2.0);
            log.info("Send Producer Message = [{}]:", message);
            return message;
        });
    }

    public void sendProducer(PersonEntity personEntity){
        log.info("Send Producer Entity = [{}, {}]:", destinationQueue, personEntity.toString());
        jmsTemplate.convertAndSend(destinationQueue, personEntity, message -> {
            message.setJMSExpiration(1000);
            message.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
            message.setStringProperty(CommonsContants.JMS_CUSTOM_HEADER_01, "This is a custom jms property v2");
            message.setBooleanProperty(CommonsContants.JMS_CUSTOM_HEADER_02, true);
            message.setDoubleProperty(CommonsContants.JMS_CUSTOM_HEADER_03, 2.0);
            log.info("Send Producer Message = [{}]:", message);
            return message;
        });
    }
}
