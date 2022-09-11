package io.ecom.practice.Product.controller;

import io.ecom.practice.Product.dao.DealerMapper;
import io.ecom.practice.Product.dto.ProductDealer;
import io.ecom.practice.Product.projections.OrderDto;
import io.ecom.practice.Product.service.Imp.DealerServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@RestController
@RequestMapping("/product/dealer")
@Slf4j
public class DealerController {

    @Autowired
    DealerServiceImp service;

    @Autowired
    DealerMapper mapper;

    @PostMapping("/add")
    public ResponseEntity<?> addDealer(@Valid @RequestBody ProductDealer dealer){
        Map<String,String> res = new HashMap<>();
        String msg = service.addDealer(dealer);
        res.put("response", dealer.getDealerName()+" successfully added!");
        res.put("status","200");
        res.put("id",msg);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("/get-dealer/{id}")
    public Optional<ProductDealer> getDealerById(@PathVariable("id") String id){
        return service.getDealerById(id);
    }

    @GetMapping("/get-dealers")
    public List<ProductDealer> getDealers(){
        return service.getDealers();
    }



}
