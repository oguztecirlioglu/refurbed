package com.github.oguztecirlioglu.refurbedservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FunellController {
    /* Device type: Phone vs Computer -> fetch and pick a model (iphone 12, macbook air, etc.)
                                      -> fetch and pick storage capacity
                                      -> fetch and pick condition (good, bad, mid)
     */

    @GetMapping
    List<String> model(String deviceType) {
        List<String> models = new ArrayList<>();

        return models;
    }

    @GetMapping
    List<String> storageCapacity(String model) {
        List<String> storageCapacity = new ArrayList<>();

        return storageCapacity;
    }

    @GetMapping
    List<String> condition(String storageCapacity) {
        List<String> condition = new ArrayList<>();

        return condition;
    }
}
