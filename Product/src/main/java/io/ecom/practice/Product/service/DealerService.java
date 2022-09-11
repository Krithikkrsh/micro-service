package io.ecom.practice.Product.service;

import io.ecom.practice.Product.dto.ProductDealer;
import io.ecom.practice.Product.projections.OrderDto;

import java.util.List;
import java.util.Optional;

public interface DealerService {
    /**
     * This method is used to add Product dealers
     * @param dealer (ProductDealer.class)
     * @return Object-ProductDealer
     */
    String addDealer(ProductDealer dealer);

    /**
     * This method is used to get list of Product dealers
     * @return none
     */

    List<ProductDealer> getDealers();

    /**
     *
     * @param id (String)
     * @return Object-ProductDealer
     */

    Optional<ProductDealer> getDealerById(String id);

    /**
     *
     * @param dto (OrderDto.class)
     * @return string
     */

    String productOrder(OrderDto dto);
}
