package com.github.oguztecirlioglu.refurbedservice.controller;

import com.github.oguztecirlioglu.refurbedservice.domain.Product;
import com.github.oguztecirlioglu.refurbedservice.domain.enums.ProductType;
import com.github.oguztecirlioglu.refurbedservice.service.FunnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/funnelService")
public class FunellController {
    /* Device type: Phone vs Computer -> fetch and pick a model (iphone 12, macbook air, etc.)
                                      -> fetch and pick storage capacity
                                      -> fetch and pick condition (good, bad, mid)
     */


    @Autowired
    FunnelService funnelService;

    @GetMapping("/productType")
    List<ProductType> getProductTypes() {
        return funnelService.getProductTypes();
    }

    @PostMapping("/model")
    List<Product> models(@RequestBody ProductType productType) {
        return switch (productType) {
            case COMPUTER -> funnelService.getComputers();
            case PHONE -> funnelService.getPhones();
        };
    }

    @GetMapping("/storageCapacity")
    List<String> storageCapacity(String model) {
        List<String> storageCapacity = new ArrayList<>();

        return storageCapacity;
    }

    @GetMapping("/condition")
    List<String> condition(String storageCapacity) {
        List<String> condition = new ArrayList<>();

        return condition;
    }
}
