package io.ecom.practice.Product.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.ecom.practice.Product.dto.ProductDetailDto;
import io.ecom.practice.Product.projections.ProductRated;
import io.ecom.practice.Product.projections.ProductResponse;
import io.ecom.practice.Product.service.ProductCrudService;
import io.ecom.practice.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @Autowired
    ProductCrudService crudService;

    @GetMapping("/hello")
    public String hello(){
        return "Hi I Am Product Working Fine";
    }

    @GetMapping("/getProducts")
    public List<ProductRated> getProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/getProductById")
    @HystrixCommand(fallbackMethod = "fallback")
    public ProductResponse getProductById(@RequestParam("id") int id) throws Exception{
        return service.getProductById(id);
    }

    public ProductResponse fallback(@RequestParam("id") int id){
        return new ProductResponse("Empty Product Server not found",0,null);
    }

    @PostMapping("/add-product/{id}")
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDetailDto productDetailDto,@PathVariable("id") String id){
        int n = crudService.addProduct(productDetailDto,id);
        Map<String,Object> response = new HashMap<>();
        response.put("status","success");
        response.put("request","add-product");
        response.put("id",id);
        response.put("product-status",n+" products added!");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/add-products/{id}")
    public ResponseEntity<?> addProducts(@RequestBody List<ProductDetailDto> products,@PathVariable("id") String id){
        int n = crudService.addProducts(products,id);
        Map<String,Object> response = new HashMap<>();
        response.put("status","success");
        response.put("request","add-product");
        response.put("id",id);
        response.put("product-status",n+" products added!");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
