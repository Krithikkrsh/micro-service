package io.ecom.practice.Product.service.Imp;

import io.ecom.practice.Product.dao.DealerMapper;
import io.ecom.practice.Product.dao.OrderMapper;
import io.ecom.practice.Product.dao.ProductMapper;
import io.ecom.practice.Product.dto.ProductDealer;
import io.ecom.practice.Product.dto.ProductDetailDto;
import io.ecom.practice.Product.dto.ProductOrder;
import io.ecom.practice.Product.projections.OrderDto;
import io.ecom.practice.Product.service.DealerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class DealerServiceImp implements DealerService {

    @Autowired
    DealerMapper mapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public String addDealer(ProductDealer dealer){
        String id = String.valueOf(Math.abs(dealer.hashCode()+dealer.getDealerPhoneNumber().hashCode()));
        dealer.setDealerID(id);
        dealer.setCreatedAt(Timestamp.from(Instant.now()));
        dealer.setUpdatedAt(Timestamp.from(Instant.now()));
        dealer.getDealerAddress().setCreatedAt(Timestamp.from(Instant.now()));
        dealer.getDealerAddress().setUpdatedAt(Timestamp.from(Instant.now()));
        dealer.setDealerPassword(BCrypt.hashpw(dealer.getDealerPassword(),BCrypt.gensalt()));
        String msg = "Your Account has been created with Dealer-id: "+dealer.getDealerID();
        mapper.addDealer(dealer);
        mapper.addAddress(dealer.getDealerAddress(), dealer.getDealerID());
        return msg;
    }

    @Override
    public List<ProductDealer> getDealers() {
        return mapper.getDealers();
    }

    @Override
    public Optional<ProductDealer> getDealerById(String id) {
        return mapper.getDealerById(id);
    }

    @Override
    public String productOrder(OrderDto dto) {
        String dealerId = productMapper.getDealerId(dto.getProductId());
        ProductOrder p = new ProductOrder();
        p.setDealerId(dealerId);
        p.setProductId(dto.getProductId());
        p.setDelivered(false);
        p.setOrderedAt(dto.getCreatedAt());
        p.setTotalAmt(dto.getQuantity()*productMapper.getPrice(dto.getProductId()));
        p.setSize(dto.getSize());
        p.setQuantity(dto.getQuantity());
        orderMapper.addOrder(p);
        return dto.getProductId()+" have been ordered to dealer "+dealerId;
    }


}
