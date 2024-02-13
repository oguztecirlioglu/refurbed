package com.github.oguztecirlioglu.refurbedservice.domain.dto;

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
}
