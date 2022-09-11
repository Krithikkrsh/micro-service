package io.ecom.practice.User.service.Imp;

import io.ecom.practice.User.dao.OrderMapper;
import io.ecom.practice.User.dto.OrderDto;
import io.ecom.practice.User.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    OrderMapper mapper;

    @Autowired
    private KafkaTemplate<String,OrderDto> messenger;

    @Override
    public void addOrder(OrderDto dto) {
        mapper.addOrder(dto);
        messenger.send("test",dto);
    }
}
