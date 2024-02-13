package com.github.oguztecirlioglu.refurbedservice.controller;

import com.github.oguztecirlioglu.refurbedservice.domain.Product;
import com.github.oguztecirlioglu.refurbedservice.domain.Quotation;
import com.github.oguztecirlioglu.refurbedservice.domain.dto.ComputerDetailsDTO;
import com.github.oguztecirlioglu.refurbedservice.domain.dto.PhoneDetailsDTO;
import com.github.oguztecirlioglu.refurbedservice.domain.dto.ProductTypeDTO;
import com.github.oguztecirlioglu.refurbedservice.domain.enums.ProductType;
import com.github.oguztecirlioglu.refurbedservice.service.FunnelService;
import com.github.oguztecirlioglu.refurbedservice.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funnelService")
public class FunnelController {
    /* Device type: Phone vs Computer -> fetch and pick a model (iphone 12, macbook air, etc.)
                                      -> fetch and pick storage capacity
                                      -> fetch and pick condition (good, bad, mid)
     */


    @Autowired
    FunnelService funnelService;

    @Autowired
    QuotationService quotationService;

    @GetMapping("/productType")
    List<ProductType> getProductTypes() {
        return funnelService.getProductTypes();
    }

    @PostMapping("/model")
    List<Product> models(@RequestBody ProductTypeDTO productTypeDTO) {
        ProductType productType = productTypeDTO.getType();
        return switch (productType) {
            case COMPUTER -> funnelService.getComputers();
            case PHONE -> funnelService.getPhones();
        };
    }

    @PostMapping("/quotePrice/phone")
    Quotation quotePrice(@RequestBody PhoneDetailsDTO phoneDetailsDTO) throws Exception {
        return quotationService.generateQuote(phoneDetailsDTO);
    }

    @PostMapping("/quotePrice/computer")
    Quotation quotePrice(@RequestBody ComputerDetailsDTO computerDetailsDTO) throws Exception {
        return quotationService.generateQuote(computerDetailsDTO);
    }

}
