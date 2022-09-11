package io.ecom.practice.User.config;

import com.fasterxml.jackson.databind.JsonSerializable;
import io.ecom.practice.User.dto.OrderDto;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class KafkaConfig {

    @Bean
    public KafkaTemplate<String, OrderDto > kafkaTemplate(){
        return new KafkaTemplate<String, OrderDto>(productFactory());
    }

    @Bean
    public ProducerFactory<String,OrderDto > productFactory(){
        Map<String,Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"io.ecom.practice.User.config.CustomSerializer");
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    /*private static KafkaProducer<String, OrderDto> createKafkaProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CustomSerializer.class);

        return new KafkaProducer(props);
    }*/

    /*KafkaProducer<String, OrderDto> producer = createKafkaProducer();
        producer.send(new ProducerRecord<String, OrderDto>(TOPIC, "1", order));
        System.out.println("Message sent " + order);
        producer.close();*/
}
