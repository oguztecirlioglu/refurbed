package com.github.oguztecirlioglu.refurbedservice.service;

import com.github.oguztecirlioglu.refurbedservice.domain.Product;
import com.github.oguztecirlioglu.refurbedservice.domain.enums.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FunnelService {

    @Autowired
    PhoneService phoneService;

    @Autowired
    ComputerService computerService;

    public List<ProductType> getProductTypes() {
        return Arrays.asList(ProductType.values());
    }

    public List<Product> getComputers() {
        return new ArrayList<>(computerService.getAllComputers());
    }

    public List<Product> getPhones() {
        return new ArrayList<>(phoneService.getAllPhones());
    }

}
