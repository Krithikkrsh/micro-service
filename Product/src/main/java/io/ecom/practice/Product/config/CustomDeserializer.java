package io.ecom.practice.Product.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ecom.practice.Product.projections.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Slf4j
public class CustomDeserializer implements Deserializer<OrderDto> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public OrderDto deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                log.error("Null received at deserializing");
                return null;
            }
            log.info("Deserializing...");
            return objectMapper.readValue(new String(data, StandardCharsets.UTF_8), OrderDto.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to OrderDto");
        }
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
