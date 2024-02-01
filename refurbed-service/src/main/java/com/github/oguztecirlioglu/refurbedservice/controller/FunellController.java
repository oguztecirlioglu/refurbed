package com.github.oguztecirlioglu.refurbedservice.controller;

import com.github.oguztecirlioglu.refurbedservice.domain.enums.ProductType;
import com.github.oguztecirlioglu.refurbedservice.service.FunnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/model")
    List<String> models(ProductType productType) {
        List<String> models = new ArrayList<>();

        return models;
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
