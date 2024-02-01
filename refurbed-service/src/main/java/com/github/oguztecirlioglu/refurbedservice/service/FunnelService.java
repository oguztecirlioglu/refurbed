package com.github.oguztecirlioglu.refurbedservice.service;

import com.github.oguztecirlioglu.refurbedservice.domain.enums.ProductType;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FunnelService {

    public List<ProductType> getProductTypes() {
        return Arrays.asList(ProductType.values());
    }

}
