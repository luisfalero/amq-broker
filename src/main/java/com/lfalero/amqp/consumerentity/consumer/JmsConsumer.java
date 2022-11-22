package com.lfalero.amqp.consumerentity.consumer;

import com.lfalero.amqp.consumerentity.model.entity.PersonEntity;
import com.lfalero.amqp.util.CommonsContants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JmsConsumer {

    @JmsListener(destination = "${jms.queue.destination}")
    public void receive(Message message, MessageHeaders messageHeaders){

        log.info("Message Payload = [{}]:", message.getPayload());
        log.info("Customer Header = [{}, {}]:", CommonsContants.JMS_CUSTOM_HEADER_01, messageHeaders.get(CommonsContants.JMS_CUSTOM_HEADER_01));
        log.info("Customer Header = [{}, {}]:", CommonsContants.JMS_CUSTOM_HEADER_02, messageHeaders.get(CommonsContants.JMS_CUSTOM_HEADER_02, Boolean.class));
        log.info("Customer Header = [{}, {}]:", CommonsContants.JMS_CUSTOM_HEADER_03, messageHeaders.get(CommonsContants.JMS_CUSTOM_HEADER_03, Double.class));

        if (message.getPayload() instanceof String){
            log.info("Recieved Message String = [{}]:", message.getPayload());

        } else if (message.getPayload() instanceof PersonEntity){
            log.info("Recieved Message Entity = [{}]:", message.getPayload());

        } else {
            log.info("Message Type Unkown !");
        }
    }
}
