package com.lfalero.amqp.web;

import com.lfalero.amqp.producerentity.model.entity.PersonEntity;
import com.lfalero.amqp.producerentity.producer.JmsProducerConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("producer-consumer")
public class ProducerConsumerApiController {

    @Autowired
    JmsProducerConsumer producer;

    @PostMapping(value="/example-string", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String producerExample1(@RequestBody String personEntity){
        producer.sendProducer(personEntity);
        return "Send Person String = " + personEntity;
    }

    @PostMapping(value="/example-json", consumes = MediaType.TEXT_PLAIN_VALUE)
    public String producerExample2(@RequestBody PersonEntity personEntity){
        producer.sendProducer(personEntity);
        return "Send Person Done = " + personEntity.toString();
    }
}
