package com.github.oguztecirlioglu.refurbedservice.domain.dto;

import com.github.oguztecirlioglu.refurbedservice.domain.enums.ProductType;
import com.github.oguztecirlioglu.refurbedservice.domain.enums.computerEnums.ComputerManufacturer;
import lombok.Getter;
import lombok.Setter;

public class ComputerDetailsDTO extends ProductDetailsDTO {
    @Setter
    @Getter
    private ComputerManufacturer computerManufacturer;

    @Setter
    @Getter
    private Float screenSize;

    @Setter
    @Getter
    private Short storage;

    public ComputerDetailsDTO(ProductType productType, Float condition, String manufactureYear, ComputerManufacturer computerManufacturer, Float screenSize, Short storage) {
        super(productType, condition, manufactureYear);
        this.computerManufacturer = computerManufacturer;
        this.screenSize = screenSize;
        this.storage = storage;
    }
}
