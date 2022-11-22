package com.lfalero.amqp.web;

import com.lfalero.amqp.producerentity.model.entity.PersonEntity;
import com.lfalero.amqp.producerentity.producer.JmsProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
public class RestApiController {

    @Autowired
    JmsProducer producer;

    @RequestMapping(value="/produce")
    public String produce(@RequestParam("msg") String msg){
        producer.send(msg);
        return "Done";
    }

    @RequestMapping(value="/produce", method = RequestMethod.POST)
    public String produce(@RequestBody PersonEntity p){
        producer.send(p);
        return "Send Person Done" + p.toString();
    }
}
