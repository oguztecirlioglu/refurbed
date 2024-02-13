package com.github.oguztecirlioglu.refurbedservice.domain.dto;

import com.github.oguztecirlioglu.refurbedservice.domain.enums.phoneEnums.PhoneManufacturer;
import lombok.Getter;
import lombok.Setter;

public class PhoneDetailsDTO extends ProductDetailsDTO {
    @Getter
    @Setter
    private PhoneManufacturer phoneManufacturer;

    @Setter
    @Getter
    private Short memory;

    @Getter
    @Setter
    private String color;

}
