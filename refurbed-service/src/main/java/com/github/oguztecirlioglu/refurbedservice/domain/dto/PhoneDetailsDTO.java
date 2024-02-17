package com.github.oguztecirlioglu.refurbedservice.domain.dto;

import com.github.oguztecirlioglu.refurbedservice.domain.enums.ProductType;
import com.github.oguztecirlioglu.refurbedservice.domain.enums.phoneEnums.PhoneManufacturer;
import lombok.Getter;
import lombok.Setter;

public class PhoneDetailsDTO extends ProductDetailsDTO {
    @Getter
    @Setter
    private PhoneManufacturer phoneManufacturer;

    @Setter
    @Getter
    private Integer memory;

    @Getter
    @Setter
    private String color;


    public PhoneDetailsDTO(ProductType productType, Float condition, String manufactureYear, PhoneManufacturer phoneManufacturer, Integer memory, String color) {
        super(productType, condition, manufactureYear);
        this.phoneManufacturer = phoneManufacturer;
        this.memory = memory;
        this.color = color;
    }
}
