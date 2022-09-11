package io.ecom.practice.User.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.ecom.practice.User.config.CustomSerializer;
import io.ecom.practice.User.dto.OrderDto;
import io.ecom.practice.User.service.OrderService;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Properties;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService service;


    @PostMapping("/place-order")
    public ResponseEntity<?> createOrder(@RequestBody OrderDto order){
        System.out.println(order);
        service.addOrder(order);
        return ResponseEntity.ok("success!");
    }





}
