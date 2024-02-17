package com.github.oguztecirlioglu.refurbedservice.domain.dto;

import com.github.oguztecirlioglu.refurbedservice.domain.Computer;
import com.github.oguztecirlioglu.refurbedservice.domain.Phone;
import com.github.oguztecirlioglu.refurbedservice.domain.enums.ProductType;
import lombok.Getter;
import lombok.Setter;

abstract public class ProductDetailsDTO {
    @Setter
    @Getter
    private ProductType productType;

    @Setter
    @Getter
    private Float condition;

    @Setter
    @Getter
    private String manufactureYear;

    public ProductDetailsDTO(ProductType productType, Float condition, String manufactureYear) {
        this.productType = productType;
        this.condition = condition;
        this.manufactureYear = manufactureYear;
    }
}
