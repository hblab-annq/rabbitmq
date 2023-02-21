package com.example.productservice.controller;

import com.example.productservice.consumer.ProductConsumer;
import com.example.productservice.publisher.ProductPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductPublisher productPublisher;

    @Autowired
    ProductConsumer productConsumer;

    @GetMapping
    public String demo() {
        return productPublisher.demoPub();
    }
}
