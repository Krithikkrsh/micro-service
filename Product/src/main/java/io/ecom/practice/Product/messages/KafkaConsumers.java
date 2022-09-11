package io.ecom.practice.Product.messages;

import io.ecom.practice.Product.config.CustomDeserializer;
import io.ecom.practice.Product.projections.OrderDto;
import io.ecom.practice.Product.service.DealerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Properties;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Component
@Slf4j
public class KafkaConsumers {

    /*private static KafkaConsumer<String, OrderDto> createKafkaConsumer() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "io.ecom.practice.Product.config.CustomDeserializer");

        return new KafkaConsumer<>(props);
    }*/

    @Autowired
    DealerService service;

    @KafkaListener(topics = "test",groupId = "consumer-group",containerFactory = "userKafkaListenerContainerFactory")
    public void consume(OrderDto orderDto) {
        String n = service.productOrder(orderDto);
        log.info(n);
    }



}
