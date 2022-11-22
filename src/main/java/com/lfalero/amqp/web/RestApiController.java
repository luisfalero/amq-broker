package com.lfalero.amqp.web;

import com.lfalero.amqp.producerentity.model.entity.PersonEntity;
import com.lfalero.amqp.producerentity.producer.JmsProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @RequestMapping(value="/produce", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public String produce(@RequestBody PersonEntity p){
        producer.send(p);
        return "Send Person Done" + p.toString();
    }

    @RequestMapping(value="/produce2")
    public String produce2(@RequestParam("msg") String msg){
        producer.send2(msg);
        return "Done2";
    }

    @RequestMapping(value="/produce2", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public String produce2(@RequestBody PersonEntity p){
        producer.send2(p);
        return "Send Person Done2" + p.toString();
    }
}
